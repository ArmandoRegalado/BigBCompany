package nef.naitineityfor.bigbcompany.dbobjects;

public class Noticia {
	
	private long id_noticia;
	private String titulo_not;
	private String contenido_not;
	private String imagen_not;
	private String fech_pub;
	private Integer cant_likes;
	private String fech_lec;
	private String fech_like;
	
	public Noticia(long id_noticia, String titulo_not, String contenido_not,
			String imagen_not, String fech_pub, Integer cant_likes,
			String fech_lec, String fech_like) {
		this.id_noticia = id_noticia;
		this.titulo_not = titulo_not;
		this.contenido_not = contenido_not;
		this.imagen_not = imagen_not;
		this.fech_pub = fech_pub;
		this.cant_likes = cant_likes;
		this.fech_lec = fech_lec;
		this.fech_like = fech_like;
	}
	
	public long get_id() {
		return id_noticia;
	}
	public void set_id(long id_noticia) {
		this.id_noticia = id_noticia;
	}
	
	public String get_titulo_not() {
		return titulo_not;
	}
	public void set_titulo_not(String titulo_not) {
		this.titulo_not = titulo_not;
	}
	
	public String get_contenido_not() {
		return contenido_not;
	}
	public void set_contenido_not(String contenido_not) {
		this.contenido_not = contenido_not;
	}
	
	public String get_imagen_not() {
		return imagen_not;
	}
	public void set_imagen_not(String imagen_not) {
		this.imagen_not = imagen_not;
	}
	
	public String get_fech_pub() {
		return fech_pub;
	}
	public void set_fech_pub(String fech_pub) {
		this.fech_pub = fech_pub;
	}
	public Integer get_cant_likes() {
		return cant_likes;
	}
	public void set_cant_likes(Integer cant_likes) {
		this.cant_likes = cant_likes;
	}
	public String get_fech_lec() {
		return fech_lec;
	}
	public void set_fech_lec(String fech_lec) {
		this.fech_lec = fech_lec;
	}
	public String get_fech_like() {
		return fech_like;
	}
	public void set_fech_like(String fech_like) {
		this.fech_like = fech_like;
	}

}
