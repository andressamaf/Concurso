package modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import modelo.entidades.Provincia;
import utilidades.Constantes;
@Path("provincia")
@Produces("application/json")
public class ServicioProvincia {
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
	@GET
	@Path("listar")
	@Consumes("application/json")
	public List<Provincia> listarProvincias() {
		List<Provincia> lp = new ArrayList<Provincia>();
		try {
			Connection con=conexion();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM PROVINCIA");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Provincia p = new Provincia();
				p.setProvinciaId(rs.getInt("provincia_id"));
				p.setProvinciaNombre(rs.getString("provincia_nombre"));
				lp.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error al listar");
		}
		return lp;
	}
}
