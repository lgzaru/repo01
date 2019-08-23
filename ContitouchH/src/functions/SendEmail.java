package functions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendEmail {
	

	
	public static void SendMail(String email, int myotp){ 
		
			//System.out.println(email);

			//Get the session object
			  Properties props = new Properties();
			  props.put("mail.smtp.host", "mail.contitouch.co.zw");
			  props.put("mail.smtp.socketFactory.port", "465");
			  props.put("mail.smtp.socketFactory.class",
			        	"javax.net.ssl.SSLSocketFactory");
			  props.put("mail.smtp.auth", "true");
			  props.put("mail.smtp.port", "465");
			 
			  Session session = Session.getDefaultInstance(props,
			   new javax.mail.Authenticator() {
			   protected PasswordAuthentication getPasswordAuthentication() {
			   return new PasswordAuthentication("user1@contitouch.co.zw","contitouch");//change accordingly
			   }
			  });
			 
			//compose message
			  try {
			   MimeMessage message = new MimeMessage(session);
			   message.setFrom(new InternetAddress("user1@contitouch.co.zw"));//change accordingly
			   message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
			   message.addRecipient(Message.RecipientType.CC,new InternetAddress(email));
			   message.addRecipient(Message.RecipientType.BCC,new InternetAddress(email));
			   message.setSubject("Contitouch Password Reset");
			   message.setText(" Dear user \n\n\nFollow the link below to reset your password     "
			   		+ "\n\nYour OTP is '"+myotp+"'  "
			   		+ "  \n\n http://localhost:8080/ContitouchH/resetpass.jsp    \n\n\nKind Regards \nContitouch Technologies\n Dev Team "
			   		+ "\n \n\n\n\n***********Please do not reply to this email, it was automatically generated by the System.***********");
			   
			   
			   
			   
			   //send message
			   Transport.send(message);

			   System.out.println("email message sent successfully");
			   
			   
			 
			  } catch (MessagingException e) {
				  throw new RuntimeException(e);
				  
				//System.out.println("");

				  
				  }
				
				
				
				
			}
	
	
	
	public static void SendMailTaskCompleted(String adminemail, String taskname, String projectname, String useremail,HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//Get the session object
		PrintWriter out = response.getWriter();	
		
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "mail.contitouch.co.zw");
		  props.put("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.socketFactory.class",
		        	"javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "465");
		 
		  Session session = Session.getDefaultInstance(props,
		   new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication("user1@contitouch.co.zw","contitouch");//change accordingly
		   }
	   });
		 
		//compose message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("user1@contitouch.co.zw"));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(adminemail));
		   message.addRecipient(Message.RecipientType.CC,new InternetAddress(useremail));
		   /*message.addRecipient(Message.RecipientType.BCC,new InternetAddress(email));*/
		   message.setSubject("System Notification");
		   message.setText("Please note that task:-'"+taskname+"' for project:-'"+projectname+"' has been completed. \n\n\n Please login and verify...     "
		  		+ "  \n\nhttp://localhost:8080/ContitouchH/login.jsp    \n\n\nKind Regards \nContitouch Technologies\nDev Team "
		   		+ "\n \n\n\n\n***********Please do not reply to this email, it was automatically generated by the System.***********");
		   
		 //send message
		   Transport.send(message);

		   System.out.println("email message sent successfully");
		   
		   
		 
		  } catch (MessagingException e) {
			  
			  System.out.println("Connection Error");
			  
			  		
			  out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('warning-message-and-cancel')        ");
				out.println("});");
				out.println("</script>");
				

			  throw new RuntimeException(e);
			 
			  }
			
			
			
			
		}
	
	
	
	
	
	public static void SendMailTaskAssigned(String adminemail, String taskname, String projectname, String projectid, String useremail,String duedate,String tdesc,String lead,HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//Get the session object
		PrintWriter out = response.getWriter();	
		
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "mail.contitouch.co.zw");
		  props.put("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.socketFactory.class",
		        	"javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "465");
		 
		  Session session = Session.getDefaultInstance(props,
		   new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication("user1@contitouch.co.zw","contitouch");//change accordingly
		   }
	   });
		 
		//compose message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("user1@contitouch.co.zw"));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(useremail));
		   message.addRecipient(Message.RecipientType.CC,new InternetAddress(lead));
		   message.addRecipient(Message.RecipientType.BCC,new InternetAddress(adminemail));
		   message.setSubject("Assigned Task Notification");
		   message.setText("You have been assigned Task:-'"+taskname+"' under Project:-'"+projectname+"',Project ID:-'"+projectid+"' and your task is due on - '"+duedate+"'."
		   		+ " \n\n\nDetails:-'"+tdesc+"' ...    "
		  		+ "  \n\nhttp://localhost:8080/ContitouchH/login.jsp    \n\n\nKind Regards \nContitouch Technologies\nDev Team "
		   		+ "\n \n\n\n\n***********Please do not reply to this email, it was automatically generated by the System.***********");
		   
		 //send message
		   Transport.send(message);

		   System.out.println("email message sent successfully");
		   
		   
		 
		  } catch (MessagingException e) {
			  
			  System.out.println("Connection Error");
			  
			  		
			  out.println("<script src='vendors/js/vendor.bundle.base.js'></script>");
				out.println("<script src='vendors/sweetalert/sweetalert.min.js'></script>");
				out.println("<script src='js/alerts.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){  ");
				out.println("  showSwal('warning-message-and-cancel')        ");
				out.println("});");
				out.println("</script>");
				

			  throw new RuntimeException(e);
			 
			  }
			
			
			
			
		}
	

	
	public static void SendMailDue24hrs(String pname,String lead, String createdby, String project_end, String projectid, String tname, String assignedto){ 
		
		
		System.out.println("Send Email Notifications");
	

		//Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "mail.contitouch.co.zw");
		  props.put("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.socketFactory.class",
		        	"javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "465");
		 
		  Session session = Session.getDefaultInstance(props,
		   new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication("user1@contitouch.co.zw","contitouch");//change accordingly
		   }
		  });
		 
		//compose message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("user1@contitouch.co.zw"));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(lead));
		   message.addRecipient(Message.RecipientType.CC,new InternetAddress(createdby));
		  // message.addRecipient(Message.RecipientType.BCC,new InternetAddress(email));
		   message.setSubject("Project status notification");
		   message.setText("Dear user \n\n\nThis email was auto-generated by the system.    "
		   		+ "\n\nYou are currently assigned as a project lead on[ProjectName: '"+pname+"', ProjectID: '"+projectid+"':] Due date: ['"+project_end+"']  "
		   		+ " \nYou have overdue task. Task Name:'"+tname+"', Assigned to: '"+assignedto+"'  "
		   		+ " \n\n\nKind Regards \nContitouch Technologies\nDev Team "
		   		+ "\n \n\n\n\n***********Please do not reply to this email, it was automatically generated by the System.***********");
		   
		   
		   
		   
		   //send message
		   Transport.send(message);

		   System.out.println("email message sent successfully");
		   
		   
		 
		  } catch (MessagingException e) {
			  throw new RuntimeException(e);
			  
			//System.out.println("");

			  
			  }
			
			
			
			
		}

}