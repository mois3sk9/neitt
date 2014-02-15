package com.proyect.neitt;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.util.ArrayList;

import org.json.JSONObject;

import conexion.hilos.AsyncDownloadTask;
import conexion.hilos.AsyncDownloadTask.AsyncTaskListener;
import conexion.hilos.especific.JsonUrl;
import conexion.JsonConection;

import entity.ItemProducto;
import entity.OpcionesDrawer;
import fragments.Fragment1;
import fragments.FragmentProductos;

import adaptadores.ListDrawerAdapter;
import adaptadores.ProductoAdapter;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private String[] opcionesMenu;
	private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private String titulo;
    
    private Fragment currentFragment;
    
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        String url = "http://localhost/json/json.php";
        
        
        //--Fragment por defecto--
        currentFragment = new Fragment1();
        
        
        //opciones
        opcionesMenu = new String[] {"Opci�n 1", "Opci�n 2", "Opci�n 3"};
        
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        
        drawerList = (ListView)findViewById(R.id.left_drawer); //Listview que corresponde al drawer
        //----se llena el list view
        ArrayList<OpcionesDrawer> opciones = new ArrayList<OpcionesDrawer>();
        opciones.add(new OpcionesDrawer("Check-in","Escanea tu producto",getResources().getDrawable(R.drawable.qrand)));
        opciones.add(new OpcionesDrawer("Productos","Revisar productos",getResources().getDrawable(R.drawable.socialgroup)));
        opciones.add(new OpcionesDrawer("Marcas","Ver marcas",getResources().getDrawable(R.drawable.socialgroup)));
        
        
        //drawerList.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(), android.R.layout.simple_list_item_1,opcionesMenu));
        
        //drawerList.setAdapter(new ListDrawerAdapter(this,opciones));
        drawerList.setAdapter(new ListDrawerAdapter(getSupportActionBar().getThemedContext(),opciones));
        
        //Eventos de la lista
        drawerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView parent, View view, int position,
					long id) {
				
				Fragment fragment = null;
				Log.d("position", "la posicion en : " + position);
				int pocicion = position +1;
				switch(pocicion)
				{
					case 1:
						fragment = new Fragment1();
						currentFragment = fragment;
						break;
					case 2:
						//Toast.makeText(MainActivity.this, "case 2", Toast.LENGTH_SHORT).show();
						fragment = currentFragment;
						Intent productosIntent = new Intent(MainActivity.this, ProductoActivity.class);
						startActivity(productosIntent);
						
						//startActivity(new Intent(this,ProductoActivity.class));
						//fragment  = new FragmentProductos();
						//currentFragment = fragment;
						break;
					case 3:
						fragment = currentFragment;
						AsyncDownloadTask asyncdownload = null;
						  
						  URL url1 = null;
						  
						  try
						  {
							  url1 = new URL("http://www.json-generator.com/j/bSlKZaWvYi?indent=4");
						  }
						  catch(Exception e){
							  
						  }
						  	
						  asyncdownload = new AsyncDownloadTask(new JsonUrl(MainActivity.this));
						  asyncdownload.execute(url1);
						
				       
						break;
					default:
						fragment = currentFragment;
						break;
				}
				
				android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
				
				//---Se reemplaza el fragment
				fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
				
				
				drawerList.setItemChecked(position, true);
				
				titulo = opcionesMenu[position];
				getSupportActionBar().setTitle(titulo);
				drawerLayout.closeDrawer(drawerList);
				
				
				/*if(currentFragment != null)
		        {
		        	//TextView t = (TextView)currentFragment.getView().findViewById(R.id.texto_fragment);
		        	//t.setText("holamundo");
		        }*/
			
				//comportamiento drawer
				
			}
		});
        
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_navigation_drawer, R.string.abc_action_bar_home_description, R.string.abc_action_bar_up_description){
        	@Override
        	public void onDrawerClosed(View drawerView) {
        		// TODO Auto-generated method stub
        		super.onDrawerClosed(drawerView);
        		getSupportActionBar().setTitle(titulo);
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
        	}
        	@Override
        	public void onDrawerOpened(View drawerView) {
        		// TODO Auto-generated method stub
        		super.onDrawerOpened(drawerView);
        		
        		getSupportActionBar().setTitle(titulo);
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
        	}
        };
         drawerLayout.setDrawerListener(drawerToggle);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0342ab")));
         getSupportActionBar().setHomeButtonEnabled(true);
         
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	
    	//Saber si el drawer esta abierto
    	boolean menuAbierto = drawerLayout.isDrawerOpen(drawerList);
    	
    	
    	if(menuAbierto)
    	{
    		menu.findItem(R.id.action_search).setVisible(false);
    	}
    	else
    	{
    		menu.findItem(R.id.action_search).setVisible(true);
    	}
    	return super.onPrepareOptionsMenu(menu);
    }
    	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	
    	if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
    	
    	switch(item.getItemId())
        {
                case R.id.action_settings:
                        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                case R.id.action_search:
                        Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                        break;
                default:
                        return super.onOptionsItemSelected(item);
        }
    	return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
     
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
    
}
