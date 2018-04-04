package Project;

import java.net.*;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.util.*;


public class IEX {
	
	//IEX does not need a API key 
	public static final String IEXWebisite = "https://ws-api.iextrading.com/1.0/";
	public static final String refData = "https://api.iextrading.com/1.0/ref-data/symbols";
	public  static Vector<String>  hold = new Vector<String>();
	public  static Vector<String>  parse = new Vector<String>();
	public  static Vector<String>  savedResult = new Vector<String>();
	public IEX() throws IOException, JSONException  {
		
	}
	
	

	 private static  Vector<String>  readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		      if ('}'== cp) {
		    	 hold.add(sb.toString().toLowerCase());
		    	 sb = new StringBuilder();
		    }
		    }
		    return hold;
		  }
	  

	  public static Vector<String> readJsonFromUrl(String url) throws IOException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      Vector<String> jsonText = readAll(rd);
	      return jsonText;
	    } finally {
	      is.close();
	    }
	  }
	
	public static void main(String [] args) throws IOException, JSONException {
		 Vector<String> getData = readJsonFromUrl(refData);
		 String a = "\"name\":\"A";
		 //JSONObject json = new JSONObject(getData);
		 for (int i = 0; i < getData.size(); i++) {
			 if(getData.get(i).contains(a.toLowerCase())) {
		 System.out.println(getData.get(i));
			 }
		 }
			}
	
	public String searchForByNames() {
		return null;
	}
	
}
