<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import =  "conn.ConMysqlLocalhost" import="functions.AdminDash" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>



		  <%
		  AdminDash obj = new AdminDash();
			obj.getAdminDash(request, response);
		  
		  String totalcomp =  session.getAttribute("totalcomp").toString();
		  String totalpending =  session.getAttribute("totalpending").toString();
		  String totalopen =  session.getAttribute("totalopen").toString();
		  String totalcompleted =  session.getAttribute("totalcompleted").toString();
		  String totalcancelled = session.getAttribute("totalcancelled").toString();
		  String onhold = session.getAttribute("onhold").toString();  
		  
		  String duetoday = session.getAttribute("duetoday").toString();
		  String assignedtoday = session.getAttribute("assignedtoday").toString();
		  String taskstotal = session.getAttribute("taskstotal").toString();
		  String overduetasks_graph = session.getAttribute("overduetasks").toString();
		  
		  %>
		  
<script>

// Donut Chart Starts

function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Name', 'Percentage'],
    ['Completed Projects', <%out.print(totalcomp);%>],
    ['Pending Projects', <%out.print(totalpending);%>],
    ['Overdue Projects', <%out.print(totalcancelled);%>],
    ['On Hold', <%out.print(onhold);%>]
    
    

  ]);

  var options = {
    title: 'Project Analysis',
    pieHole: 0.4,
    colors: ['#76C1FA', '#63CF72', '#F36368', '#FABA66'],
    chartArea: {
      width: 500
    },
  };

  var Donutchart = new google.visualization.PieChart(document.getElementById('Donut-chart'));
  Donutchart.draw(data, options);
}


// Donut Chart Ends

</script>


<script>
//Bar Charts Starts
google.charts.load('current', {
	  'packages': ['bar']
	});
	google.charts.setOnLoadCallback(drawStuff);


		function drawStuff() {
			  var data = new google.visualization.arrayToDataTable([
			    ['Category', 'Total'],
			    ["Tasks Due Today",<%out.print(duetoday); %>],
			    ["Overdue Tasks",<%out.print(overduetasks_graph);%> ],
			    ["Assigned Today",<%out.print(assignedtoday); %> ],
			    ["Completed Tasks", <%out.print(totalcompleted); %>],
			    ['Total Tasks', <%out.print(taskstotal); %>]
			  ]);

			  var options = {
			    title: 'Tasks Analysis',
			    legend: {
			      position: 'none'
			    },
			    colors: ['#76C1FA'],

			    chartArea: {
			      width: 401
			    },
			    hAxis: {
			      ticks: [-1, -0.75, -0.5, -0.25, 0, 0.25, 0.5, 0.75, 1]
			    },
			    bar: {
			      gap: 0
			    },

			    histogram: {
			      bucketSize: 0.02,
			      maxNumBuckets: 200,
			      minValue: -1,
			      maxValue: 1
			    }
			  };

			  var chart = new google.charts.Bar(document.getElementById('Bar-chart'));
			  chart.draw(data, options);
			};
		
		 
		
		</script> 
		
		</head>
		</html>