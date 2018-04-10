package Project;

import java.net.*;
import java.nio.charset.Charset;
import java.io.*;
import java.util.*;

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
	
	 public Vector<String> chooseOne (String jtextfeild) throws IOException{
		
		if(choose == 1) {
			return searchForByNames(jtextfeild);
		}
		else {
			return searchForBySym( jtextfeild);
			}
		
		
	}
	 
	 public String usingNameToFindSymbol(String jtextfeild) throws IOException {
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
	 
	 public String jsonOfData(String symbol) throws IOException {
		String stockData = new String();
		stockData =IEXWebisite + "stock/" +symbol+"/chart/1d";
		stockData = readJsonFromUrl(stockData);
		 //https://api.iextrading.com/1.0/stock/aapl/chart/1d
		 return stockData;
	 }
	/*
	public static void main(String [] args) throws IOException, JSONException {
		IEX a= new IEX();
		System.out.println(a.jsonOfData("AGCO"));
		//System.out.println(a.searchForByNames("Zi"));
			}
			*/
	
}
