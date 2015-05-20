package com.secretescapes

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PaymentController)
class PaymentControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }

    void "test payment fails when trying to transfer money to same accounts"(){
        setup:
            controller.setPaymentService(Mock(PaymentService))
            def paymentForm = new PaymentForm(originAccount: "1", destinationAccount: "1", amount: 150)
            paymentForm.setPaymentService(Mock(PaymentService))
        when: "controller pay action is invoked"
            paymentForm.validate()
            controller.pay(paymentForm)
        then: "expect error message"
            view == "/payment/pay"
            paymentForm.hasErrors()
    }

    void "test payment fails when trying to transfer an amount greater than the current balance"(){
        setup:
        controller.setPaymentService(Mock(PaymentService))
        def paymentForm = new PaymentForm(originAccount: "1", destinationAccount: "2", amount: 300)
        paymentForm.setPaymentService(Mock(PaymentService))
        when: "controller pay action is invoked"
        paymentForm.validate()
        controller.pay(paymentForm)
        then: "expect error message"
        view == "/payment/pay"
        paymentForm.hasErrors()
    }
}
