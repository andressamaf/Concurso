package modelo.entidades;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String usrCi;
	private String usrClave;
	private String usrNombre;
	private String usrTelefono;
	private String usrCorreo;
	private String usrRol;
	private byte estadousr;
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public String getUsrCi() {
		return usrCi;
	}
	public void setUsrCi(String usrCi) {
		this.usrCi = usrCi;
	}
	public String getUsrClave() {
		return usrClave;
	}
	public void setUsrClave(String usrClave) {
		this.usrClave = usrClave;
	}
	public String getUsrNombre() {
		return usrNombre;
	}
	public void setUsrNombre(String usrNombre) {
		this.usrNombre = usrNombre;
	}
	public String getUsrTelefono() {
		return usrTelefono;
	}
	public void setUsrTelefono(String usrTelefono) {
		this.usrTelefono = usrTelefono;
	}
	public String getUsrCorreo() {
		return usrCorreo;
	}
	public void setUsrCorreo(String usrCorreo) {
		this.usrCorreo = usrCorreo;
	}
	public String getUsrRol() {
		return usrRol;
	}
	public void setUsrRol(String usrRol) {
		this.usrRol = usrRol;
	}
	public byte getEstadousr() {
		return estadousr;
	}
	public void setEstadousr(byte estadousr) {
		this.estadousr = estadousr;
	}
	
}
