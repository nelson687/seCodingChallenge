package com.secretescapes

class TransactionController {

    def index() {
        render (view: "/payment/transactions")
    }

    def getTransactions(){
        if(params.account){
            def account = Account.findById(params.account)
            def transactions = Transaction.findAllByAccount(account)
            render(template: '/includes/transactions', model: [transactions: transactions, accountBalance: account.balance])
        }

    }
}
