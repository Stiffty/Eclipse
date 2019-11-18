package Schule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.jar.JarException;

import javax.tools.JavaFileObject;
import org.json.JSONException;
import org.json.JSONObject;


public class RekusionPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonReader jr = new JsonReader();
		JSONObject json;
		try {
			json = jr.readJsonFromUrl("https://cc.the-morpheus.de/challenges/15/");
			System.out.println(json.toString());
		    System.out.println(json.get("id"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

		
		Scanner sc = new Scanner(System.in);
		
		String eingabe = sc.next();
		char[] Eingabe = eingabe.toCharArray();
		if(Palindrom(Eingabe, 0 , Eingabe.length-1) == true){
			System.out.println("Ihre Eingabe ist ein Palindrom");
		}else{
			System.out.println("Ihre Eingabe ist kein Palindrom");
		}
	}
	
	public static boolean Palindrom(char[] eingabe, int a ,int b){
		
		if (eingabe[a] != eingabe[b]) {
			return false;
		} else {
			if(a==b||b<a){
				return true;
			}else{
			Palindrom(eingabe, a+=1, b-=1);
			
			return true;
			}
		}
	}
	
	 
}
class JsonReader {

	  private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }

	  
	}
