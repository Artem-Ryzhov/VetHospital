<%--
  Created by IntelliJ IDEA.
  User: артем
  Date: 07.04.16
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Simple jsp page</title>

    <script type="text/javascript" src="/scripts/jquery-1.11.2.min.js"> </script>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="/css/sort.css">
    <link rel="stylesheet" href="/css/menu.css">

</head>
<body>


<ul>
    <li><a class="active" href="/views/menu.jsp">Home</a></li>
    <li><a href="#about">About</a></li>
</ul>



<div class="container">
    <form class="form-horizontal" role="form" action="${pageContext.servletContext.contextPath}/sortbytype" method="post">



        <div class="form-group">
              <div id = "reg"> <h2>Choice  Animal  </h2> </div>
            <label for="animal" class="col-sm-3 control-label">Animal</label>
            <div class="col-sm-9">
                <select id="animal" class="form-control"  onchange="bree()" name="animal" required="required">
                    <option onclick="">Выберите животного</option>
                    <c:forEach var="pets" items="${pets}" >
                        <option value="${pets.id}" >
                            <c:out value="${pets.getName()}"/></option>
                    </c:forEach>

                </select>
            </div>
        </div> <!-- /.form-group -->


        <div class="form-group">
            <div class="col-sm-9 col-sm-offset-3">
                <button type="submit" class="btn btn-primary btn-block">Show</button>
            </div>
        </div>

    </form> <!-- /form -->
</div> <!-- ./container -->


</body>
</html>