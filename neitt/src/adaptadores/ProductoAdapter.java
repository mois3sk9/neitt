package adaptadores;

import java.util.ArrayList;

import com.proyect.neitt.R;
import com.proyect.neitt.R.id;
import com.proyect.neitt.R.layout;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import entity.ItemProducto;

public class ProductoAdapter extends BaseAdapter{

	/*--Adaptador que se utiliza en la grilla definida en el layout fragment_productos
	 * 
	 * 
	 */
	private Context context;
	ArrayList<ItemProducto> productos;
	Activity activity;
	private LayoutInflater inflater = null;
	
	public ProductoAdapter(Context context)
	{
		this.context = context;
	}
	public 	ProductoAdapter(Context context, ArrayList<ItemProducto> productos)
	{
		this.context = context;
		this.productos = productos;
	}
	public 	ProductoAdapter(Activity activity, ArrayList<ItemProducto> productos,int dd)
	{
		this.activity = activity;
		this.productos = productos;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		
		return productos.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return productos.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		//ViewHolder holder;
		View v = convertView;
		ItemProducto producto = (ItemProducto)this.getItem(position);
		LayoutInflater in = activity.getLayoutInflater();
	
		
		if(v == null)//Si el item no esta renderizado
		{
			//LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = in.inflate(R.layout.adaptador_productos,null);
			//v = in.inflate(R.layout.adaptador_productos, null);
		}
		
		//Se referencian los componenetes
		TextView titulo = (TextView)v.findViewById(R.id.productos_titulo);
		TextView subtitulo = (TextView)v.findViewById(R.id.productos_subtitulo);
		ImageView imagen  = (ImageView)v.findViewById(R.id.productos_imagen);
		//se carga cada producto dentro de la grilla
		
		titulo.setText(producto.getTitulo());
		subtitulo.setText(producto.getSubTitulo());
		if(imagen!=null)
			imagen.setImageResource(producto.getImage());
		
		
		
		return v;
	}
	
	

}
