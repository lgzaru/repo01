    package functions;
    import java.io.*;
    import java.net.*;


    public class JavaSMS {

        /**
         * @param args the command line arguments
         */
        public static void SendSMS (String destinations,String message) {

          //-----------------------------------------------------//
          //  Step 1:  Start creating a few objects we'll need.
          //-----------------------------------------------------//

          URL url;
          String username,token,bulksms_ws,strJson;
          String ws_str;

            //-----------------------------------------------------//
            //  Step 2:  Create and encode our Webservice URL.
            //-----------------------------------------------------//

            //Username that you use to login to http://portal.bulksmsweb.com
            username = "Zarue2019";

            // Webservices token for above Webservice username.
            //login to http://portal.bulksmsweb.com and got to My Account -> User Configuration
            //to get your token

            token = "cc7ea8c294b33277a958074191033929";

            // BulkSMS Webservices URL
            bulksms_ws = "http://portal.bulksmsweb.com/index.php?app=ws";

            // destination numbers, or use #groupcode for sending to group
            // $destinations = '#devteam'
            // $destinations = '26300123123123'

           // destinations = "263773814511"; //multiple numbers allowed. Separate with commas

            // SMS Message to send
          //  message = "Testing Java to BulkSMS Webservice";

            // send via BulkSMS HTTP API
        try {
            ws_str = bulksms_ws + "&u=" + username + "&h=" + token + "&op=pv";
            ws_str = ws_str + "&to=" + URLEncoder.encode(destinations, "UTF-8") + "&msg=" + URLEncoder.encode(message,"UTF-8");

            url = new URL(ws_str);

            //----------------------------------------------//
            // Sttep 3: Open a URLConnection to the url.  //
            //----------------------------------------------//

            URLConnection conn = url.openConnection();         // throws an IOException

            //-------------------------------------------------------------//
            // Step 4:                                                     //
            //-------------------------------------------------------------//
            // Convert the InputStreamReader to a Buffered Reader.      //
            // Buffering the stream makes the reading faster; the          //
            // readLine() method of the BufferedReader makes the reading  //
            // easier.                                                     //
            //-------------------------------------------------------------//

            BufferedReader br = new BufferedReader(
                                   new InputStreamReader(conn.getInputStream()));

            //------------------------------------------------------------//
            // Step 5:                                                    //
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

         }

         }

      }