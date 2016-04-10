<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Theme Company</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
     <link rel="stylesheet" href="/css/login.css">

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


</head>
<body>

<div class="jumbotron text-center">
    <h1>Veterinary Hospital</h1>
    <p>We specialize in helping animal</p>
</div>


<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form" action="/login" method="POST" >
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Login" name="username" type="text" id="userid">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="userpass" type="password" required="required"  value="" id="pswrd">
                            </div>

                            <input class="btn btn-lg btn-success btn-block" type="submit"  required="required"  value="Login" id="login" onclick="return validateForm();">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>