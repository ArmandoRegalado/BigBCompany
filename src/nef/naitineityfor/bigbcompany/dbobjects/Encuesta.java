package nef.naitineityfor.bigbcompany.dbobjects;

public class Encuesta {

	private long id_encuesta;
	private long id_pregunta;
	private long id_respuesta;
	private String titulo_enc;
	private String descripcion_enc;
	private String fech_pub;
	private String fech_cont;
	private String text_pregunta;
	private Integer tipo_pregunta;
	private Integer tipo_resp;
	private String resp_texto;
	private Integer resp_numero;
	private long resp_elegida;

	public Encuesta(long id_encuesta, long id_pregunta, long id_respuesta,
			String titulo_enc, String descripcion_enc, String fech_pub,
			String fech_cont, String text_pregunta, Integer tipo_pregunta,
			Integer tipo_resp, String resp_texto, Integer resp_numero,
			long resp_elegida) {
		this.id_encuesta = id_encuesta;
		this.id_pregunta = id_pregunta;
		this.id_respuesta = id_respuesta;
		this.titulo_enc = titulo_enc;
		this.descripcion_enc = descripcion_enc;
		this.fech_pub = fech_pub;
		this.fech_cont = fech_cont;
		this.text_pregunta = text_pregunta;
		this.tipo_pregunta = tipo_pregunta;
		this.tipo_resp = tipo_resp;
		this.resp_texto = resp_texto;
		this.resp_numero = resp_numero;
		this.resp_elegida = resp_elegida;
	}
	
	public long get_id_encuesta() {
		return id_encuesta;
	}
	public void set_id_encuesta(long id_encuesta) {
		this.id_encuesta = id_encuesta;
	}
	public long get_id_pregunta() {
		return id_pregunta;
	}
	public void set_id_pregunta(long id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	public long get_id_respuesta() {
		return id_respuesta;
	}
	public void set_id_respuesta(long id_respuesta) {
		this.id_respuesta = id_respuesta;
	}
	public String get_titulo_enc() {
		return titulo_enc;
	}
	public void set_titulo_enc(String titulo_enc) {
		this.titulo_enc = titulo_enc;
	}
	public String get_descripcion_enc() {
		return descripcion_enc;
	}
	public void set_descripcion_enc(String descripcion_enc) {
		this.descripcion_enc = descripcion_enc;
	}
	public String get_fech_pub() {
		return fech_pub;
	}
	public void set_fech_pub(String fech_pub) {
		this.fech_pub = fech_pub;
	}
	public String get_fech_cont() {
		return fech_cont;
	}
	public void set_fech_cont(String fech_cont) {
		this.fech_cont = fech_cont;
	}
	public String get_text_pregunta() {
		return text_pregunta;
	}
	public void set_text_pregunta(String text_pregunta) {
		this.text_pregunta = text_pregunta;
	}
	public Integer get_tipo_pregunta() {
		return tipo_pregunta;
	}
	public void set_tipo_pregunta(Integer tipo_pregunta) {
		this.tipo_pregunta = tipo_pregunta;
	}
	public Integer get_tipo_resp() {
		return tipo_resp;
	}
	public void set_tipo_resp(Integer tipo_resp) {
		this.tipo_resp = tipo_resp;
	}
	public String get_resp_texto() {
		return resp_texto;
	}
	public void set_resp_texto(String resp_texto) {
		this.resp_texto = resp_texto;
	}
	public Integer get_resp_numero() {
		return resp_numero;
	}
	public void set_resp_numero(Integer resp_numero) {
		this.resp_numero = resp_numero;
	}
	public long get_resp_elegida() {
		return resp_elegida;
	}
	public void set_resp_elegida(long resp_elegida) {
		this.resp_elegida = resp_elegida;
	}
}
