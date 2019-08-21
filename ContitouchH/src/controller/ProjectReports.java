package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.mysql.jdbc.Connection;


/**
 * Servlet implementation class ProjectReports
 */
@WebServlet("/ProjectReports")
public class ProjectReports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectReports() {
        super();
        // TODO Auto-generated constructor stub
    }


			@SuppressWarnings("deprecation")
			protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				Connection con = null;
				String url = "jdbc:mysql://localhost:3306/";
				String dbName = "residents";
				String driver = "com.mysql.jdbc.Driver";
				String dbUserName = "root";
				String dbPassword = "#pass123";
				
				
		/*
		 * String pname = request.getParameter("pname"); String date1 =
		 * request.getParameter("date1"); String date2 = request.getParameter("date2");
		 * String status = request.getParameter("status");
		 */
				
	

				/*******************************************************/
				
		   
		     try
		      {
			 
		       
			  Class.forName(driver).newInstance();
			  con = (Connection) DriverManager.getConnection(url+dbName,dbUserName,dbPassword);
				
		        String sql = "select pname, status, company,assignedto, requester,project_start,project_end,priority from projects  ";
		        
		    	  
		        HSSFWorkbook workbook = new HSSFWorkbook();
		        HSSFSheet sheet =  workbook.createSheet("Report Search");
		       
		            
		                     Statement statement = con.createStatement();
		                     ResultSet resultset = statement.executeQuery(sql);
		                   
		                     //System.out.println("Achida Asingadi Satan ,Zvaita Chete");
		                     ResultSetMetaData metadata = resultset.getMetaData();
		                     HSSFRow roww = sheet.createRow(0);
		              
		                  for (int i =1;i<=metadata.getColumnCount();i++)
		                     {
		                     
		                     HSSFFont font = workbook.createFont();
		                           font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		                           HSSFCellStyle style = workbook.createCellStyle();
		                           style.setFont(font);
		                           style.setFillForegroundColor(HSSFColor.YELLOW.index);
		                           style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		                           style.setWrapText(true); 
		                           //style.setLocked(true);
		                           HSSFCell cell = roww.createCell((short)(i - 1));
		                           cell.setCellValue(metadata.getColumnName(i));
		                           cell.setCellStyle(style);
		                           }
		                  while (resultset.next())
		                  {
		                 for (short k =1;k<=metadata.getColumnCount();k++)
		                 {
		                      HSSFRow row = sheet.createRow((short)resultset.getRow());
		                      row.createCell((short) (k-1)).setCellValue(resultset.getString(k));
		                      sheet.autoSizeColumn(k);
		                             }
		                  }
		               
		               
		                  response.setContentType("application/vnd.ms-excel");
		          	    response.setHeader("Content-Disposition", "inline; filename="+ "ProjectReport.xls");
		               workbook.write(response.getOutputStream());
		               response.getOutputStream().close();
		               
		        }
		        catch (Exception e)
		              {
		                     System.err.println("Make sure file is not open in another application");
		                     System.out.println(e.getMessage());
		              }
			}

			/**
			 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
			}

			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				doGet(request, response);
			}

		}
