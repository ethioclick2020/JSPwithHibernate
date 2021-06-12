<% 
session.removeAttribute("uname");
session.invalidate();
response.sendRedirect("Login.jsp");
%>