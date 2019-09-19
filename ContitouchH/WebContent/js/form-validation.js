(function($) {
  'use strict';
  $.validator.setDefaults({
   /* submitHandler: function() {
      alert("submitted tester!");
    }*/
  });
  $(function() {
    // validate the comment form when it is submitted
    $("#commentForm").validate({
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });
    
    // validate signup form on keyup and submit
    $("#signupForm").validate({
      rules: {
        firstname: "required",
        lastname: "required",
        name: "required",
        username: {
          required: true,
          minlength: 2
        },
        
        pnumber: {
        	
        	required: true,
        	minlength: 12
        },
                     
        
        password: {
          required: true,
          minlength: 5
        },
        confirm_password: {
          required: true,
          minlength: 5,
          equalTo: "#password"
        },
        email: {
          required: true,
          email: true
        },
        topic: {
          required: "#newsletter:checked",
          minlength: 2
        },
       
        role: "required", 
        title: "required",
        agree: "required",
      },
      messages: {
        firstname: "Please enter  firstname",
        lastname: "Please enter  lastname",
        name: "Please enter  Full Name",
        
        
      username: {
          required: "Please enter a username",
          minlength: "Your username must consist of at least 2 characters"
        },
        
      pnumber:{
        	required: "Please provide a valid phone number eg 263773827611",
        	minlength: "Your phone number must be 12 characters long"
        },
     
        password: {
          required: "Please provide a password",
          minlength: "Your password must be at least 5 characters long"
        },
        confirm_password: {
          required: "Please provide a password",
          minlength: "Your password must be at least 5 characters long",
          equalTo: "Please enter the same password as above"
        },
        email: "Please enter a valid email address",
        role: "Please enter role",
        title:"Please enter title",
        agree: "Please accept our policy"
      },
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });
    
    
   
    
    
    // validate Create client form on keyup and submit
    $("#createUserForm").validate({
      rules: {
      
        name: "required",
        role: "required",
        mroles: "required",
        email: {
            required: true,
            email: true
          },
        
          title: "required",
          
          pnumber: {
          	
          	required: true,
          	minlength: 12
          },
      
        password: {
          required: true,
          minlength: 5
        },
        confirm_password: {
          required: true,
          minlength: 5,
          equalTo: "#password"
        },
       
     
       
       test: "required"
      
      
      },
      messages: {
   
        name: "Please enter  Full Name",
        role: "Please enter role",  
        email: "Please enter a valid email address",
        title: "Please enter title",
        
        pnumber: {
            required: "Please provide a valid phone number eg 263774546511",
            minlength: "Your password must be 12 characters long"
          },
      
       
        password: {
          required: "Please provide a password",
          minlength: "Your password must be at least 5 characters long"
        },
        confirm_password: {
          required: "Please provide a password",
          minlength: "Your password must be at least 5 characters long",
          equalTo: "Please enter the same password as above"
        },
        
      
        mroles:"Please enter role",
        test:"testing"
        
      },
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });
    
    
    // validate Create client form on keyup and submit
    $("#clientForm").validate({
      rules: {
      
        name: "required",
        vatreg: "required",
        email: {
            required: true,
            email: true
          },
     
          
          pnumber: {
          	
          	required: true,
          	minlength: 12
          },
          
          address: "required",
          finances: "required",
          projectname: "required",
          summary: "required",
          datereceived:"required",
          test: "required"
      
      
      },
      messages: {
   
        name: "Please enter  Full Name",
        role: "Please enter VAT",  
        email: "Please enter a valid email address",
              
        pnumber: {
            required: "Please provide a valid phone number eg 263774546511",
            minlength: "Your password must be 12 characters long"
          },
        
          address: "Please enter full address",
       
        
      
          finances:"Please enter finances",
          projectname:"Please enter project name",
          summary:"Please enter summary",
          datereceived:"Date required",
        test:"testing"
        
      },
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });
    
    
    
    // validate Create Project form on keyup and submit
    $("#createProjectForm").validate({
      rules: {
      
        pname: "required",
        time: "required",
        requester: "required",
        rrd: "required",
        red: "required",
        project_start: "required",
        project_end: "required",
        responsibility: "required",
        lead: "required",
        company: "required",
        
        comments:{
        	required:true,
        	minlength: 10
        },
     
          test: "required"
      
      
      },
      messages: {
   
        pname: "Please enter project name",
        time: "Please enter expected period e.g. 2mnths",  
        requester: "Please enter Requester",
        rrd: "Please enter Request Required Date",
        red: "Please enter Request End Date",
        project_start: "Please enter Project Start Date",
        project_end: "Please enter Project End Date",
        responsibility: "Please enter Dept. responsible",
        lead: "Please enter Project Lead",
        company: "Please enter Company",
              
        comments: {
            required: "Please enter project summary",
            minlength: "Your summary must be at least 10 characters long"
          },
        
         
        test:"testing"
        
      },
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });
    
    
    // validate Create task form on keyup and submit
    $("#addTask").validate({
      rules: {
      
        tname: "required",
        duedate: "required",
        assigneddate:"required",
        tdesc: {
        required:true,
        minlength:10
        
        },
        
        assignedto:"required",
        
          test: "required"
      
      
      },
      messages: {
   
        tname: "Please enter task name",
        duedate: "Due date is required", 
        assigneddate:"assigneddate is required",
        
             
        tdesc: {
            required: "Please enter task summary",
            minlength: "Your summary must be at least 10 characters long"
          },
          assignedto:"Assign task to a person",
         
        test:"testing"
        
      },
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });
    
    
    


    // propose username by combining first- and lastname
    $("#username").focus(function() {
      var firstname = $("#firstname").val();
      var lastname = $("#lastname").val();
      if (firstname && lastname && !this.value) {
        this.value = firstname + "." + lastname;
      }
    });
    //code to hide topic selection, disable for demo
    var newsletter = $("#newsletter");
    // newsletter topics are optional, hide at first
    var inital = newsletter.is(":checked");
    var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
    var topicInputs = topics.find("input").attr("disabled", !inital);
    // show when newsletter is checked
    newsletter.on("click", function() {
      topics[this.checked ? "removeClass" : "addClass"]("gray");
      topicInputs.attr("disabled", !this.checked);
    });
  });
})(jQuery);