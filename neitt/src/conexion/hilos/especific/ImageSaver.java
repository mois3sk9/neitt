package conexion.hilos.especific;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import conexion.SaveOnMemory;
import conexion.hilos.AsyncImgdownloadTask.AsyncImgListener;

public class ImageSaver implements AsyncImgListener{
	/*
	 * En esta clase se implementara el guardado de las imagenes que se bajen
	 * desde el componente AsyncImgDowloadTask y se guardaran en la memoria con 
	 * la clase SaveOnMemory
	 */
	
	Activity activity;
	
	public ImageSaver(){
		
	}
	public ImageSaver(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public void onInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProgressUpdate(Integer progress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ArrayList<Bitmap> imagenes) {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		for(Bitmap b : imagenes){
			String nombreArchivo = String.valueOf(r.nextInt());
			SaveOnMemory saver = new SaveOnMemory();
			saver.saveImage(
					this.activity.getApplicationContext(),
					nombreArchivo, 
					b
					);
			
		}
		
		
	}
	
	
	

}
