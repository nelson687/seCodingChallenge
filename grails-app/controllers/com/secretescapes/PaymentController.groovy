package com.secretescapes

class PaymentController {

    def paymentService

    def index() {
        PaymentForm paymentForm
        if(!paymentForm){
            paymentForm = new PaymentForm()
        }
        render (view: "/payment/pay", model: [paymentForm: paymentForm])
    }

    def pay(PaymentForm paymentForm){
        if(paymentForm.hasErrors()){
            render view: '/payment/pay', model: [paymentForm: paymentForm]
        }else{
            paymentService.makeTransfer(paymentForm.originAccount, paymentForm.destinationAccount, paymentForm.amount)
            event("confirmationEmail", paymentForm)
            render view: '/payment/confirmation', model: [originAccount: paymentService.getAccountName(paymentForm.originAccount), destinationAccount: paymentService.getAccountName(paymentForm.destinationAccount), amount: paymentForm.amount]
        }
    }
}
