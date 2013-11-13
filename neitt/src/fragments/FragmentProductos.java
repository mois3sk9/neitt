package fragments;

import java.util.ArrayList;

import com.proyect.neitt.R;
import com.proyect.neitt.R.id;
import com.proyect.neitt.R.layout;

import entity.ItemProducto;

import adaptadores.ProductoAdapter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class FragmentProductos extends Fragment{

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//GridView grilla = (GridView)getView().findViewById(R.id.grilla_productos);
		
		
		
		
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//--Se recupera el fragment 
		View rootView = inflater.inflate(R.layout.fragment_productos, container,false);
		
		GridView grilla = (GridView) rootView.findViewById(R.id.grilla_productos);
		
		ItemProducto producto = new ItemProducto("hola","producto1");
		ItemProducto producto2 = new ItemProducto("chao","Producto2");
		ItemProducto producto3 = new ItemProducto(";D","Producto3");
		ItemProducto producto4 = new ItemProducto(";D","Producto4");
		ItemProducto producto5 = new ItemProducto(";D","Producto5");
		ItemProducto producto6 = new ItemProducto(";D","Producto6");
		ItemProducto producto7 = new ItemProducto(";D","Producto7");
		ItemProducto producto8 = new ItemProducto(";D","Producto8");
		ItemProducto producto9 = new ItemProducto(";D","Producto9");
		ItemProducto producto10 = new ItemProducto(";D","Producto10");
		
		ArrayList<ItemProducto> productos = new ArrayList<ItemProducto>();
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
