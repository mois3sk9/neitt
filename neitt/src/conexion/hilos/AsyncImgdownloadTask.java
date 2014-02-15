package conexion.hilos;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONObject;

import conexion.hilos.AsyncDownloadTask.AsyncTaskListener;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

public class AsyncImgdownloadTask extends AsyncTask<URL,Integer,ArrayList<Bitmap>>{
	
	public interface AsyncImgListener{ 
		 /*
		  * Interfaz que debera implementar la clase la cual quiera ejecutar
		  * una llamada a una url para obtener las imagenes
		  */
			 void onInit(); 
			 void onProgressUpdate(Integer progress); 
			 void onCancel();
			 void onFinish(ArrayList<Bitmap> imagenes);
		 }
	private AsyncImgListener listenerImg;
	
	public AsyncImgdownloadTask(AsyncImgListener asyncImgTaskListener){
		  this.listenerImg = asyncImgTaskListener;
		 }
	
	
	public AsyncImgdownloadTask() {
		// TODO Auto-generated constructor stub
	}

	@Override
    protected ArrayList<Bitmap> doInBackground(URL... params) {
        // TODO Auto-generated method stub
        //Log.i(doInBackground , Entra en doInBackground);
        int count = params.length;
        ArrayList<Bitmap> imagenes = new ArrayList<Bitmap>();
        Bitmap imagen;
        for(int i=0;i<count;i++)
        {
        	imagenes.add(downloadImage(params[i]));
        	publishProgress((int) ((i / (float) count) * 100 ));
        }
        
        return imagenes;
        
        
        
    }
	@Override
	protected void onProgressUpdate(Integer... progress) {
		listenerImg.onProgressUpdate(progress[0]);
	};
	
	@Override
	protected void onCancelled() {
		listenerImg.onCancel();
		
	};
	@Override
	protected void onPostExecute(ArrayList<Bitmap> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		listenerImg.onFinish(result);
	}
	
	public Bitmap downloadImage(URL urlImagen){
		URL imageUrl = urlImagen;
		Bitmap imagen = null;
		try
		{
			HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
			conn.connect();
			imagen = BitmapFactory.decodeStream(conn.getInputStream());
			
		}
		catch(Exception ex)
		{
			
		}
		
		return imagen;
	}

	
}
