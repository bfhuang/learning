<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>FirstName</th>
        <th>LastName</th>
    </tr>
    <c:forEach var="person" items="${people}">
        <tr>
            <td> ${person.id}</td>
            <td> ${person.firstName}</td>
            <td> ${person.lastName}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>