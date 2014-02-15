package conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BufferedHeader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;
import android.util.Log;

public class JsonConection implements Runnable{
	
	 protected InputStream GetBufferFromGet(String url)

	 {
	     InputStream buffer = null;

	     try 
	     {

	       DefaultHttpClient httpClient = new DefaultHttpClient();

	       HttpGet g = new HttpGet(url);

	       g.setHeader("Accept", "application/json");

	       g.setHeader("Content-type", "application/json");

	       HttpResponse httpResponse = httpClient.execute(g);

	       HttpEntity httpEntity = httpResponse.getEntity();

	       buffer = httpEntity.getContent();

	     } 
	     catch (UnsupportedEncodingException e)
	     {

	    	 Log.d("jsonConection", "**ERROR " + e.toString());
	     } 

	     catch (ClientProtocolException e) 
	     {
	       Log.d("jsonconecction", e.toString());
	     }

	     catch (IOException e) 
	     {
	       System.out.println("**ERROR " + e.toString());
	     } 

	     return buffer;

	 }


	 //2.- Pasar el InputStream a un Objeto JSON

	 protected JSONObject GetJsonFromBuffer(InputStream InputBuffer) 
	 {    

	     InputStream bufferIn = InputBuffer;
	     String bufferOut = "";
	     JSONObject jObj = null;

	     try 
	     {
	         BufferedReader reader = new BufferedReader(new InputStreamReader(bufferIn, "utf-8"), 8);
	         StringBuilder sb = new StringBuilder();

	         String line = null;

	         while ((line = reader.readLine()) != null) 
	         {
	             sb.append(line + " ");
	         }
	         bufferIn.close();
	         
	         bufferOut = sb.toString();
	         Log.d("cadena", bufferOut);
	     } 
	     catch (Exception e) 
	     {
	         Log.d("Error buffer", e.getMessage());
	     }
	     try 
	     {
	        jObj = new JSONObject(bufferOut);
	     } 
	     catch (JSONException e) 
	     {
	         System.out.println("**ERROR " + e.toString());
	     }

	     return jObj;

	 }
	 
	 public void obtenerProductos(String url){
		 
		GetJsonFromBuffer(GetBufferFromGet(url));
	 }
	 
	 public String readTwitterFeed() {
		    StringBuilder builder = new StringBuilder();
		    HttpClient client = new DefaultHttpClient();
		    HttpGet httpGet = new HttpGet("http://localhost/json/json.php");
		    try {
		      HttpResponse response = client.execute(httpGet);
		      StatusLine statusLine = response.getStatusLine();
		      int statusCode = statusLine.getStatusCode();
		      if (statusCode == 200) {
		        HttpEntity entity = response.getEntity();
		        InputStream content = entity.getContent();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
		        String line;
		        while ((line = reader.readLine()) != null) {
		          builder.append(line);
		        }
		      } else {
		        Log.d("json_fail", "Failed to download file");
		      }
		      Log.d("jsonfinal",builder.toString());
		    } catch (ClientProtocolException e) {
		    	Log.d("json_fail", e.getMessage());
		    } catch (IOException e) {
		    	Log.d("json_fail", e.getMessage());
		    }
		    return builder.toString();
		  }


	@Override
	public void run() {
		Log.d("hilo",this.readTwitterFeed());
	}
	
	public void leerDatos()
	{
		final Handler hand = new Handler();
		Thread hilo = new Thread(){
			
			@Override
			public void run() {
				try
				{
					Thread.sleep(2000);
					
				}
				catch(Exception ex){
					Log.d("json_fail", ex.getMessage());
				}	
				hand.post(this);//-- al pasar esta clase se le pasa el metodo run automaticamente
			}	
		};
		hilo.start();
		
	}
	
	
}
