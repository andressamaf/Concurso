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
import javax.ws.rs.QueryParam;

import modelo.entidades.Ciudad;
import utilidades.Constantes;
@Path("ciudad")
@Produces("application/json")
public class ServicioCiudad {
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
	public List<Ciudad> listarCiudades(@QueryParam("id")int id) {
		List<Ciudad> lc = new ArrayList<Ciudad>();
		try {
			Connection con=conexion();
			PreparedStatement st = con.prepareStatement("SELECT * FROM CIUDAD where provincia_id = ?");
			st.setInt(1, id);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				Ciudad c = new Ciudad();
				c.setCiudad_id(rs.getInt("ciudad_id"));
				c.setProvincia_id(rs.getInt("provincia_id"));
				c.setCiudad_nombre(rs.getString("ciudad_nombre"));
				lc.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error al listar");
		}
		return lc;
	}
}
