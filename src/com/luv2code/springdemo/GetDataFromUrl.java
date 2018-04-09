package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

import org.json.JSONException;
import org.json.JSONArray;

public class GetDataFromUrl {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONArray json = new JSONArray(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

//  public static void main(String[] args) {
//      Map m1 = new HashMap();
//      m1.put("Zara", "8");
//      m1.put("Mahnaz", "31");
//      m1.put("Ayan", "12");
//      m1.put("Daisy", "14");
//
//      System.out.println();
//      System.out.println(" Map Elements");
//      System.out.print("\t" + m1);
//   }

  public static Map<String, Object> main(String[] args) throws IOException, JSONException {
	JSONArray json = readJsonFromUrl("http://XXXX");
	Map<String, Object> map = new HashMap<String, Object>(); 
	for(int i=0; i<json.length(); i++) {

    	Object customerName = json.getJSONObject(i).getJSONObject("envData").get("accName");
    	Object landscape = json.getJSONObject(i).getJSONObject("envData").get("envType");
    	//System.out.println(customerName + ", " + landscape);

    	map.put("customerName", customerName);
    	map.put("landscape", landscape);
    	//System.out.print(map);

    }
	return map;
  }
}
