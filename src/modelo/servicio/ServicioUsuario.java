package modelo.servicio;

import utilidades.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Solicitud;
import modelo.entidades.Usuario;

public class ServicioUsuario {

	public static void main(String[] args) {
		ServicioUsuario su = new ServicioUsuario();
		Usuario u = new Usuario();
		u.setUsr_ci("1727299420");
		u.setUsr_clave("1727299420");
		if (su.permitirIngreso(u)) {
			System.out.println("si");
		} else {
			System.out.println("no");
		}

	}

	public boolean permitirIngreso(Usuario usuario) {
		try {
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,
					Constantes.USERNAME, Constantes.PASSWORD);

			PreparedStatement st = connection
					.prepareStatement("select * from Usuario where usr_ci = ? and usr_clave = ?");
			st.setString(1, usuario.getUsr_ci());
			st.setString(2, usuario.getUsr_clave());
			st.execute();
			ResultSet rs = st.getResultSet();

			if (rs.next()) {
				connection.close();
				return true;
			} else {
				connection.close();
				return false;
			}

		} catch (Exception e) {
			System.out.println("Error en permitirIngreso()!");
		}
		return false;
	}
	public void crearUsuario(Usuario u) {
		try {
			Class.forName(Constantes.DRIVER);
			Connection con = DriverManager.getConnection(Constantes.URL,
					Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = con
					.prepareStatement("INSERT INTO Usuario (usr_ci,usr_clave,"
							+ "usr_nombre,usr_correo,usr_telefono,usr_rol) values(?,?,?,?,?,?)");
			st.setString(1, u.getUsr_ci());
			st.setString(2, u.getUsr_clave());
			st.setString(3, u.getUsr_nombre());
			st.setString(4, u.getUsr_correo());
			st.setString(5, u.getUsr_telefono());
			st.setString(6, u.getUsr_rol());
			st.execute();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarUsuario(Usuario u) {
		try {
			Class.forName(Constantes.DRIVER);
			Connection con = DriverManager.getConnection(Constantes.URL,
					Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = con
					.prepareStatement("UPDATE Usuario SET usr_nombre=?, usr_clave=?, "
							+ "usr_rol=?, usr_correo=?, usr_telefono=? where usr_ci=?");
			st.setString(1, u.getUsr_nombre());
			st.setString(2, u.getUsr_clave());
			st.setString(3, u.getUsr_rol());
			st.setString(4, u.getUsr_correo());
			st.setString(5, u.getUsr_telefono());
			st.setString(6, u.getUsr_ci());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario buscarUsuario(String ci) {
		Usuario u = new Usuario();
		try {
			Class.forName(Constantes.DRIVER);
			Connection con = DriverManager.getConnection(Constantes.URL,
					Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM Usuario where usr_ci=?");
			st.setString(1, ci);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				u.setUsr_ci(rs.getString("usr_ci"));
				u.setUsr_clave(rs.getString("usr_clave"));
				u.setUsr_correo(rs.getString("usr_correo"));
				u.setUsr_rol(rs.getString("usr_rol"));
				u.setUsr_telefono(rs.getString("usr_telefono"));
				u.setUsr_nombre(rs.getString("usr_nombre"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al buscar");
		}
		return u;
	}

	public List<Usuario> listarUsuarios(String nombre) {
		List<Usuario> lu = new ArrayList<Usuario>();
		try {
			Class.forName(Constantes.DRIVER);
			Connection con = DriverManager.getConnection(Constantes.URL,
					Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM Usuario where usr_nombre like ?");
			st.setString(1, nombre.equals("") ? "" : "%" + nombre + "%");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setUsr_ci(rs.getString("usr_ci"));
				u.setUsr_clave(rs.getString("usr_clave"));
				u.setUsr_correo(rs.getString("usr_correo"));
				u.setUsr_rol(rs.getString("usr_rol"));
				u.setUsr_telefono(rs.getString("usr_telefono"));
				u.setUsr_nombre(rs.getString("usr_nombre"));
				lu.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lu;
	}

	public void eliminarUsuario(String ci) {
		try {
			Class.forName(Constantes.DRIVER);
			Connection con = DriverManager.getConnection(Constantes.URL,
					Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = con.prepareStatement("DELETE from Usuario where usr_ci=?");
			st.setString(1, ci);
			st.execute();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Boolean existe(String ci){
		try{
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);			
			PreparedStatement st = connection.prepareStatement("select * from Usuario where usr_ci = ?");
			st.setString(1, ci);			
			st.execute();
			ResultSet rs = st.getResultSet();			
			
			if (rs.next()) {
				connection.close();
				return true;
			}
			else {
				connection.close();
				return false;
			}
		}
		catch (Exception e){
			return false;
		}
		
	}
}
