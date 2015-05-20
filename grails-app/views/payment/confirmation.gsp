<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 15/05/15
  Time: 19:09
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Payment Confirmation</title>
</head>

<body>
    <h2>Payment Completed</h2>
    <h3>Details:</h3>
    <p>Origin Account: ${originAccount}</p>
    <p>Destination Account: ${destinationAccount}</p>
    <p>Amount: ${amount}</p>

    <a href="/">Back to home</a>
</body>
</html>