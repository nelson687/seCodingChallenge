package com.secretescapes

class Account {


    String name;
    BigDecimal balance = 200;
    String emailAddress

    Date dateCreated
    Date lastUpdated

    static hasMany = [transactions : Transaction]
    static constraints = {
        emailAddress email: true
    }
}
