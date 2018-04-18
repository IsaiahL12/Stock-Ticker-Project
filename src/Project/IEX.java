package Project;

import java.net.*;
import java.nio.charset.Charset;
import java.io.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
///import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

//import com.orsoncharts.util.json.JSONArray;

//import org.json.JSONException;
//import org.json.JSONObject;


public class IEX {
	
	//IEX does not need a API key 
	public static final String IEXWebisite = "https://ws-api.iextrading.com/1.0/";
	public static final String refData = "https://api.iextrading.com/1.0/ref-data/symbols";
	public  static Vector<String>  find = new Vector<String>();
	public  static Vector<String>  parse = new Vector<String>();
	public  static Vector<String>  savedResult = new Vector<String>();
	public int choose = 1;
	public String symbol = null;
	
	public IEX(){
		
	}
	

	 private static  Vector<String>  readAllForVector(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		      if ('}'== cp) {
		    	  find.add(sb.toString());
		    	 sb = new StringBuilder();
		      }
		    }
		    return find;
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
	 
	
	 public static Vector<String> readUrlToVector(String url) throws IOException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      Vector<String> textVector = readAllForVector(rd);
	      return textVector;
	    } finally {
	      is.close();
	    }
	  }
	
	 /*
	 public Vector<String> searchForByNames(String jtextfeild) throws IOException {
		savedResult = new Vector<String>();
		Vector<String> getData = readUrlToVector(refData);
		 String search = "\"name\":\"";
		 search = search + jtextfeild;
		 for (int i = 0; i < getData.size(); i++) {
			 if(getData.get(i).toLowerCase().contains(search.toLowerCase())) {
				 parse.add(getData.get(i));
			 }
		 }
		 for (int i = 0; i < parse.size(); i++) {
			 String[] parsingString =parse.get(i).split(":");
			 parsingString = parsingString[2].split("\"");
			 savedResult.add(parsingString[1]);
		 }
		 
		 find = new Vector<String>();
		 parse = new Vector<String>();
		return savedResult;
	}
	*/
	
	 public Vector<String> searchForBySym(String jtextfeild) throws IOException {
		savedResult = new Vector<String>();
		Vector<String> getData = readUrlToVector(refData);
		 String search = "\"symbol\":\"";
		 search = search + jtextfeild;
		 for (int i = 0; i < getData.size(); i++) {
			 if(getData.get(i).toLowerCase().contains(search.toLowerCase())) {
				 parse.add(getData.get(i));
			 }
		 }
		 for (int i = 0; i < parse.size(); i++) {
			 String[] parsingString =parse.get(i).split(":");
			 parsingString = parsingString[1].split("\"");
			 savedResult.add(parsingString[1]);
		 }
		 
		 find = new Vector<String>();
		 parse = new Vector<String>();
		return savedResult;
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
			//System.out.println(getData1.toString());
			//JSONParser parse1 = new JSONParser();
			//JSONArray jobj = new JSONArray(getData1);
			
			//JSONArray array = new JSONArray();
			//array.add(jobj);
			//System.out.println("sfs");
			
			
			//System.out.println(jobj);
			
			
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
			//System.out.println(getData1.toString());
			//JSONParser parse1 = new JSONParser();
			//JSONArray jobj = new JSONArray(getData1);
			
			//JSONArray array = new JSONArray();
			//array.add(jobj);
			//System.out.println("sfs");
			
			
			//System.out.println(jobj);
			
			
			return savedResult;
	 }
	 /*
	 public String usingNameToFindSymbol(String jtextfeild) throws IOException, ParseException {
			Vector<String> getData = readUrlToVector(refData);
			
			 String search = "\"name\":\"";
			 search = search + jtextfeild;
			 for (int i = 0; i < getData.size(); i++) {
				 if(getData.get(i).toLowerCase().contains(search.toLowerCase())) {
					 parse.add(getData.get(i));
				 }
			 }
			 
			String[] parsingString =parse.get(0).split(":");
			parsingString = parsingString[1].split("\"");
			
			 find = new Vector<String>();
			 parse = new Vector<String>();
			 
			return parsingString[1];
			
		}
	 */
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
	 /*
	  * public String usingNameToFindSymbolWithJSON(String jtextfeild) throws IOException, ParseException, JSONException {
			Vector<String> Data = getDataByNamesWithAJSON(refData);
			String result = new String();
			 
			 for (int i = 0; i < Data.size(); i++) {
				 if(Data.get(i).toLowerCase().contentEquals(jtextfeild.toLowerCase())) {
					 parse.add(Data.get(i));
				 }
			 }
			 
			String[] parsingString =parse.get(0).split(":");
			parsingString = parsingString[1].split("\"");
			
			 find = new Vector<String>();
			 parse = new Vector<String>();
			 
			return parsingString[1];
			
		}
	 */
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
	 
	 public  Vector<Double> jsonOfDataDayM3(String symbol) throws IOException, JSONException {
		 	String url = new String();
		 	url =IEXWebisite + "stock/" +symbol+"/chart/3m";
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
	 public  Vector<Double> jsonOfDataDayHigh(String symbol) throws IOException, JSONException {
		 	String url = new String();
		 	url =IEXWebisite + "stock/" +symbol+"/chart/1d";
		 	InputStream is = new URL(url).openStream();
		    try {
		    	Vector <Double> High = new Vector <Double>();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      
		      for(int i= 0; i< json.length(); i++) {
		    	  High.add(json.getJSONObject(i).getDouble("marketHigh"));
		    	  //System.out.println(json.getJSONObject(i).getDouble("high"));
		    		     
		      }
		     
		      return High;
		    } finally {
		      is.close();
		    }
		  }
	 public  Vector<Double> jsonOfDataDayLow(String symbol) throws IOException, JSONException {
		 	String url = new String();
		 	url =IEXWebisite + "stock/" +symbol+"/chart/1d";
		 	InputStream is = new URL(url).openStream();
		    try {
		    	Vector <Double> Low = new Vector <Double>();
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONArray json = new JSONArray(jsonText);
		      
		      for(int i= 0; i< json.length(); i++) {
		    	  Low.add(json.getJSONObject(i).getDouble("marketLow"));
		    	  //System.out.println(json.getJSONObject(i).getDouble("low"));
		    		     
		      }
		     
		      return Low;
		    } finally {
		      is.close();
		    }
		  }
	*/
	 /*
	    public static void main(String [] args) throws IOException, JSONException, ParseException {
		IEX a= new IEX();
		a.jsonOfDataDayLow("A");
		
		//System.out.println(a.jsonOfData("AGCO"));
		//System.out.println(a.searchForByNames("Zi"));
			}
			*/
	    
		
	 
	 public String jsonOfData1m(String symbol) throws IOException {
		String stockData1m = new String();
		stockData1m =IEXWebisite + "stock/" +symbol+"/chart/1m";
		stockData1m = readJsonFromUrl(stockData1m);
		 //https://api.iextrading.com/1.0/stock/aapl/chart/1d
		 return stockData1m;
	 }
	
}
