package conexion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;

public class SaveOnMemory {
	/*
	 * Clase la cual puede guardar imagenes en la memoria interna del telefono
	 */
	
	private static final String Imagenes = null;
	private Activity acitivity;
	
	public SaveOnMemory()
	{
		
	}
	public SaveOnMemory(Activity activity)
	{
		setActivity(activity);
	}
	
	public Activity getActivity(){
		return this.acitivity;
	}
	public void setActivity(Activity activity){
		this.acitivity = acitivity;
	}
	
	public String saveImage(Context context, String nombre, Bitmap imagen){
		/*
		 * context : contexto de la activity
		 * nombre  : nombre con el cual se guardara el archivo
		 * imagen  : bitmap con la imagen que se guardara
		 */
	    ContextWrapper cw = new ContextWrapper(context);
	    File dirImages = cw.getDir(Imagenes, Context.MODE_PRIVATE);
	    String png;
		File myPath = new File(dirImages, nombre);
	    
	    FileOutputStream fos = null;
	    try{
	        fos = new FileOutputStream(myPath);
	        imagen.compress(Bitmap.CompressFormat.JPEG, 10, fos);
	        fos.flush();
	    }catch (FileNotFoundException ex){
	        ex.printStackTrace();
	    }catch (IOException ex){
	        ex.printStackTrace();
	    }
	    return myPath.getAbsolutePath();
	}
	
	
	
	
	
	
}
