<% 

response.setHeader("Cache-Control","no-cache"); //forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility


String userName = (String) session.getAttribute("User");
if (null == userName) {
	
	
	out.println("<script>");  
	out.println("window.location = 'login.jsp'  ");
	out.println("</script>");

}


String action = "Continue";
if (action.equalsIgnoreCase("Continue")) {
	
		
	//HttpSession session = request.getSession();
	session.removeAttribute("User");
	if (session != null) {
		session.invalidate();
		
		
		out.println("<script>");  
		//out.println("alert('Click OK to continue.');");
		out.println("window.location = 'login.jsp'  ");
		out.println("</script>");
		

	}
}


%>