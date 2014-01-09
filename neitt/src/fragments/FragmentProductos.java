package fragments;

import java.util.ArrayList;

import com.proyect.neitt.DetalleProductoActivity;
import com.proyect.neitt.MainActivity;
import com.proyect.neitt.R;
import com.proyect.neitt.R.id;
import com.proyect.neitt.R.layout;

import entity.ItemProducto;

import adaptadores.ProductoAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentProductos extends Fragment{

	ArrayList<ItemProducto> productos = new ArrayList<ItemProducto>();
	
	
	//--Interfaz para la comunicacion con la activity
	public interface OnComunicationProductos {
        public void onArticleSelected(int position,View view,ItemProducto producto);
    }
	
	OnComunicationProductos callback;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//GridView grilla = (GridView)getView().findViewById(R.id.grilla_productos);
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		//---esto se asegura de que la activity que contenga este fragment implemente la interfaz onComunicationProduct
		try{
			callback = (OnComunicationProductos)activity;
		}
		catch(ClassCastException e)
		{
			throw new ClassCastException(activity.toString() + "Se debe implementar onComunicationProducts");
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//--Se recupera el fragment 
		View rootView = inflater.inflate(R.layout.fragment_productos, container,false);
		
		GridView grilla = (GridView) rootView.findViewById(R.id.grilla_productos);
		
		//--Escuchador grilla--
		grilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				//---Saber si el otro fragment se encuentra en el layout
				//--se pregunta si la orientacion de la pantalla esta en modo landscape
				if((getActivity().getResources().getConfiguration().orientation) == Configuration.ORIENTATION_LANDSCAPE)
				{
					//--Se ejecuta la interfaz callback en caso de tener el detalle del producto en la misma activity.
					callback.onArticleSelected(position,view,productos.get(position));
				}
				else
				{
					//--Si no esta en la misma activity, se transapasa a una activity que contiene solo el detalle del producto
					Intent detalleProductos = new Intent(getActivity(),DetalleProductoActivity.class);
					startActivity(detalleProductos);
					
				}
				Toast.makeText(getActivity().getApplicationContext(), "la pocicion pulsada fue" + position, 3000).show();
				
			}
		
		});
		
		ItemProducto producto = new ItemProducto("tablet de 7\"","Tablet AoC",R.drawable.table1t);
		ItemProducto producto2 = new ItemProducto("intel core i5","Notebook Samsung",R.drawable.notebook1);
		ItemProducto producto3 = new ItemProducto("celular 4\"","Samsung Galaxy",R.drawable.celu1);
		ItemProducto producto4 = new ItemProducto(";D","Producto4");
		ItemProducto producto5 = new ItemProducto(";D","Producto5");
		ItemProducto producto6 = new ItemProducto(";D","Producto6");
		ItemProducto producto7 = new ItemProducto(";D","Producto7");
		ItemProducto producto8 = new ItemProducto(";D","Producto8");
		ItemProducto producto9 = new ItemProducto(";D","Producto9");
		ItemProducto producto10 = new ItemProducto(";D","Producto10");
		
		
		productos.add(producto);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);
		productos.add(producto5);
		productos.add(producto6);
		productos.add(producto7);
		productos.add(producto8);
		productos.add(producto9);
		productos.add(producto10);
		
		grilla.setAdapter(new ProductoAdapter(this.getActivity(),productos,1));
		
		
		
		
		
		return rootView;
		
		
		
	}
	
	
}
