package conexion.hilos.especific;
import org.json.JSONObject;

import com.proyect.neitt.R;

import android.app.Activity;
import android.webkit.WebView.FindListener;
import android.widget.TextView;

import conexion.hilos.AsyncDownloadTask.AsyncTaskListener;

public  class JsonUrl implements AsyncTaskListener{

	Activity activity = null;
	
	public JsonUrl()
	{
		
	}
	public JsonUrl(Activity activity){
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
	public void onFinish(JSONObject json) {
		TextView detalle = (TextView)this.activity.findViewById(R.id.txtDetalle);
		detalle.setText("Json bajado");
	}

}
