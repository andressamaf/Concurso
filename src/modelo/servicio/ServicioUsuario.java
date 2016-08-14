package modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import modelo.entidades.*;
import utilidades.Constantes;
@Path("usuario")
@Produces("application/json")
public class ServicioUsuario {
	public Connection conexion (){
		try{
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,
					Constantes.USERNAME, Constantes.PASSWORD);
			System.out.println("conexion exitosa");
			return connection;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("no se pudo conectar a la base");
			return null;
		}
	}
	@POST
	@Path("loggin")
	@Consumes("application/json")
	public boolean permitirIngreso(Usuario usuario) {
		try {
			Connection connection=conexion();
			PreparedStatement st = connection
					.prepareStatement("select * from Usuario where usr_ci = ? and usr_clave = ?");
			st.setString(1, usuario.getUsrCi());
			st.setString(2, usuario.getUsrClave());
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
	@POST
	@Path("crear")
	@Consumes("application/json")
	public void crearUsuario(Usuario u) {
		try {
			Connection con=conexion();
			PreparedStatement st = con
					.prepareStatement("INSERT INTO Usuario (usr_ci,usr_clave,"
							+ "usr_nombre,usr_correo,usr_telefono,usr_rol,usr_estadol) values(?,?,?,?,?,?,0)");
			st.setString(1, u.getUsrCi());
			st.setString(2, u.getUsrClave());
			st.setString(3, u.getUsrNombre());
			st.setString(4, u.getUsrCorreo());
			st.setString(5, u.getUsrTelefono());
			st.setString(6, u.getUsrRol());
			
			st.execute();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@PUT
	@Path("modificar")
	@Consumes("application/json")
	public void modificarUsuario(Usuario u) {
		try {
			Connection con=conexion();
			PreparedStatement st = con
					.prepareStatement("UPDATE Usuario SET usr_nombre=?, usr_clave=?, "
							+ "usr_rol=?, usr_correo=?, usr_telefono=? where usr_ci=?");
			st.setString(1, u.getUsrNombre());
			st.setString(2, u.getUsrClave());
			st.setString(3, u.getUsrRol());
			st.setString(4, u.getUsrCorreo());
			st.setString(5, u.getUsrTelefono());
			st.setString(6, u.getUsrCi());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GET
	@Path("buscar")
	@Consumes("application/json")
	public Usuario buscarUsuario(@QueryParam("ci")String ci) {
		Usuario u = new Usuario();
		try {
			Connection con=conexion();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM Usuario where usr_ci=?");
			st.setString(1, ci);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				u.setUsrCi(rs.getString("usr_ci"));
				u.setUsrClave(rs.getString("usr_clave"));
				u.setUsrCorreo(rs.getString("usr_correo"));
				u.setUsrRol(rs.getString("usr_rol"));
				u.setUsrTelefono(rs.getString("usr_telefono"));
				u.setUsrNombre(rs.getString("usr_nombre"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al buscar");
		}
		return u;
	}
	@GET
	@Path("listar")
	@Consumes("application/json")
	public List<Usuario> listarUsuarios(@QueryParam("nombre")String nombre) {
		List<Usuario> lu = new ArrayList<Usuario>();
		try {
			Connection con=conexion();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM Usuario where usr_nombre like ?");
			st.setString(1, nombre.equals("") ? "" : "%" + nombre + "%");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setUsrCi(rs.getString("usr_ci"));
				u.setUsrClave(rs.getString("usr_clave"));
				u.setUsrCorreo(rs.getString("usr_correo"));
				u.setUsrRol(rs.getString("usr_rol"));
				u.setUsrTelefono(rs.getString("usr_telefono"));
				u.setUsrNombre(rs.getString("usr_nombre"));
				lu.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error al listar");
		}
		return lu;
	}
	@DELETE
	@Path("eliminar")
	@Consumes("application/json")
	public void eliminarUsuario(@QueryParam("ci")String ci) {
		try {
			Connection con=conexion();
			PreparedStatement st = con.prepareStatement("DELETE from Usuario where usr_ci=?");
			st.setString(1, ci);
			st.execute();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GET
	@Path("existe")
	@Consumes("application/json")
	public Boolean existe(@QueryParam("ci")String ci){
		try{
			Connection connection=conexion();			
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
