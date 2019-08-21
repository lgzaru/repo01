<%@ page contentType="text/html"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%
     RequestDispatcher rd = request.getRequestDispatcher("/Dashboard_refr");
     request.setAttribute("msg","HI Welcome");
     rd.forward(request, response);
%>