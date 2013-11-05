package com.proyect.neitt;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrawerHelper extends ActionBarDrawerToggle implements DrawerListener{

	ActionBarActivity context;
	public DrawerHelper(Activity activity, DrawerLayout drawerLayout,
			int drawerImageRes, int openDrawerContentDescRes,
			int closeDrawerContentDescRes) {
		
		super(activity, drawerLayout, drawerImageRes, openDrawerContentDescRes,
				closeDrawerContentDescRes);
		context = (ActionBarActivity)activity;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onDrawerClosed(View drawerView) {
		// TODO Auto-generated method stub
		context.getSupportActionBar().setTitle("hola");
		super.onDrawerClosed(drawerView);
		ActivityCompat.invalidateOptionsMenu(context);
		
	}
	
	@Override
	public void onDrawerOpened(View drawerView) {
		// TODO Auto-generated method stub
		context.getSupportActionBar().setTitle("chao");
		super.onDrawerOpened(drawerView);
		ActivityCompat.invalidateOptionsMenu(context);
	}
	
	
	
	
	
	

}
