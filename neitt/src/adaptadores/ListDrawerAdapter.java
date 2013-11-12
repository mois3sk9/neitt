package adaptadores;

import java.util.ArrayList;

import com.proyect.neitt.R;

import entity.ItemProducto;
import entity.OpcionesDrawer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDrawerAdapter extends BaseAdapter{

	ArrayList<OpcionesDrawer> opciones;
	Activity activity;
	Context context;
	LayoutInflater inflater = null;
	
	public ListDrawerAdapter()
	{
		
	}
	public ListDrawerAdapter(Activity acitivity,ArrayList<OpcionesDrawer> datos)
	{
		this.activity = acitivity;
		this.opciones = datos;
		
		inflater = activity.getLayoutInflater();
		
		
	}
	public ListDrawerAdapter(Context context,ArrayList<OpcionesDrawer> datos)
	{
		this.context = context;
		this.opciones = datos;
		
		if(context !=null)
		{
			inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return opciones.size();
	}
	

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return opciones.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		OpcionesDrawer opcionesDrawer = (OpcionesDrawer)this.getItem(position);
		LayoutInflater in = this.inflater;
		
		if(v == null)//Si el item no esta renderizado
		{
			//LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = in.inflate(R.layout.adaptador_lista_drawer,null);
			//v = in.inflate(R.layout.adaptador_productos, null);
		}
		
		ImageView imagenDrawer = (ImageView)v.findViewById(R.id.image_list_drawer);
		TextView tituloListaDrawer  = (TextView)v.findViewById(R.id.titulo_list_drawer);
		TextView subtituloListaDrawer  = (TextView)v.findViewById(R.id.subtitulo_list_drawer);
		imagenDrawer.setImageDrawable(opcionesDrawer.getFoto());
		tituloListaDrawer.setText(opcionesDrawer.getTitulo());
		subtituloListaDrawer.setText(opcionesDrawer.getSubtitulo());
		
		return v;
	}

}
