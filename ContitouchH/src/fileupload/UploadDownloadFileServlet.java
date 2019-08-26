package fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import controller.UpdateFileDetails;

@WebServlet("/UploadDownloadFileServlet")
public class UploadDownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    
    //my variables
    String myfilename = null;
    String myfilepath = null;
    
	@Override
	public void init() throws ServletException{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession(true); 
		
		String fileName = request.getParameter("fileName");
		
	
		if(fileName == null || fileName.equals("")){
			throw new ServletException("File Name can't be null or empty");
		}
		File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
		if(!file.exists()){
			throw new ServletException("File doesn't exists on server.");
		}
		System.out.println("File location on server::"+file.getAbsolutePath());
		ServletContext ctx = getServletContext();
		InputStream fis = new FileInputStream(file);
		String mimeType = ctx.getMimeType(file.getAbsolutePath());
		response.setContentType(mimeType != null? mimeType:"application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		ServletOutputStream os       = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read=0;
		while((read = fis.read(bufferData))!= -1){
			os.write(bufferData, 0, read);
		}
		os.flush();
		os.close();
		fis.close();
		System.out.println("File downloaded at client successfully");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.write("<html><head>tesing</head><body>");
		
	
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				System.out.println("FieldName="+fileItem.getFieldName());
				System.out.println("FileName="+fileItem.getName());
				System.out.println("ContentType="+fileItem.getContentType());
				System.out.println("Size in bytes="+fileItem.getSize());
				
				File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
				System.out.println("Absolute Path at server="+file.getAbsolutePath());
				fileItem.write(file);
				
				
				
			System.out.println("File "+fileItem.getName()+ " uploaded successfully.");
			
			
			 myfilename = fileItem.getName();
			 myfilepath = file.getAbsolutePath();

			
				
			}
		} catch (FileUploadException e) {
			out.write("Exception in uploading file.");
		} catch (Exception e) {
			out.write("Exception in uploading file.");
		}
		out.write("</body></html>");
	;
		
		
		 System.out.println("Myfilename---"+myfilename);
		 System.out.println("Myfilepath---"+myfilepath);
	

			

			
			HttpSession session = request.getSession(true);
			
			 	String userName2 =  session.getAttribute("User").toString();
			 	String client_id = session.getAttribute("clientid1").toString();
				String projectname = session.getAttribute("projectname1").toString();
				String summary = session.getAttribute("summary1").toString();
				String datereceived = session.getAttribute("datereceived1").toString();
		
		
		 UpdateFileDetails sm = new UpdateFileDetails(); sm.FileUpdate(request, myfilepath, myfilename,userName2,client_id,projectname,summary,datereceived);
		 
		 
		 
		 //Updating to local DB----------------------------------------------------------------------------------------------------------
		 
		 
		/*
		 * out.println("<script type=\"text/javascript\">");
		 * out.println("alert('File named "+myfilename+ " uploaded successfully.');");
		 * out.println("window.location = 'clientbrief.jsp'  ");
		 * out.println("</script>");
		 */

			out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
			out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
			out.println("<script src='js/alerts.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){  ");
			out.println("  showSwal('auto-close')        ");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("project.jsp");
			rd.include(request, response);
		

	}

}
