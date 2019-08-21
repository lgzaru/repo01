<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import =  "conn.ConMysqlLocalhost" import="functions.AdminDash" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">



<!DOCTYPE html>
<html>
    <head>
        <title>Display Selected HTML Table TR Values In Input Text</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="refresh" content="5">
        
        <style>
            table tr:not(:first-child){
                cursor: pointer;transition: all .25s ease-in-out;
            }
            table tr:not(:first-child):hover{background-color: #ddd;}
        </style>
        
        <script src='vendors/js/vendor.bundle.base.js'></script>
<script src='vendors/sweetalert/sweetalert.min.js'></script>
<script src='js/alerts.js'></script>
				
				
		<script>
		$(document).ready(function(){  
		showWarningToast()  
			});
		</script>
        
    </head>
    <body>
    
           <%
            String testid = request.getParameter("first");
           //System.out.println("Testing = "+testid);
            
           // response.sendRedirect("/ContitouchH/AllPost");
           AdminDash obj = new AdminDash();
				obj.getAdminDash(request, response);
           
        %>
     
       
        First Name:<input type="text" name="fname" id="fname"><br><br>
        Last Name:<input type="text" name="lname" id="lname"><br><br>
        Age:<input type="text" name="age" id="age"><br><br>
        Myresult:<input type="text" name="userId" value="<%out.print(testid); %>">
        
        <form action="/ContitouchH/AdminDash" method="post">
        
        <button>Test Values</button>
        
        </form>
         
        
        
        
        
        <table id="table" border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
            
            <tr>
                <td>FN1</td>
                <td>LN1</td>
                <td>10</td>
            </tr>
            
            <tr>
                <td>FN2</td>
                <td>LN2</td>
                <td>20</td>
            </tr>
            
            <tr>
                <td>FN3</td>
                <td>LN3</td>
                <td>30</td>
            </tr>
            
            <tr>
                <td>FN4</td>
                <td>LN4</td>
                <td>40</td>
            </tr>
            
            <tr>
                <td>FN5</td>
                <td>LN5</td>
                <td>50</td>
            </tr>
        </table>
        
        <script>
    
                var table = document.getElementById('table');
                
                for(var i = 1; i < table.rows.length; i++)
                {
                    table.rows[i].onclick = function()
                    {
                         //rIndex = this.rowIndex;
                         document.getElementById("fname").value = this.cells[0].innerHTML;
                         document.getElementById("lname").value = this.cells[1].innerHTML;
                         document.getElementById("age").value = this.cells[2].innerHTML;
                         
                        
                    };
                }
    
         </script>
        
    </body>
</html>