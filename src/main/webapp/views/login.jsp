<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login Application</title>

    <script type="text/javascript" src="/scripts/jquery-1.11.2.min.js"> </script>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    <script>
        function validateForm() {
            var user= document.getElementById('userid').value;
            var pwd=document.getElementById('pswrd').value;
            var username = "${name}";
            var password = "${password}";
            if ((user == username) && (pwd == password)) {
                return true;
            }
            else {
                alert ("Login was unsuccessful, please check your username and password");
                return false;
            }
        }
    </script>


    <link rel="stylesheet" href="/css/login.css">
</head>
<body>

<form  action="/login" method="POST"  >
    <div class="container">
        <div class="login-container">
            <div id="output"></div>
            <div class="avatar"></div>
            <div class="form-box">
                <p id ="r" name="m"> </p>
                <form >
                    <input name="username" type="text" placeholder="username" required="required" id="userid" >
                    <input name="userpass" type="password" placeholder="password"  required="required" id="pswrd">
                    <button class="btn btn-info btn-block login" type="submit" id="login" onclick="return validateForm();">Login</button>
                </form>
            </div>
        </div>
    </div>

</form>


</body>
</html>