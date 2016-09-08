<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Welcome</title>

  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/jumbotron-narrow.css" />" rel="stylesheet">

  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>

</head>
<body>

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
  <div class="container">
    <div class="jumbotron" style="margin-top: auto;">

      <form action="/getAllUsers" method="POST">
        <button class="btn btn-lg btn-primary btn-success" type="submit">Get all users</button>
      </form>

      <%--@elvariable id="userList" type="java.util.Map"--%>
      <c:if test="${!empty userList}">
        <c:forEach items="${userList}" var="user">
          <h5>Name: ${user.username} eMail:${user.email}</h5>
        </c:forEach>
      </c:if>

    </div>
  </div>

  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
