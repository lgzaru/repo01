<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import =  "conn.ConMysqlLocalhost"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>



		  <%
		  
		  String completedtasksp =  session.getAttribute("completedtasksp").toString();
		  String overduetasksp =  session.getAttribute("overduetasksp").toString();
		  String inprogresstasksp =  session.getAttribute("inprogresstasksp").toString();
		  String pendingactionp =  session.getAttribute("pendingactionp").toString();
		  String pendingapprovaltasksp = session.getAttribute("pendingapprovaltasksp").toString();
		  
		  System.out.println("........."+pendingactionp);
	

		  
		  
		  %>
		  
<script>

$(function() {
	  'use strict';

	 
	  if ($("#morris-donut-example").length) {
	    Morris.Donut({
	      element: 'morris-donut-example',
	      colors: ['#76C1FA', '#F36368', '#63CF72', '#FABA66', '#9bcfa3'],
	      data: [{
	          label: "Tasks In Progress",
	          value: <%out.print(inprogresstasksp); %>
	        },
	        {
	          label: "Overdue Tasks",
	          value: <%out.print(overduetasksp); %>
	        },
	        {
	          label: "Completed Tasks",
	          value: <%out.print(completedtasksp); %>
	        },
	        {
		          label: "Pending Action",
		          value: <%out.print(pendingactionp); %>
		        },
		        
		        {
			          label: "Pending Approval Tasks",
			          value: <%out.print(pendingapprovaltasksp); %>
			        }
	      ]
	    });
	  }
	  




	});
	
	
		 
		
		</script> 
		
		</head>
		</html>