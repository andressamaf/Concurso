package modelo.entidades;

public class Ciudad {
	private int ciudad_id;
	private int provincia_id;
	private String ciudad_nombre;
	public Ciudad() {
		// TODO Auto-generated constructor stub
	}
	public int getCiudad_id() {
		return ciudad_id;
	}
	public void setCiudad_id(int ciudad_id) {
		this.ciudad_id = ciudad_id;
	}
	public int getProvincia_id() {
		return provincia_id;
	}
	public void setProvincia_id(int provincia_id) {
		this.provincia_id = provincia_id;
	}
	public String getCiudad_nombre() {
		return ciudad_nombre;
	}
	public void setCiudad_nombre(String ciudad_nombre) {
		this.ciudad_nombre = ciudad_nombre;
	}
	
}
