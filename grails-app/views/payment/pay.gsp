<%@ page import="com.secretescapes.Account" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pay Some Person</title>
    </head>
    <body>
    <g:hasErrors bean="${paymentForm}">
        <g:eachError bean="${paymentForm}">
            <p style="color: red;"><g:message error="${it}"/></p>
        </g:eachError>
    </g:hasErrors>

    <div>
            <h2>Pay</h2>
            <br/>
            <g:form name="payment" controller="payment" action="pay" method="POST" role="form">
                <b>From:</b>
                <g:select optionKey="id" optionValue="name" name="originAccount" from="${Account.list()}" value="${paymentForm.originAccount}" noSelection="['':'Select an account']" />
                <br/>
                <b>To:</b>
                <g:select name="destinationAccount" from="${Account.list()}" optionKey="id" optionValue="name" value="${paymentForm.destinationAccount}" noSelection="['':'Select an account']"/>
                <br/>
                <label for="amount">Amount: </label>
                <input id="amount" name="amount" placeholder="Amount to Transfer" value="${paymentForm.amount}">
                <br/>
                <button type="submit" id="submit">Pay</button>
            </g:form>
         </div>
        <a href="/">Back to home</a>
    </body>
</html>