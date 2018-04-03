package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class AlpaVantage {
	public static final String apiKey = "MAJ5WVSN3G5MAFXH";
	//public static final String quandlWebisite = "https://www.quandl.com/api/v3/datasets/";
	AlpaVantage(){
		
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
		 String test = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=15min&outputsize=full&apikey=demo";
		 String getData = readJsonFromUrl(test);
		 
		 JSONObject json = new JSONObject(getData);
		 System.out.println(json);
			}
	
	
	
	
}
