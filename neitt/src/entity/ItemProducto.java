package entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class ItemProducto implements Parcelable{

	private String titulo;
	private String subtitulo;
	private int image;
	public ItemProducto()
	{
		this.image=0;
	}
	public ItemProducto(String titulo,String subtitulo)
	{
		setTitulo(subtitulo);
		setSubTitulo(subtitulo);
	}public ItemProducto(String titulo,String subtitulo,int imagen)
	{
		setTitulo(subtitulo);
		setSubTitulo(subtitulo);
		setImage(imagen);
	}
	public String getTitulo()
	{
		return titulo;
	}
	public String getSubTitulo()
	{
		return subtitulo;
	}
	public int getImage()
	{
		return image;
	}
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	public void setSubTitulo(String subtitulo)
	{
		this.subtitulo = subtitulo;
	}
	public void setImage(int image)
	{
		this.image = image;
	}
	
	
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getTitulo());
		dest.writeString(this.getSubTitulo());
		
	}
	
	

}
