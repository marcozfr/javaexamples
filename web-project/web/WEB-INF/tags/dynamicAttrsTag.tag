<%@ tag body-content="scriptless" dynamic-attributes="myAttrs" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article>
    <div><ul>
    <c:forEach items="${myAttrs}" var="attr">
        <li><c:out value="${attr.key} : ${attr.value}" /></li>
    </c:forEach>
    </ul>
    </div>
    <div>
    <jsp:doBody></jsp:doBody>
    
    </div>
</article>