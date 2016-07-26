package modelo.servicio;

import utilidades.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Administrador;

public class ServicioAdministrador {
	
	public static void main(String[] args) {
		ServicioAdministrador su = new ServicioAdministrador();
		Administrador u = new Administrador();
		u.setUsr_ci("1727299420");
		u.setUsr_clave("1727299420");
		if (su.permitirIngreso(u)){
			System.out.println("si");
		}
		else {
			System.out.println("no");
		}

	}
	public boolean permitirIngreso(Administrador administrador){
		try {
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			
			PreparedStatement st = connection.prepareStatement("select * from ADMINISTRADOR where ADMIN_CI = ? and ADMIN_CLAVE = ?");
			st.setString(1, administrador.getUsr_ci());
			st.setString(2, administrador.getUsr_clave());
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
			
		} catch (Exception e) {
			System.out.println("Error en permitirIngreso()!");
		}
		return false;
	}
	public List<Administrador> listarUsuarios (String ci, String nombre){
		List<Administrador> lu = new ArrayList<Administrador>();
		try{
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = connection.prepareStatement("select * from ADMINISTRADOR where ADMIN_CI like ? or ADMIN_CLAVE like ?");
			st.setString(1,ci);
			st.setString(2, nombre);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Administrador u = new Administrador();
				u.setUsr_ci(rs.getString("ADMIN_CI"));
				u.setUsr_clave(rs.getString("ADMIN_CLAVE"));
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return lu;
	}
}
