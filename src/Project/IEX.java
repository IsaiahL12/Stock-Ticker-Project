package Project;

import java.nio.charset.Charset;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;


public class IEX {
	
	//IEX does not need a API key 
	public static final String IEXWebisite = "https://ws-api.iextrading.com/1.0/";
	public static final String refData = "https://api.iextrading.com/1.0/ref-data/symbols";
	public  static Vector<String>  find = new Vector<String>();
	//public  static Vector<String>  parse = new Vector<String>();
	public  static Vector<String>  savedResult = new Vector<String>();
	public int choose = 1;
	public String symbol = null;
	
	public IEX(){
		
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
	 
	public static Vector<String> getDataByNamesWithAJSON(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		    	Vector <String> hold = new Vector <String>();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      
		      for(int i= 0; i< json.length(); i++) {
		    	 hold.add(json.getJSONObject(i).getString("name"));
		    		     
		      }
		     
		      return hold;
		    } finally {
		      is.close();
		    }
		  }
	  
	public static Vector<String> getDataBySymbolWithAJSON(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		    	Vector <String> hold = new Vector <String>();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      
		      for(int i= 0; i< json.length(); i++) {
		    	 hold.add(json.getJSONObject(i).getString("symbol"));
		    		     
		      }
		     
		      return hold;
		    } finally {
		      is.close();
		    }
		  }
	 
	
	public Vector<String> chooseOne (String jtextfeild) throws IOException, ParseException, JSONException{
		
		if(choose == 1) {
			return searchForByNamesWithJSON(jtextfeild);
		}
		else {
			return searchForBySymbolWithJSON( jtextfeild);
			}
		
		
	}
	
	public Vector<String> searchForByNamesWithJSON(String jtextfeild) throws IOException, ParseException, JSONException {
		 	savedResult = new Vector<String>();
			Vector<String> getData1 = getDataByNamesWithAJSON(refData);
			for( int i = 0; i <getData1.size(); i++) {
				if (getData1.get(i).toLowerCase().startsWith(jtextfeild.toLowerCase())) {
					savedResult.add(getData1.get(i));
					//System.out.println(getData1.get(i));
				}
			}
			
			return savedResult;
	 }
	 
	
	
	
	
	public Vector<String> searchForBySymbolWithJSON(String jtextfeild) throws IOException, ParseException, JSONException {
		 	savedResult = new Vector<String>();
			Vector<String> getData1 = getDataBySymbolWithAJSON(refData);
			for( int i = 0; i <getData1.size(); i++) {
				if (getData1.get(i).toLowerCase().startsWith(jtextfeild.toLowerCase())) {
					savedResult.add(getData1.get(i));
					//System.out.println(getData1.get(i));
				}
			}
			
			return savedResult;
	 }

	public String usingNameToFindSymbolWithJSON(String name) throws IOException, JSONException {
		    InputStream is = new URL(refData).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      String result = new String();
		      for(int i= 0; i< json.length(); i++) {
		    	  if(json.getJSONObject(i).getString("name").toLowerCase().startsWith(name.toLowerCase())) {
		    		  result = json.getJSONObject(i).getString("symbol");
		    		  //System.out.println(result);
		    	  }
		    	 
		    		     
		      }
		     
		      return result;
		    } finally {
		      is.close();
		    }
		  }
	
	public String jsonOfData(String symbol) throws IOException {
		String stockData = new String();
		stockData =IEXWebisite + "stock/" +symbol+"/chart/1d";
		stockData = readJsonFromUrl(stockData);
		 //https://api.iextrading.com/1.0/stock/aapl/chart/1d
		 return stockData;
	 }
	
	public  Vector<Double> jsonOfDataDayAvg(String symbol) throws IOException, JSONException {
		 	String url = new String();
		 	url =IEXWebisite + "stock/" +symbol+"/chart/1d";
		 	InputStream is = new URL(url).openStream();
		    try {
		    	Vector <Double> average = new Vector <Double>();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      
		      for(int i= 0; i< json.length(); i++) {
		    	  average.add(json.getJSONObject(i).getDouble("marketAverage"));
		    	  //System.out.println(json.getJSONObject(i).getDouble("average"));
		    		     
		      }
		     
		      return average;
		    } finally {
		      is.close();
		    }
		  }
	
	public  Vector<String> jsonOfDataDayTime(String symbol, String type ) throws IOException, JSONException {
	 	String url = new String();
	 	if(type.contentEquals("1m")){
	 		url =IEXWebisite + "stock/" +symbol+"/chart/1m";	
	 	}
	 	else if(type.contentEquals("3m")) {
	 		url =IEXWebisite + "stock/" +symbol+"/chart/6m";
	 	}
	 	else {
	 		url =IEXWebisite + "stock/" +symbol+"/chart/1y";	
	 	}
	 
	 	InputStream is = new URL(url).openStream();
	    try {
	    	Vector <String> time = new Vector <String>();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONArray json = new JSONArray(jsonText);
	      
	      for(int i= 0; i< json.length(); i++) {
	    	  time.add(json.getJSONObject(i).getString("date"));
	    	  //System.out.println(json.getJSONObject(i).getString("minute"));
	    		     
	      }
	     
	      return time;
	    } finally {
	      is.close();
	    }
	  }
	 
	public  Vector<Double> jsonOfDataDayM1(String symbol) throws IOException, JSONException {
		 	String url = new String();
		 	url =IEXWebisite + "stock/" +symbol+"/chart/1m";
		 	InputStream is = new URL(url).openStream();
		    try {
		    	Vector <Double> month1 = new Vector <Double>();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      
		      for(int i= 0; i< json.length(); i++) {
		    	  month1.add(json.getJSONObject(i).getDouble("close"));
		    	  //System.out.println(json.getJSONObject(i).getDouble("average"));
		    		     
		      }
		     
		      return month1;
		    } finally {
		      is.close();
		    }
		  }
	 
	public  Vector<Double> jsonOfDataDayM6(String symbol) throws IOException, JSONException {
		 	String url = new String();
		 	url =IEXWebisite + "stock/" +symbol+"/chart/6m";
		 	InputStream is = new URL(url).openStream();
		    try {
		    	Vector <Double> month3 = new Vector <Double>();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      
		      for(int i= 0; i< json.length(); i++) {
		    	  month3.add(json.getJSONObject(i).getDouble("close"));
		    	  //System.out.println(json.getJSONObject(i).getDouble("average"));
		    		     
		      }
		     
		      return month3;
		    } finally {
		      is.close();
		    }
		  }
	 
	public  Vector<Double> jsonOfDataDayY1(String symbol) throws IOException, JSONException {
		 	String url = new String();
		 	url =IEXWebisite + "stock/" +symbol+"/chart/1y";
		 	InputStream is = new URL(url).openStream();
		    try {
		    	Vector <Double> month3 = new Vector <Double>();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      
		      for(int i= 0; i< json.length(); i++) {
		    	  month3.add(json.getJSONObject(i).getDouble("close"));
		    	  //System.out.println(json.getJSONObject(i).getDouble("average"));
		    		     
		      }
		     
		      return month3;
		    } finally {
		      is.close();
		    }
		  }
	/*
	public static void main (String[] args) throws IOException, JSONException {
		IEX a = new IEX();
		a.jsonOfDataDayTime("aapl");
		
		
		
	}
	*/
}
