<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="header.jsp" %>


<c:if test="${not empty message}">
    ${message}
</c:if>
<c:if test="${empty message}">
    Veuillez choisir un githuber
</c:if>

<div class="add_githuber">
    <form class="form-inline" action="track" method="post">
        <div class="form-group mx-sm-3 mb-2">
            <label for="login" class="sr-only">Login</label>
            <input type="text" class="form-control" id="login" placeholder="Login" name="login">
        </div>
        <button type="submit" class="btn btn-secondary mb-2">Add Githuber</button>
    </form>
</div>

<div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">name</th>
            <th scope="col">email</th>
            <th scope="col">login</th>
            <th scope="col">avatarUrl</th>
            <th scope="col">avatarUrl</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="githuber" items="${githubersAttribute}">
            <tr>
                <td>${githuber.github_id}</td>
                <td>${githuber.name}</td>
                <td>${githuber.email}</td>
                <td>${githuber.login}</td>
                <td><img src="${githuber.avatarUrl}" width="100px"></td>
                <td>
                    <form method="post" action="unTrack" name="FormUnTrack${githuber.login}">
                        <input name="deleteId" type="hidden" value="${githuber.id}">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</div>
</body>
</html>