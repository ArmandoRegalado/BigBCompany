package nef.naitineityfor.bigbcompany.dbobjects;

public class Contacto {
	private long id_contacto;
	private String nombre_contacto;
	private String email_contacto;
	private String img_contacto;
	  
	public Contacto(long id_contacto, String nombre_contacto, String email_contacto, String img_contacto) {
		this.set_id(id_contacto);
		this.set_nombre(nombre_contacto);
		this.set_email(email_contacto);
		this.set_img(img_contacto);
	}

	public long get_id() {
		return id_contacto;
	}

	public void set_id(long id_contacto) {
		this.id_contacto = id_contacto;
	}

	public String get_nombre() {
		return nombre_contacto;
	}

	public void set_nombre(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}	
	
	public String get_email() {
		return email_contacto;
	}

	public void set_email(String email_contacto) {
		this.email_contacto = email_contacto;
	}

	public String get_img() {
		return img_contacto;
	}

	public void set_img(String img_contacto) {
		this.img_contacto = img_contacto;
	}
	  
}
