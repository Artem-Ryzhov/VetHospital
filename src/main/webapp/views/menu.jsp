
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <link rel="stylesheet" href="/css/menu.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<ul>
    <li><a class="active" href="/views/first.jsp">LogOut</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/addcountry">Registration Form</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/clientview">Show All Clients</a></li>
      <li><a href="${pageContext.servletContext.contextPath}/sortbytype">Show  Clients With Same animal</a></li>
    <li><a href="${pageContext.servletContext.contextPath}/deleteall">Delete all Clients</a></li>
    <li><a href="#about">About</a></li>
</ul>


<div  style="margin-left:25%;padding:1px 16px;height:1000px;" id="menu">
    <h2>Administrator menu</h2>
    <h3>Try to scroll this area, and see how the sidenav sticks to the page</h3>
    <p>Notice that this div element has a left margin of 25%. This is because the side navigation is set to 25% width. If you remove the margin, the sidenav will overlay/sit on top of this div.</p>
    <p>Also notice that we have set overflow:auto to sidenav. This will add a scrollbar when the sidenav is too long (for example if it has over 50 links inside of it).</p>
    <img class="img-responsive" src="/images/pups2.jpg" alt="Chania" width="900" height="600">
    <p>Notice that this div element has a left margin of 25%. This is because the side navigation is set to 25% width. If you remove the margin, the sidenav will overlay/sit on top of this div.</p>
    <p>Also notice that we have set overflow:auto to sidenav. This will add a scrollbar when the sidenav is too long (for example if it has over 50 links inside of it).</p>
</div>


</body>
</html>



