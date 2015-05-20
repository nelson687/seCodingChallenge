package com.secretescapes

import grails.transaction.Transactional

@Transactional
class PaymentService {

    def mailService

    def hasEnoughFunds(accountId, amount) {
        def account = Account.findById(accountId)
        def value = account.balance.compareTo(amount)
        if(value >= 0){
            true
        }else{
            false
        }
    }

    def makeTransfer(originAccountId, destinationAccountId, amount){
        def originAccount = Account.findById(originAccountId)
        def destinationAccount = Account.findById(destinationAccountId)
        originAccount.balance = originAccount.balance - amount
        destinationAccount.balance = destinationAccount.balance + amount
        originAccount.save(flush: true)
        destinationAccount.save(flush: true)
        Transaction transactionOrigin = new Transaction(detail: "money out", amount: amount, account: originAccount)
        Transaction transactionDestination = new Transaction(detail: "money in", amount: amount, account: destinationAccount)
        transactionOrigin.save(flush: true)
        transactionDestination.save(flush: true)
    }

    def getAccountName(accountId){
        Account.findById(accountId).name
    }

    @grails.events.Listener
    def confirmationEmail(form){
        def originAccount = Account.findById(form.originAccount)
        def destinationAccount = Account.findById(form.destinationAccount)

        mailService.sendMail{
            to originAccount.emailAddress
            subject "Payment Confirmation"
            body "Your payment of ${form.amount} has been done to ${destinationAccount.name}"
        }
        mailService.sendMail{
            to destinationAccount.emailAddress
            subject "Payment Confirmation"
            body "You have received a payment of ${form.amount} from ${originAccount.name}"
        }


    }
}
