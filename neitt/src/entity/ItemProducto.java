package entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class ItemProducto implements Parcelable{

	private String titulo;
	private String subtitulo;
	private ImageView image;
	
	
	public ItemProducto()
	{
		
	}
	public ItemProducto(String titulo,String subtitulo)
	{
		setTitulo(subtitulo);
		setSubTitulo(subtitulo);
	}
	public String getTitulo()
	{
		return titulo;
	}
	public String getSubTitulo()
	{
		return subtitulo;
	}
	public ImageView getImage()
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
	public void setImage(ImageView image)
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
