   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"   import="javax.servlet.http.HttpSession"
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Contitouch</title>
  <!-- base:css -->
  <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="vendors/flag-icon-css/css/flag-icon.min.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/horizontal-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.ico" />
  
  
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  
  

</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
    
      <div class="main-panel">
      
        <div class="content-wrapper d-flex align-items-center auth px-0">
        <div class="row w-100 mx-0">
         <div class="col-lg-4 mx-auto">
         
         <%@ page import="java.lang.Long" %>
<% String error = (String) request.getAttribute("Error");
if (error != null) {
	out.write("<center><strong>");
	
	out.write("<font color= \"Red\" >"  );
	out.write(error);
	out.write("</font>");
	out.write("</strong></center>");
}

%>
          
           
              <div class="auth-form-light text-left py-5 px-4 px-sm-5">
                <div class="brand-logo">
                  <img align = "middle" src="images/contitouch-logo.png" alt="logo">
                </div>
                
                
                <h6 class="font-weight-light">Reset Password.</h6>
            
                <form class="pt-3" action="/ContitouchH/ResetPass" method="POST">
                <!-- <form class="pt-3" action="http://localhost:3000/getLoginDetails" method="POST"> -->
                
                  <div class="form-group">
                    <input type="text" class="form-control form-control-lg" id="otp" name="otp" placeholder="Enter OTP">
                  </div>
                  <div class="form-group">
                    <input type="password" class="form-control form-control-lg" id="password1" name="password1" placeholder="Password">
                  </div>
                  
                  <div class="form-group">
                    <input type="password" class="form-control form-control-lg" id="password" name="password" placeholder="Confirm Password">
                  </div>
                  
                 <input name="lastLogon" type="hidden" value="<%= new java.lang.Long(System.currentTimeMillis()).toString() %>"/>
                  
                  
                  <div class="mt-3">
                   <button type="submit"  class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">Reset<i class="fa fa-angle- ml5"></i></button>
                    
                  </div>
                  
                  </form>
                                  
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
    <div class="card">
               <form action="/ContitouchH/ForgotPass" method="post">
                  <div class="modal fade" id="exampleModal-2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel-2" aria-hidden="true" style="display: none;">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel-2">Forgot Password</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                          </button>
                        </div>
                        <div class="modal-body">
                          <p>Please enter your registered email address.</p>
                        </div>
                  <div class="modal-body">
                    <input type="email"  id="fpass" name="fpass" class="form-control " placeholder="Enter Email Address">
                  </div>
                        <div class="modal-footer">
                          <button type="submit" class="btn btn-success">Submit</button>
                          <button type="button" class="btn btn-light" data-dismiss="modal">Cancel</button>
                        </div>
                      </div>
                    </div>
                  </div>
                  
                  </form>
                  <!-- Modal Ends -->
                </div>
              </div>
    
    
    
    
    
  </div>
  <!-- container-scroller -->
  <!-- base:js -->
  <script src="vendors/js/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/hoverable-collapse.js"></script>
  <script src="js/template.js"></script>
  <script src="js/settings.js"></script>
  <script src="js/todolist.js"></script>
  <!--  -->
  
  
  
  
  <!-- endinject -->
  <!-- inject:js -->
  <!-- endinject -->
  <!-- plugin js for this page -->
  <script src="vendors/sweetalert/sweetalert.min.js"></script>
  <script src="../vendors/jquery.avgrund/jquery.avgrund.min.js"></script>
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <script src="js/alerts.js"></script>
  <script src="js/avgrund.js"></script>
  
  
  
  
  <!-- ------------------------------------- -->
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
<!--                                             -->  
  
  <!-- endinject -->
</body>

</html>
