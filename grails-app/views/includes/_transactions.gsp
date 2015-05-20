Balance: ${accountBalance}
<div>
    Transactions
</div>
<div>
    <table border="1">
        <thead>
            <tr>
                <th>Transaction ID</th>
                <th>Detail</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${transactions}">
                <tr>
                    <td>${it.id}</td>
                    <td>${it.detail}</td>
                    <td>${it.amount}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>