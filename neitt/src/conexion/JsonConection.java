package conexion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BufferedHeader;
import org.json.JSONArray;

import android.util.Log;

public class JsonConection {
	
	public  String url="";
	
	private HttpGet peticionGet;
	
	private HttpClient cliente = new DefaultHttpClient();//realizara la peticion al servidor mediante una url
	
	public void JsonConection()
	{
		
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	public void conectar()//Se pasa un arreglo con los argumentos necesarios en la peticion
	{
		
	}
	public JSONArray JsonInsert(ArrayList<Campo> parametros)throws Exception
	{
		
		try
		{
			HttpGet peticionGet = new HttpGet(this.agregarParametros(parametros));//Se le pasa la url el meodo agregarparametros la devuelve como un string
			HttpResponse respuesta = cliente.execute(peticionGet);//se ejecuta
			StatusLine estado = respuesta.getStatusLine();//Se obtiene el estado de la peticion. 
			
			int codigoEstado = estado.getStatusCode();
			if(codigoEstado == 200) // Si la peticion fue exitosa
			{
				return new JSONArray(fetchResponse(respuesta));//Se extraen los datos
			}
			
		}
		catch(ClientProtocolException e)
		{
			
		}
		
		return null;
		
	}
	
	public void JsonQuery(ArrayList<Campo> parametros)
	{
		HttpGet peticionGet = new HttpGet(this.agregarParametros(parametros));
		
	}
	
	public String agregarParametros(ArrayList<Campo> parametros)
	{
		int contador=1;
		String signo="?";
		String url = this.url;
		for(Campo campo : parametros)//Se construye una url con todos los parametros que se pasaron
		{
			if(contador!=1)
				signo="&";
			else
				signo="?";
			contador++;
				
				url+=signo + campo.getCampo() + "=" + campo.getValor();
				
		}
		
		return url;
		
	}
	
	public String fetchResponse(HttpResponse respuesta)throws Exception
	{
		/*
		 * ---Metodo el cual se encarga de obtener todos los datos que se obtuvieron previamente a una peticion Json
		 */
		StringBuilder builder = new StringBuilder();
		try
		{
			HttpEntity entidad = respuesta.getEntity();
			InputStream contenido = entidad.getContent();
			BufferedReader lector = new BufferedReader(new InputStreamReader(contenido));
			
			String line;
			while((line = lector.readLine()) !=null)
			{
				builder.append(line);
			}
		}
		catch(ClientProtocolException e)
		{
			Log.d("fetchResponse", "error" + e);
		}
		return builder.toString();
	}
	
	
}
