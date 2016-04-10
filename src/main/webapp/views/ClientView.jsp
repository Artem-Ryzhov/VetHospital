<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/table.css">
<link rel="stylesheet" href="/css/menu.css">



<ul>
    <li><a class="active" href="/views/menu.jsp">Back To Menu</a></li>
    <li><a href="#about">About</a></li>
</ul>




<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <tr>
                <th>ID:</th>
                <th>Name:</th>
                <th>Lastname:</th>
                <th>Phone:</th>
                <th>Email:</th>
                <th>Country:</th>
                <th>City:</th>
                <th>Animal:</th>
                <th>Breed:</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <c:forEach items="${client}" var="client" varStatus="status">
                <tr>
                    <td>${client.getId()}</td>
                    <td>${client.getName()}</td>
                    <td>${client.getLastname()}</td>
                    <td>${client.getPhone()}</td>
                    <td>${client.getEmail()}</td>
                    <td>${client.getCountry()}</td>
                    <td>${client.getCity()}</td>
                    <td>${client.getAnimal()}</td>
                    <td>${client.getBreed()}</td>

                    <td class="text-center">
                        <a class="icon-pencil" href="${pageContext.servletContext.contextPath}/updateclient?id=${client.getId()}"><span class="glyphicon glyphicon-edit"></span> Edit</a>
                        <a class="icon-remove"  href="${pageContext.servletContext.contextPath}/delete?id=${client.getId() }" ><span class="glyphicon glyphicon-remove"></span> Del</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

