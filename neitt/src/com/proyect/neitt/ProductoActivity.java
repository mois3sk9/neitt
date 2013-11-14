package com.proyect.neitt;

import entity.ItemProducto;
import fragments.FragmentDetalleProductos;
import fragments.FragmentProductos.OnComunicationProductos;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;

public class ProductoActivity extends ActionBarActivity implements OnComunicationProductos{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_productos);
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		getMenuInflater().inflate(R.menu.actionbar, menu);
		
		return true;
	}

	@Override
	public void onArticleSelected(int position, View view) {
		// TODO Auto-generated method stub
		
		FragmentDetalleProductos detalleProductos = (FragmentDetalleProductos)getSupportFragmentManager().findFragmentById(R.id.frag_dtl_productos);
		
		if(detalleProductos !=null)
		{
			ItemProducto producto = new ItemProducto();
			producto.setTitulo(String.valueOf(position));
			producto.setSubTitulo(";D");
			detalleProductos.updateDetails(producto);
		}
		
	}
	

}
