<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="header.jsp" %>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">name</th>
                <th scope="col">email</th>
                <th scope="col">login</th>
                <th scope="col">avatarUrl</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${githubersAttribute}" var="githuber">
                <tr>
                    <td>${githuber.id}</td>
                    <td>${githuber.name}</td>
                    <td>${githuber.email}</td>
                    <td>${githuber.login}</td>
                    <td>${githuber.avatarUrl}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</body>
</html>
