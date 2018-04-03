package Project;

import java.net.*;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;

public class IEX {
	
	//IEX does not need a API key 
	public static final String IEXWebisite = "https://ws-api.iextrading.com/1.0/";
	
	public IEX() throws IOException, JSONException  {
		
	}

	 private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }
	  

	  public static String readJsonFromUrl(String url) throws IOException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      return jsonText;
	    } finally {
	      is.close();
	    }
	  }
	
	public static void main(String [] args) throws IOException, JSONException {
		 String test = "https://api.iextrading.com/1.0/stock/aapl/batch?types=quote,news,chart&range=1m&last=10";
		 String getData = readJsonFromUrl(test);
		 
		 JSONObject json = new JSONObject(getData);
		 System.out.println(json);
			}
}
