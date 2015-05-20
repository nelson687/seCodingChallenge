package com.secretescapes

class Transaction {

    String detail
    BigDecimal amount
    Date dateCreated
    Date lastUpdated

    Account account;

    static constraints = {
    }
}
