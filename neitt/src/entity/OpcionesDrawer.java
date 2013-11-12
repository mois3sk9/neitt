package entity;

import android.graphics.drawable.Drawable;

public class OpcionesDrawer {
	
	
	private String titulo;
	private String subtitulo;
	
	private Drawable foto;
	
	public OpcionesDrawer()
	{
		
	}
	public OpcionesDrawer(String titulo,String subtitulo,Drawable foto)
	{
		setTitulo(titulo);
		setSubtitulo(subtitulo);
		setFoto(foto);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public Drawable getFoto() {
		return foto;
	}

	public void setFoto(Drawable foto) {
		this.foto = foto;
	}
	
	
	

}
