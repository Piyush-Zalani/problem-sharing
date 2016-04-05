<%@page import="com.questionboard.model.User"%>
<%@page import="com.questionboard.model.Answer"%>
<%@page import="java.util.List"%>
<%@page import="com.questionboard.model.Question"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="questionList.css" />
<title>Question Page</title>
<script src="ajax.js"></script>
<script>
	function postAnswer() {
		var questionId = document.getElementById('txtQuestionId').value;
		var answer = document.getElementById('txtAnswerBox').value;
		var userId = document.getElementById('txtUserId').value;
		
		if(!answer || answer.length==0) {
			alert("Please type an answer to post.")
			return;
		}
		
		var paramKey = [];
		var paramValue = [];
		paramKey.push("questionId");
		paramValue.push(questionId);
		paramKey.push("answer");
		paramValue.push(answer);
		paramKey.push("userId");
		paramValue.push(userId);
		
		var url = createURL("PostAnswer",paramKey, paramValue);
		
		document.getElementById('txtAnswerBox').value = "";
		performAjax(url,"GET",addAnswerCallBack());
	}
	
	function addAnswerCallBack() {
		location.reload();
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		Question question = (Question)request.getAttribute("question");
		List<Answer> answers = (List<Answer>)request.getAttribute("answers");
		User user = ((User)session.getAttribute("user"));
	%>
	
	<input type="hidden" id="txtQuestionId" name="txtQuestionId" value="<%=question.getQuestionId()%>"/>
	<input type="hidden" id="txtUserId" name="txtUserId" value='<%=user.getUserId()%>' />
	
	<div class="questionList">
	
	<div class="question-header"><h1><%=question.getQuestionTag() %></h1></div><br/>
	<div><%=question.getDescription() %></div>
	<br/>
	
	<table>
			<%if(answers != null) {
			for(Answer answer : answers) {%>
			<tr id="answers">
				<td class="question-summary">
					<div>
						<%=answer.getAnswerDesc() %>
					</div>
					<div class="AnswerDetails">
						answered by <%=answer.getUser()%> at <%=answer.getAnswerDate()%>
					</div>
				</td>
				
			</tr>
			<%}} %>
		
	</table>
	<br/>
	<textarea id="txtAnswerBox" name="txtAnswerBox" rows="10" cols="40"></textarea>
	<input type="button" value="Post" onclick="javascript:postAnswer();"/>
	
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>