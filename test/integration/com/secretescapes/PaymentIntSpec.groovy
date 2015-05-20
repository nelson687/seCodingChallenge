package com.secretescapes



import spock.lang.*

/**
 *
 */
class PaymentIntSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test I can make a transfer between two different accounts"(){
        setup:
            def controller = new PaymentController()
            def paymentForm = new PaymentForm(originAccount: "1", destinationAccount: "2", amount: 100)
            def originAccount = Account.findById("1")
            def destinationAccount = Account.findById("2")
        when: "controller pay action is invoked"
            controller.pay(paymentForm)
        then: "payment done and no error displayed"
            originAccount.balance == 100
            destinationAccount.balance == 300
    }
}
