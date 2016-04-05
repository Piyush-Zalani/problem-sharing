<%@page import="javax.xml.ws.Response"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! Connection con;
PreparedStatement ps;
%>
<%
try {
			String questionTag = request.getParameter("questionTag");
			String questionDesc = request.getParameter("questionDesc");
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			ps = con.prepareStatement("insert into question(questiontag, questiondesc) values(?,?)");

			ps.setString(1, questionTag);
			ps.setString(2, questionDesc);
			


			int i = ps.executeUpdate();
			
			response.sendRedirect("QuestionList");
			
}
 catch (Exception ex) {
	ex.printStackTrace();
}
finally{
	con.close();
	ps.close();
}

%>

</body>
</html>