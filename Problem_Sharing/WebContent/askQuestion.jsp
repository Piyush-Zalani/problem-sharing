
<%@page import="com.questionboard.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	
	<header>
		<h1>
			Welcome <br> <span>Problem shared is a problem solved.</span>
		</h1>
	</header>

	<form action="AskQuestion">

		Question : <input type="text" size="40" name="questionTag"
			required="required" placeholder="Ask your Question."> <br>
		<br> Description :
		<textarea rows="5" cols="80" name="questionDesc" required="required"
			placeholder="Description of your quesion."></textarea>
		<br> <br> <input type="submit" name="Ask" value="Ask"
			style="float: inherit;">

	</form>

</div>
</body>
</html>