<%@ page import="com.secretescapes.Account" %>
<html>
<head>
    <title>See transactions</title>
    <g:javascript library='jquery' />
    <r:layoutResources/>
</head>
<body>
<div>
    <h2>Pay</h2>
    <br/>
    <b>Person:</b>
    <g:select optionKey="id" optionValue="name" name="accounts"
              from="${Account.list()}" noSelection="['':'Select an account']" onchange="${remoteFunction (
            controller: 'transaction',
            action: 'getTransactions',
            params: '\'account=\' + this.value',
            update: 'transactionsTable'
    )}"/>
    <br/>
    ­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­­
    <div id="transactionsTable">
        Balance: --
        <div>
            Transactions
        </div>
    </div>
</div>
<a href="/">Back to home</a>
<r:layoutResources/>
</body>
</html>