(function($) {
  'use strict';
  $('#defaultconfig').maxlength({
    warningClass: "badge mt-1 badge-success",
    limitReachedClass: "badge mt-1 badge-danger"
  });

  $('#defaultconfig-2').maxlength({
    alwaysShow: true,
    threshold: 20,
    warningClass: "badge mt-1 badge-success",
    limitReachedClass: "badge mt-1 badge-danger"
  });

  $('#defaultconfig-3').maxlength({
    alwaysShow: true,
    threshold: 10,
    warningClass: "badge mt-1 badge-success",
    limitReachedClass: "badge mt-1 badge-danger",
    separator: ' of ',
    preText: 'You have ',
    postText: ' chars remaining.',
    validate: true
  });
  
  $('#pnumber').maxlength({
	    alwaysShow: true,
	    threshold: 12,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger",
	    separator: ' of ',
	    preText: 'You have ',
	    postText: ' chars remaining.',
	    validate: true
	  });
  
  $('#name').maxlength({
	    alwaysShow: true,
	    threshold: 45,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#vatreg').maxlength({
	    alwaysShow: true,
	    threshold: 45,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#email').maxlength({
	    alwaysShow: true,
	    threshold: 50,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#title').maxlength({
	    alwaysShow: true,
	    threshold: 45,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#fpass').maxlength({
	    alwaysShow: true,
	    threshold: 5,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#password').maxlength({
	    alwaysShow: true,
	    threshold: 45,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#confirm_password').maxlength({
	    alwaysShow: true,
	    threshold: 45,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#finances').maxlength({
	    alwaysShow: true,
	    threshold: 50,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#projectname').maxlength({
	    alwaysShow: true,
	    threshold: 100,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#summary').maxlength({
	    alwaysShow: true,
	    threshold: 1000,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#mroles').maxlength({
	    alwaysShow: true,
	    threshold: 50,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#address').maxlength({
	    alwaysShow: true,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#pname').maxlength({
	    alwaysShow: true,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#pstatus').maxlength({
	    alwaysShow: true,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#time').maxlength({
	    alwaysShow: true,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#requester').maxlength({
	    alwaysShow: true,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#responsibility').maxlength({
	    alwaysShow: true,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  

  
  $('#comments').maxlength({
	    alwaysShow: true,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  

  $('#maxlength-textarea').maxlength({
    alwaysShow: true,
    warningClass: "badge mt-1 badge-success",
    limitReachedClass: "badge mt-1 badge-danger"
  });
  
  //-----------------------------------------------------add task form---------
  $('#tname').maxlength({
	    alwaysShow: true,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
  $('#tdesc').maxlength({
	    alwaysShow: true,
	    warningClass: "badge mt-1 badge-success",
	    limitReachedClass: "badge mt-1 badge-danger"
	  });
  
})(jQuery);