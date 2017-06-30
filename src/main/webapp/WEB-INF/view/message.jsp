<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/resources/static/css/main.css" />" rel="stylesheet">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${ message } </h1>
	<form:form modelAttribute="messageForm">
	<div><form:errors path="*"/></div>
		<div class="name"><c:out value="名前"/>
			<form:input path="name" />
		</div>
		<div class="text"><c:out value="テキスト"/>
			<form:textarea path="text" cols="20" rows="10"/>
		</div>
		<input type="submit">
    </form:form>

    <c:if test="${ not empty messageList }">
    	<table border="1">
    		<tbody>
    			<tr>
					<th>name</th>
					<th>comment</th>
				</tr>
				<c:forEach var="message" items="${ messageList }">
					<tr>
						<td><c:out value="${message.name}"></c:out></td>
						<td><c:out value="${message.text}"></c:out></td>
					</tr>
				</c:forEach>
    		</tbody>
    	</table>
    </c:if>
</body>
</html>