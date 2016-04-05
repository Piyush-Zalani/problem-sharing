<%@page import="com.questionboard.model.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<jsp:include page="header.jsp"></jsp:include>	
	
	<%
		List<Question> questions = (List<Question>) request.getAttribute("questions");
	%>

	<div class="questionList">
		<table class="questionList">
			<%
				if (questions != null) {
					for (Question question : questions) {
			%>
			<tr>
				<td class="question-summary">
					<div class="questionTag">
						<a class="questionName" href="QuestionPage?id=<%=question.getQuestionId()%>"><%=question.getQuestionTag()%></a>
						<div class="alignRight">Asked by <%=question.getUser()%> at <%=question.getQuestionDate()%></div>
					</div>
				</td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</div>


</body>
</html>