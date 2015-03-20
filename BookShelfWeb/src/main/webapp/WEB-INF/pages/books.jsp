<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table>
    <tr>
        <th>ISBN</th>
        <th>Name</th>
        <th>Price</th>
        <th>Author</th>
    </tr>
<c:forEach var="book" items="${books}">
    <tr>
           <td> ${book.isbn}</td>
           <td> ${book.name}</td>
           <td> ${book.price}</td>
           <td> ${book.author}</td>
    </tr>
</c:forEach>
toggle ${toggle}
profile ${profile}

</table>
</body>
</html>