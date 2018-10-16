package utilities;

import java.net.URL;
import java.io.InputStream;
import javax.net.ssl.HttpsURLConnection;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;




public class VerifyReCaptcha {
	
	private static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
	private static final String SITE_SECRET = "6LfKBXUUAAAAAGnfomWkfBfms3RxT6FRajcIs70c";
	
	public static boolean verify(String gRecaptchaResponse) {
		try {
			// Open connection to Google Site Verify URL
			URL url = new URL(SITE_VERIFY_URL);
			
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			
			String postParams = "secret=" + SITE_SECRET + "&response=" + gRecaptchaResponse;
			
			// Send Request
			connection.setDoOutput(true);
			
			
			OutputStream outStream = connection.getOutputStream();
			outStream.write(postParams.getBytes());
			
			outStream.flush();
			outStream.close();
			
			int responseCode = connection.getResponseCode();
			System.out.println("responseCode= " + responseCode);
			
			InputStream input = connection.getInputStream();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(input, "UTF-8"));
			
			System.out.println(jsonObject.get("success"));
			
			return (boolean) jsonObject.get("success");
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}	
}
