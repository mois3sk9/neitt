package com.proyect.neitt;

import java.security.PublicKey;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private String[] opcionesMenu;
	private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private String titulo;
    
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                
        
        //opciones
        opcionesMenu = new String[] {"Opci�n 1", "Opci�n 2", "Opci�n 3"};
        
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        
        drawerList = (ListView)findViewById(R.id.left_drawer);
        //se llena el list view
        drawerList.setAdapter(new ArrayAdapter<String>(this.getSupportActionBar().getThemedContext(), android.R.layout.simple_list_item_1,opcionesMenu));
        
        
       
        //Eventos de la lista
        drawerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView parent, View view, int position,
					long id) {
				
				Fragment fragment = null;
				switch(position)
				{
					case 1:
						fragment = new Fragment1();
						break;
				}
				
				android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
				
				fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
				
				
				drawerList.setItemChecked(position, true);
				
				 titulo = opcionesMenu[position];
				getSupportActionBar().setTitle(titulo);
				drawerLayout.closeDrawer(drawerList);
			
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
