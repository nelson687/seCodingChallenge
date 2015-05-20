package com.secretescapes

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TransactionController)
@Mock([Account, Transaction])
class TransactionControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test get transactions"() {
            setup:
                Transaction transaction = new Transaction(name: "first transaction", amount: 200)
                Transaction transaction1 = new Transaction(name: "second transaction", amount: 200)
                Account account = new Account(name: "Nelson's Account", emailAddress: "person@email.com").save(flush: true)
                transaction.account = account
                transaction1.account = account
                transaction.save(flush: true)
                transaction1.save(flush: true)
            when: "controller get transaction action is invoked"
                views['/includes/_transactions.gsp'] = 'template rendered'
                params.account = account.id
                controller.getTransactions()
            then: "render transactions page"
                response.text == 'template rendered'
    }
}
