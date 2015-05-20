import com.secretescapes.Account
import com.secretescapes.Transaction

class BootStrap {

    def init = { servletContext ->

        Account account = new Account(name: "Nelson's Account", emailAddress: "person@email.com").save(flush: true)
        Account account1 = new Account(name: "Jorge's Account", emailAddress: "person1@email.com").save(flush: true)

        Transaction transaction = new Transaction(detail: "money in", amount: 100, account: account).save(flush: true)
        Transaction transaction1 = new Transaction(detail: "money out", amount: 100, account: account).save(flush: true)


    }
    def destroy = {
    }
}
