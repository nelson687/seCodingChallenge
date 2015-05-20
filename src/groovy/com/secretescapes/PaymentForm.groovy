package com.secretescapes

import grails.validation.Validateable

import java.text.Bidi

/**
 * Created by root on 15/05/15.
 */
@Validateable
class PaymentForm {
    String originAccount
    String destinationAccount
    BigDecimal amount
    def paymentService

    static constraints = {
        originAccount blank: false, validator: {val, obj ->
            if(val == obj.destinationAccount){
                return('accounts.sameid')
            }
            true
        }
        destinationAccount blank: false
        amount validator: {val, obj ->
            if(!obj.paymentService.hasEnoughFunds(obj.originAccount, val)){
                return('accounts.notenoughfunds')
            }else{
                true
            }
        }
    }
}
