package com.secretescapes

import com.icegreen.greenmail.util.GreenMailUtil
import grails.plugin.greenmail.GreenMail
import grails.plugin.mail.MailService
import grails.test.mixin.integration.Integration
import spock.lang.*

/**
 *
 */
class EmailTestsSpec extends Specification {

    def mailService
    def greenMail
    def paymentService

    void "test email sending"() {

        setup:
            Map mail = [message:'testing email', from:'sender@email.com.com', to:'receiver@email.com', subject:'subject']
        when:
            mailService.sendMail {
                to mail.to
                from mail.from
                subject mail.subject
                body mail.message
            }
        then:
            greenMail.getReceivedMessages().length == 1
            def message = greenMail.getReceivedMessages()[0]
            GreenMailUtil.getBody(message) == mail.message
            mail.from == GreenMailUtil.getAddressList(message.from)
            mail.subject == message.subject
    }
}
