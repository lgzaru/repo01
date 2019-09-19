    package functions;
    import java.io.*;
    import java.net.*;
    
    import java.security.KeyManagementException;
    import java.security.NoSuchAlgorithmException;
    import java.security.SecureRandom;
    import java.security.cert.X509Certificate;
    import javax.net.ssl.HttpsURLConnection;
    import javax.net.ssl.SSLContext;
    import javax.net.ssl.TrustManager;
    import javax.net.ssl.X509TrustManager;


    public class ContiSMS {

 
    	
       public static void SendSMS (String gsm, String msg) {
        	

          URL url;
          String username,strJson,password;
   
            //String senderid = "projtracker";
            username = "projtracker";
            password = "password01";
           // String gsm = "263773814511";
            //String msg = "Hello world";
            

        try {
        	
        	//Whatsapp API
        	//String requestUrl =" https://sms.contitouch.co.zw/api.json?cmd=sendwapp&"+
        		//	"username=projtracker&password=password01&gsm=263773814511&msg=Here+we+go" +
        	
        				
        	
        	//sms API
        	//String requestUrl  = "https://sms.contitouch.co.zw/api.json?cmd=send&" +
        	
        	//Whatsapp API       			
        	String requestUrl =" https://sms.contitouch.co.zw/api.json?cmd=sendwapp&"+
        	
        	
                    "username=" + URLEncoder.encode(username, "UTF-8") +
                    "&password=" + URLEncoder.encode(password, "UTF-8") +
                    //"&senderid=" + URLEncoder.encode(senderid, "UTF-8") +
                    "&gsm=" + URLEncoder.encode(gsm, "UTF-8") +
                    //"&messagetype=SMS:TEXT" +
                    "&msg=" + URLEncoder.encode(msg, "UTF-8") + "&serviceprovider=GSMModem1" +
                    "&responseformat=html";

            url = new URL(requestUrl);

            
            // Create a context that doesn't check certificates.
            SSLContext ssl_ctx = null;
			try {
				ssl_ctx = SSLContext.getInstance("TLS");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            TrustManager[ ] trust_mgr = get_trust_mgr();
            ssl_ctx.init(null,                // key manager
                         trust_mgr,           // trust manager
                         new SecureRandom()); // random number generator
            HttpsURLConnection.setDefaultSSLSocketFactory(ssl_ctx.getSocketFactory());

            URLConnection conn = url.openConnection();         // throws an IOException

      
            // Convert the InputStreamReader to a Buffered Reader.      //
            // Buffering the stream makes the reading faster; the          //
            // readLine() method of the BufferedReader makes the reading  //
            // easier.                                                     //
            //-------------------------------------------------------------//

            BufferedReader br = new BufferedReader(
                                   new InputStreamReader(conn.getInputStream()));
                                                   //
            //------------------------------------------------------------//
            // Store the whole output in a variable. The output will be    //
            // JSON string variable.                                      //
            //------------------------------------------------------------//


            String inputLine;
            strJson = "";
            while ((inputLine = br.readLine()) != null) {
                    strJson += inputLine;
            }

            br.close();

            //Variable strJson holds the reponse from the Webservice
            System.out.println(strJson);

         } catch (MalformedURLException mue) {

            System.out.println("Ouch - a MalformedURLException happened.");
            mue.printStackTrace();
            System.exit(1);

         } catch (IOException ioe) {

            System.out.println("Oops- an IOException happened.");
            ioe.printStackTrace();
            System.exit(1);

         } catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         }
        
        
      	
    	
    	  private static TrustManager[ ] get_trust_mgr() {
  		     TrustManager[ ] certs = new TrustManager[ ] {
  		        new X509TrustManager() {
  		           public X509Certificate[ ] getAcceptedIssuers() { return null; }
  		           public void checkClientTrusted(X509Certificate[ ] certs, String t) { }
  		           public void checkServerTrusted(X509Certificate[ ] certs, String t) { }
  		         }
  		      };
  		      return certs;
  		  }
        

      }