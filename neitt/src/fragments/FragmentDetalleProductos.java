package fragments;

import java.util.zip.Inflater;

import com.proyect.neitt.R;

import entity.ItemProducto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
	
	public void updateDetails(ItemProducto producto)
	{
		//--Metodo para actualizar la informacion de los componentes
		TextView titulo = (TextView)getActivity().findViewById(R.id.lbl_titulo_dp);
		TextView subtitulo = (TextView)getActivity().findViewById(R.id.lbl_subtitulo_dp);
		ImageView imagen = (ImageView) getActivity().findViewById(R.id.imagen_dtl_producto);
		
		titulo.setText(producto.getTitulo());
		subtitulo.setText(producto.getSubTitulo());
		
		if(producto.getImage() !=0){
			
			imagen.setImageResource(producto.getImage());
			
		}
	}

}
