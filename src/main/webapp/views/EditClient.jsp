<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="/css/style.css">

<script>

    function onch(){
        var country_id = document.getElementById('country').value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                document.getElementById("city").innerHTML = xhttp.responseText;
            }
        };
        xhttp.open("GET","/addcity?id="+ country_id, true)
        xhttp.send();
    }

    function bree(){
        var animal_id = document.getElementById('animal').value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                document.getElementById("breed").innerHTML = xhttp.responseText;
            }
        };
        xhttp.open("GET","/addbreed?id="+ animal_id, true)
        xhttp.send();
    }

</script>





<div class="container">
    <form class="form-horizontal" role="form" action="${pageContext.servletContext.contextPath}/updateclient" method="post"  onsubmit="return check_info();">

        <div id = "reg"> <h2>Edit</h2> </div>

        <div class="form-group">
            <label for="firstName" class="col-sm-3 control-label"> Name</label>
            <div class="col-sm-9">
                <input type="text" name="name" id="firstName" placeholder="Full Name" class="form-control" value = "${client.getName()}" autofocus>
            </div>
        </div>


        <div class="form-group">
            <label for="firstName" class="col-sm-3 control-label">Last Name</label>
            <div class="col-sm-9">
                <input type="text" id="lastname" placeholder="Full Name" class="form-control" name="lastname" value = "${client.getLastname()}" autofocus>
            </div>
        </div>


        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">Phone</label>
            <div class="col-sm-9">
                <input type="text" id="phone"  name="phone" placeholder="Phone" class="form-control" value = "${client.getPhone()}">
            </div>
        </div>



        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">Email</label>
            <div class="col-sm-9">
                <input type="email" id="email"  name="email" placeholder="Email" class="form-control" value = "${client.getEmail()}">
            </div>
        </div>







        <div class="form-group">
            <label for="country" class="col-sm-3 control-label">Country</label>
            <div class="col-sm-9">
                <select id="country" class="form-control"  onchange="onch()" name="id">
                    <option onclick="">Выберите Страну</option>
                    <c:forEach var="country" items="${country}" >
                        <option value="${country.id}" >
                            <c:out value="${country.county_name}"/></option>
                    </c:forEach>

                </select>
            </div>
        </div> <!-- /.form-group -->


        <div class="form-group">
            <label for="country" class="col-sm-3 control-label">City</label>
            <div class="col-sm-9">
                <select id="city" class="form-control" name="cit">
                    <option>

                    </option>

                </select>
            </div>
        </div> <!-- /.form-group -->




        <div class="form-group">
            <label for="country" class="col-sm-3 control-label">Animal</label>
            <div class="col-sm-9">
                <select id="animal" class="form-control"  onchange="bree()" name="animal">
                    <option onclick="">Выберите животного</option>
                    <c:forEach var="pets" items="${pets}" >
                        <option value="${pets.id}" >
                            <c:out value="${pets.getName()}"/></option>
                    </c:forEach>

                </select>
            </div>
        </div> <!-- /.form-group -->


        <div class="form-group">
            <label for="country" class="col-sm-3 control-label">Breed</label>
            <div class="col-sm-9">
                <select id="breed" class="form-control" name="bre">
                    <option>

                    </option>

                </select>
            </div>
        </div> <!-- /.form-group -->



        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block">Edit</button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->




