package fragments;

import java.util.zip.Inflater;

import com.proyect.neitt.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentDetalleProductos extends Fragment{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//--Se recupera la vista--
		View rootView = (View) inflater.inflate(R.layout.fragment_detalle_productos, container,false);
		
		
		return rootView;
	}

}
