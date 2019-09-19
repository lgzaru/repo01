(function($) {
  showSwal = function(type) {
    'use strict';
    if (type === 'basic') {
      swal({
        text: 'Any fool can use a computer',
        button: {
          text: "OK",
          value: true,
          visible: true,
          className: "btn btn-primary"
        }
      })

    } else if (type === 'title-and-text') {
      swal({
        title: 'Read the alert!',
        text: 'Click OK to close this alert',
        button: {
          text: "OK",
          value: true,
          visible: true,
          className: "btn btn-primary"
        }
      })

    } /*else if (type === 'success-message') {
      swal({
        title: 'Congratulations!',
        text: 'You are now logged on',
        icon: 'success',
        button: {
          text: "Continue",
          value: true,
          visible: true,
          className: "btn btn-primary"
        }
      })

    }*/
    
    else if (type === 'no-records') {
    swal({
      title: 'Records Not Found !',
      text: 'There are no records yet associated with the selected project',
      icon: 'warning',
      button: {
        text: "Continue",
        value: true,
        visible: true,
        className: "btn btn-warning"
      }
    })

  }
    
    else if (type === 'no-internet1') {
        swal({
          title: 'Connectivity!',
          text: 'Failed to send Whatsapp message, please check your connectivity',
          icon: 'warning',
          button: {
            text: "Continue",
            value: true,
            visible: true,
            className: "btn btn-warning"
          }
        })

      }
    
    else if (type === 'no-internet2') {
        swal({
          title: 'Connectivity!',
          text: 'Failed to send email, please check your connectivity',
          icon: 'warning',
          button: {
            text: "Continue",
            value: true,
            visible: true,
            className: "btn btn-warning"
          }
        })

      }
    
    else if (type === 'task_rejected') {
        swal({
          title: 'Rejected!',
          text: 'User was notified via email and Whatsapp',
          icon: 'warning',
          button: {
            text: "Continue",
            value: true,
            visible: true,
            className: "btn btn-warning"
          }
        })

      }
    
    else if (type === 'task_pending_approval') {
        swal({
          title: 'Submitted Pending Approval!',
          text: 'Your request has being submitted, you will be notified via email or Whatsapp when approved',
          icon: 'success',
          button: {
            text: "Continue",
            value: true,
            visible: true,
            className: "btn btn-info"
          }
        })

      }
    
    
    else if (type === 'success-message') {
        swal({
          title: 'Congratulations!',
          text: 'You are now logged on',
          icon: 'success',
          timer: 2000,
          button: false
        }).then(
                function() {},
                // handling the promise rejection
                function(dismiss) {
                  if (dismiss === 'timer') {
                    console.log('I was closed by the timer')
                  }
                }
              )

      }
    
  
    
    else if (type === 'auto-close') {
      swal({
        title: 'Success!',
        text: 'The action was successfull!!',
        icon: 'success',
        timer: 2000,
        button: false
      }).then(
        function() {},
        // handling the promise rejection
        function(dismiss) {
          if (dismiss === 'timer') {
            console.log('I was closed by the timer')
          }
        }
      )
    } 
    
    else if (type === 'error-occured') {
        swal({
          title: 'Success!',
          text: 'The action was successfully deleted!!',
          icon: 'success',
          timer: 2000,
          button: false
        }).then(
          function() {},
          // handling the promise rejection
          function(dismiss) {
            if (dismiss === 'timer') {
              console.log('I was closed by the timer')
            }
          }
        )
      } 
    
    
    else if (type === 'otp-incorrect') {
        swal({
          title: 'Warning!',
          text: 'OTP incorrect!!',
          icon: 'warning',
          timer: 2000,
          button: false
        }).then(
          function() {},
          // handling the promise rejection
          function(dismiss) {
            if (dismiss === 'timer') {
              console.log('I was closed by the timer')
            }
          }
        )
      } 
    
    

    else if (type === 'delete-item') {
      swal({
        title: 'Success!',
        text: 'The action was successfully deleted!!',
        icon: 'success',
        timer: 2000,
        button: false
      }).then(
        function() {},
        // handling the promise rejection
        function(dismiss) {
          if (dismiss === 'timer') {
            console.log('I was closed by the timer')
          }
        }
      )
    } 
    
    else if (type === 'warning-message-and-cancel') {
      swal({
        title: 'Error?',
        text: "Please Try Again!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3f51b5',
        cancelButtonColor: '#ff4081',
        confirmButtonText: 'Great ',
        buttons: {
        /*  cancel: {
            text: "Cancel",
            value: null,
            visible: true,
            className: "btn btn-danger",
            closeModal: true,
          },*/
         confirm: {
            text: "OK",
            value: true,
            visible: true,
            className: "btn btn-danger",
            closeModal: true
          }
        }
      })

    } else if (type === 'custom-html') {
      swal({
        content: {
          element: "input",
          attributes: {
            placeholder: "Type your password",
            type: "password",
            class: 'form-control'
          },
        },
        button: {
          text: "OK",
          value: true,
          visible: true,
          className: "btn btn-primary"
        }
      })
    }
  }

})(jQuery);