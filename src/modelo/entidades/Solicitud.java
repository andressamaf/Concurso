package modelo.entidades;

import java.io.Serializable;

public class Solicitud implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sol_ci;
	private String sol_apellidos;
	private String sol_nombres;
	private Integer sol_codprov;
	private Integer sol_codciu;
	private String sol_sexo;
	private String sol_fechaNac;
	private Integer sol_nummiem;
	private Boolean sol_disc;
	private String sol_telefono;
	private String sol_fecha;
	private String sol_estado;
	private String sol_usr;
	public String getSol_ci() {
		return sol_ci;
	}
	public void setSol_ci(String sol_ci) {
		this.sol_ci = sol_ci;
	}
	public String getSol_apellidos() {
		return sol_apellidos;
	}
	public void setSol_apellidos(String sol_apellidos) {
		this.sol_apellidos = sol_apellidos;
	}
	public String getSol_nombres() {
		return sol_nombres;
	}
	public void setSol_nombres(String sol_nombres) {
		this.sol_nombres = sol_nombres;
	}
	public Integer getSol_codprov() {
		return sol_codprov;
	}
	public void setSol_codprov(Integer sol_codprov) {
		this.sol_codprov = sol_codprov;
	}
	public Integer getSol_codciu() {
		return sol_codciu;
	}
	public void setSol_codciu(Integer sol_codciu) {
		this.sol_codciu = sol_codciu;
	}
	public String getSol_sexo() {
		return sol_sexo;
	}
	public void setSol_sexo(String sol_sexo) {
		this.sol_sexo = sol_sexo;
	}
	public Integer getSol_nummiem() {
		return sol_nummiem;
	}
	public void setSol_nummiem(Integer sol_nummiem) {
		this.sol_nummiem = sol_nummiem;
	}
	public Boolean getSol_disc() {
		return sol_disc;
	}
	public void setSol_disc(Boolean sol_disc) {
		this.sol_disc = sol_disc;
	}
	public String getSol_telefono() {
		return sol_telefono;
	}
	public void setSol_telefono(String sol_telefono) {
		this.sol_telefono = sol_telefono;
	}
	public String getSol_estado() {
		return sol_estado;
	}
	public void setSol_estado(String sol_estado) {
		this.sol_estado = sol_estado;
	}
	public String getSol_fechaNac() {
		return sol_fechaNac;
	}
	public void setSol_fechaNac(String sol_fechaNac) {
		this.sol_fechaNac = sol_fechaNac;
	}
	public String getSol_fecha() {
		return sol_fecha;
	}
	public void setSol_fecha(String sol_fecha) {
		this.sol_fecha = sol_fecha;
	}
	public String getSol_usr() {
		return sol_usr;
	}
	public void setSol_usr(String sol_usr) {
		this.sol_usr = sol_usr;
	}
	
}
