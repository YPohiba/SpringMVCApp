<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf8">
  <title>Login page</title>

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
    <div class="row">
        <div class="col-xs-1">
        </div>
        <div class="col-xs-6">
            <h5 class="text-danger" style="color: red">${message}</h5>
        </div>
        <div class="col-xs-1">
        </div>
    </div>

    <div class="container" style="width: 300px;">
        <p class="text-danger" style="color: red">${message}</p>

        <form method="POST" action="<c:url value="/j_spring_security_check" />">
            <a class="chart-symbol" href="<c:url value="/registration" />">Registration</a>
            <h2 class="form-signin-heading">Please sign in</h2>
            <c:if test="${param.error != null}">
                <font color="red"> Login Error
                    : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
            </c:if>
            <input type="text" class="form-control" name="j_username" placeholder="Email address / Username" >
            <input type="password" class="form-control" name="j_password" placeholder="Password" >
            <p>Remember me <input type="checkbox" class="check-box" name="_spring_security_remember_me" title="Remember me"></p>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Enter</button>
        </form>
    </div>


</body>
</html>