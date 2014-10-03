package nef.naitineityfor.bigbcompany.dbobjects;

public class Mensaje {

	private long id_mensaje;
	private String email_remitente;
	private String email_destinatario;
	private String cont_mensaje;
	private String enviado;
	private String recibido;

	public Mensaje(long id_mensaje, String email_remitente,
			String email_destinatario, String cont_mensaje, String enviado, String recibido) {
		this.id_mensaje = id_mensaje;
		this.email_remitente = email_remitente;
		this.email_destinatario = email_destinatario;
		this.cont_mensaje = cont_mensaje;
		this.enviado = enviado;
		this.recibido = recibido;
	}
	
	public long get_id_mensaje() {
		return id_mensaje;
	}
	public void set_id_mensaje(long id_mensaje) {
		this.id_mensaje = id_mensaje;
	}
	public String get_email_remitente() {
		return email_remitente;
	}
	public void set_email_remitente(String email_remitente) {
		this.email_remitente = email_remitente;
	}
	public String get_email_destinatario() {
		return email_destinatario;
	}
	public void set_email_destinatario(String email_destinatario) {
		this.email_destinatario = email_destinatario;
	}
	public String get_enviado() {
		return enviado;
	}
	public void set_enviado(String enviado) {
		this.enviado = enviado;
	}
	public String get_recibido() {
		return recibido;
	}
	public void set_recibido(String recibido) {
		this.recibido = recibido;
	}

	public String get_cont_mensaje() {
		return cont_mensaje;
	}

	public void set_cont_mensaje(String cont_mensaje) {
		this.cont_mensaje = cont_mensaje;
	}

}
