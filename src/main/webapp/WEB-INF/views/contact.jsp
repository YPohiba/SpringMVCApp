<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf8">
  <title>Contact Manager</title>

  <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/jumbotron-narrow.css" />" rel="stylesheet">

  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>

</head>
<body>

  <div class="container">
    <div class="jumbotron" style="margin-top: auto;">

      <a href="<c:url value="/logout" />">
        Logout
      </a>
      <p class="text-danger" style="color: red">${message}</p>

      <h2>Contact Manager</h2>

      <form:form method="POST" action="addContact" modelAttribute="contact">

        <table>
          <tr>
            <td><form:label path="firstname">
              First name
            </form:label></td>
            <td><form:input path="firstname" /></td>
          </tr>
          <tr>
            <td><form:label path="lastname">
              Last name
            </form:label></td>
            <td><form:input path="lastname" /></td>
          </tr>
          <tr>
            <td><form:label path="email">
              eMail
            </form:label></td>
            <td><form:input path="email" /></td>
          </tr>
          <tr>
            <td><form:label path="telephone">
              Telephone
            </form:label></td>
            <td><form:input path="telephone" /></td>
          </tr>
          <tr>
            <td colspan="2"><input class="btn btn-lg btn-default" type="submit"
                                   value="Add Contact" /></td>
          </tr>
        </table>
      </form:form>

      <h3>Contacts</h3>
      <c:if test="${!empty contactList}">
        <table class="data">
          <tr>
            <th>First name</th>
            <th>eMail</th>
            <th>Telephone</th>
            <th>&nbsp;</th>
          </tr>
          <c:forEach items="${contactList}" var="contact">
            <tr>
              <td>${contact.lastname}, ${contact.firstname}</td>
              <td>${contact.email}</td>
              <td>${contact.telephone}</td>
              <td><a href="delete/${contact.id}">Delete</a></td>
            </tr>
          </c:forEach>
        </table>
      </c:if>


    </div>
  </div>
</body>
</html>