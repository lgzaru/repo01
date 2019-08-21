package functions;

public class OTP {
	
	public static int getOTP(){
        java.util.Random r=new java.util.Random();
        int otp = r.nextInt(1000000); // no. of zeros depends on the OTP digit
        //System.out.println(otp);
        return otp;
}

}
