package com.secretescapes

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PaymentService)
@Mock([Account, Transaction])
class PaymentServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test account hasn't enough funds"() {
        setup:
            def account = new Account(name: "nelson", balance: 150, emailAddress: "nelson@nelson.com").save(flush: true)
        when: "hasEnoughFunds method is invoked"
            def result = service.hasEnoughFunds("1", 250)
        then: "expect false value meaning that the account hasn't enough funds"
            result == false
    }

    void "test account has enough funds"() {
        setup:
        def account = new Account(name: "nelson", balance: 200, emailAddress: "nelson@nelson.com").save(flush: true)
        when: "hasEnoughFunds method is invoked"
        def result = service.hasEnoughFunds("1", 190)
        then: "expect true value meaning that the account has enough funds"
        result == true
    }

    void "test that the transfer can be done"() {
        setup:
            def originAccount = new Account(name: "nelson1", balance: 200, emailAddress: "nelson@nelson.com").save(flush: true)
            def destinationAccount = new Account(name: "nelson2", balance: 200, emailAddress: "nelson@nelson.com").save(flush: true)
        when: "makeTransfer method is invoked"
            service.makeTransfer(originAccount.id, destinationAccount.id, 150)
        then: "origin account should have 150 less and destination account 150 more"
            originAccount.balance == 50
            destinationAccount.balance == 350
    }
}
