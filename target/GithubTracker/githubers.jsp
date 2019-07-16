<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@include file="header.jsp" %>

<p>
    <%
        /*List<Githuber> githubers = (List<Githuber>) request.getAttribute("githubersAttibute");
        for (Githuber githuber : githubers) {
            PrintWriter out = response.getWriter();
            out.print(githuber.getName() + "<br>");
        }*/
    %>
    <c:forEach items="${githubersAttribute}" var="githuber">
        ${githuber.name} <br>
    </c:forEach>


</p>
</body>
</html>
