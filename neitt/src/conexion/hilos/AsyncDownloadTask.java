package conexion.hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class AsyncDownloadTask extends AsyncTask<URL, Integer, JSONObject> {
	/*
	 * Clase para realizar la conexion a una url determinada y bajar un json
	 * 
	 */

	 public interface AsyncTaskListener{ 
		 /*
		  * Interfaz que debera implementar la clase la cual quiera ejecutar
		  * una llamada a una url para obtener un json
		  */
			 void onInit(); 
			 void onProgressUpdate(Integer progress); 
			 void onCancel();
			 void onFinish(JSONObject json);
		 }
	 
	 private AsyncTaskListener asyncTaskListener;/*Se guarda la interfaz local*/
	 
	 
	 public AsyncDownloadTask(AsyncTaskListener asyncTaskListener){
	  this.asyncTaskListener = asyncTaskListener;
	 }
	 
	 @Override
	 protected JSONObject doInBackground(URL... urls) {
	  
	  int  count = urls.length;
	  JSONObject json = new JSONObject();
	  
	  
	  for(int i = 0; i < count; i++){
	   if(isCancelled())
	    break;
	   
	   HttpClient httpclient = new DefaultHttpClient();

	      HttpGet httpget = new HttpGet(urls[i].toString());

	     
	      HttpResponse response;
	      try {
	          response = httpclient.execute(httpget);
	          
	          if(response.getStatusLine().getStatusCode() == 200){
	          
	           HttpEntity entity = response.getEntity();
	          
	           if (entity != null) { 
	               InputStream instream = entity.getContent();
	               String result= convertStreamToString(instream);
	               json.put("response_" + String.valueOf(i+1), new JSONObject(result));
	               
	               instream.close();
	           }

	    } else {
	     //cancel(true);
	    }
	      } catch (Exception e) {
	    	  Log.d("se cayo", e.getLocalizedMessage());
	       cancel(true);
	      }
	   
	   publishProgress((int) ((i / (float) count) * 100 ));
	   
	   
	  }
	  
	  return json;
	 }
	 
	 private static String convertStreamToString(InputStream is) {
	     BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	     StringBuilder sb = new StringBuilder();

	     String line = null;
	     try {
	         while ((line = reader.readLine()) != null) {
	             sb.append(line + "\n");
	         }
	     } catch (IOException e) {
	         Log.d("json_fail_convert", e.getMessage());
	     } finally {
	         try {
	             is.close();
	         } catch (IOException e) {
	        	 Log.d("json_fail_convert", e.getMessage());
	         }
	     }
	     return sb.toString();
	 }
	 
	 @Override
	 protected void onPreExecute(){
	  asyncTaskListener.onInit();
	 }
	 
	 @Override
	 protected void onProgressUpdate(Integer... progress){
	  asyncTaskListener.onProgressUpdate(progress[0]);
	 }
	 
	 @Override
	 protected void onPostExecute(JSONObject json){
	  asyncTaskListener.onFinish(json);  
	 }
	 
	 @Override
	 protected void onCancelled(){
	  asyncTaskListener.onCancel();
	 }

	} 