<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf8">
  <title>Registration page</title>

  <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">

  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>

</head>
<body class="navbar">

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Name site</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/index">Home</a></li>
        <li><a href="/login">Sign in</a></li>
      </ul>
    </div>
  </div>
</div>

<div class="container" style="width: 300px;">

    <form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/addUser">
      <h2 class="form-signin-heading">Registration form</h2>
      <p class="text-danger" style="color: red">${error_message}</p>
      <p class="text-info" style="color: cornflowerblue">${reg_message}</p>
      <input type="text" class="form-control" name="username" placeholder="Username" />
      <input type="text" class="form-control" name="email" placeholder="Email address" />
      <input type="password" class="form-control" name="password" placeholder="Password" />
      <button class="btn btn-lg btn-primary btn-block" type="submit">Registration</button>
    </form>
</div>

</body>
</html>