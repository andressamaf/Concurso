package modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import modelo.entidades.Solicitud;
import utilidades.Constantes;
@Path("solicitud")
@Produces("Application/json")
public class ServicioSolicitud {
	@PUT
	@Path("editar")
	@Consumes("Application/json")
	public void editar(Solicitud solicitud){
		try {
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			
			PreparedStatement st = null;
			
			st= connection.prepareStatement("update SOLICITUD set SOL_ESTADO = ? WHERE SOL_CI = ?");
			st.setString(1, solicitud.getSol_estado());
			st.setString(2, solicitud.getSol_ci());
					
			st.executeUpdate();
			st.close();
			connection.close();
			System.out.println("se ha modificado");
		} catch (Exception e) {
			System.out.println("Error al editar!");
			e.printStackTrace();
		}
	}
	@GET
	@Path("existe")
	@Consumes("Application/json")
	public Boolean existe(Solicitud solicitud){
		try{
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			
			PreparedStatement st = connection.prepareStatement("select * from SOLICITUD where SOL_CI = ?");
			st.setString(1, solicitud.getSol_ci());			
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
	@GET
	@Path("consultaPorFechas")
	@Consumes("Application/json")
	public ArrayList<Solicitud> consultarPorRangoFechasDos(@QueryParam("fechaIni")String fechaInicio, 
			@QueryParam("fechaFin")String fechaFin){
		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		Solicitud solicitud = null;
		
		try{
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = connection.prepareStatement("select * from SOLICITUD where SOL_FECHA >= ? AND SOL_FECHA <= ? AND SOL_ESTADO='S'");
			st.setString(1, fechaInicio);
			st.setString(2, fechaFin);
			st.execute();
			System.out.println("fechas correctas");
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				solicitud = new Solicitud();
				solicitud.setSol_ci(rs.getString("SOL_CI"));
				solicitud.setSol_apellidos(rs.getString("SOL_APELLIDOS"));
				solicitud.setSol_nombres(rs.getString("SOL_NOMBRES"));
				solicitud.setSol_codprov(rs.getInt("SOL_CODPROV"));
				solicitud.setSol_codciu(rs.getInt("SOL_CODCIU"));
				solicitud.setSol_sexo(rs.getString("SOL_SEXO"));
				solicitud.setSol_fechaNac(rs.getString("SOL_FECHANAC"));
				solicitud.setSol_nummiem(rs.getInt("SOL_NUMMIEM"));
				solicitud.setSol_disc(rs.getInt("SOL_DISC") == 1);
				solicitud.setSol_telefono(rs.getString("SOL_TELEFONO"));
				solicitud.setSol_fecha(rs.getString("SOL_FECHA"));
				solicitud.setSol_estado(rs.getString("SOL_ESTADO"));
				solicitud.setSol_usr(rs.getString("SOL_USRCI"));
				solicitudes.add(solicitud);
			}
			
		}
		catch (Exception e){
			System.out.println("error");
		}
		
		System.out.println(solicitudes.size());
		return solicitudes;
	}
	@GET
	@Path("consultaPorFechasReporte")
	@Consumes("Application/json")
	public ArrayList<Solicitud> consultarPorRangoFechas(@QueryParam("fechaIni")String fechaInicio, 
			@QueryParam("fechaFin")String fechaFin){
		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		Solicitud solicitud = null;
		
		try{
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = connection.prepareStatement("select * from SOLICITUD where SOL_FECHA > ? AND SOL_FECHA < ?");
			st.setString(1, fechaInicio);
			st.setString(2, fechaFin);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				solicitud = new Solicitud();
				solicitud.setSol_ci(rs.getString("SOL_CI"));
				solicitud.setSol_apellidos(rs.getString("SOL_APELLIDOS"));
				solicitud.setSol_nombres(rs.getString("SOL_NOMBRES"));
				solicitud.setSol_codprov(rs.getInt("SOL_CODPROV"));
				solicitud.setSol_codciu(rs.getInt("SOL_CODCIU"));
				solicitud.setSol_sexo(rs.getString("SOL_SEXO"));
				solicitud.setSol_fechaNac(rs.getString("SOL_FECHANAC"));
				solicitud.setSol_nummiem(rs.getInt("SOL_NUMMIEM"));
				solicitud.setSol_disc(rs.getInt("SOL_DISC") == 1);
				solicitud.setSol_telefono(rs.getString("SOL_TELEFONO"));
				solicitud.setSol_fecha(rs.getString("SOL_FECHA"));
				solicitud.setSol_estado(rs.getString("SOL_ESTADO"));
				solicitud.setSol_usr(rs.getString("SOL_USRCI"));
				solicitudes.add(solicitud);
			}
			
		}
		catch (Exception e){
			
		}
		
		System.out.println(solicitudes.size());
		return solicitudes;
	}
	@GET
	@Path("listaSolicitud")
	@Consumes("Application/json")
	public ArrayList<Solicitud> consultarPorCIyApellidos(@QueryParam("ci")String ci, @QueryParam("apellido")String apellidos){
		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		Solicitud solicitud = null;
		
		try{
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = connection.prepareStatement("select * from SOLICITUD where SOL_CI LIKE ? OR SOL_APELLIDOS LIKE ?");
			st.setString(1, ci.equals("") ? "" : "%"+ci+"%");
			st.setString(2, apellidos.equals("") ? "" : "%"+apellidos+"%");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				solicitud = new Solicitud();
				solicitud.setSol_ci(rs.getString("SOL_CI"));
				solicitud.setSol_apellidos(rs.getString("SOL_APELLIDOS"));
				solicitud.setSol_nombres(rs.getString("SOL_NOMBRES"));
				solicitud.setSol_codprov(rs.getInt("SOL_CODPROV"));
				solicitud.setSol_codciu(rs.getInt("SOL_CODCIU"));
				solicitud.setSol_sexo(rs.getString("SOL_SEXO"));
				solicitud.setSol_fechaNac(rs.getString("SOL_FECHANAC"));
				solicitud.setSol_nummiem(rs.getInt("SOL_NUMMIEM"));
				solicitud.setSol_disc(rs.getInt("SOL_DISC") == 1);
				solicitud.setSol_telefono(rs.getString("SOL_TELEFONO"));
				solicitud.setSol_fecha(rs.getString("SOL_FECHA"));
				solicitud.setSol_estado(rs.getString("SOL_ESTADO"));
				solicitud.setSol_usr(rs.getString("SOL_USRCI"));
				solicitudes.add(solicitud);
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
		return solicitudes;
	}
	@DELETE
	@Path("eliminar")
	@Consumes("Application/json")
	public void eliminar(Solicitud solicitud){
		try {
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = connection.prepareStatement("delete from SOLICITUD where SOL_CI = ?");
			st.setString(1, solicitud.getSol_ci());
			st.executeUpdate();
			
			st.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Error al eliminar!");
		}
	}
	@POST
	@Path("guardar")
	@Consumes("Application/json")
	public void guardar(Solicitud solicitud){
		try {
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			
			PreparedStatement st = null;
			
			st= connection.prepareStatement("insert into SOLICITUD (SOL_CI, SOL_APELLIDOS, SOL_NOMBRES, "
					+ "SOL_CODPROV, SOL_CODCIU, SOL_SEXO, SOL_FECHANAC, SOL_NUMMIEM, SOL_DISC, SOL_TELEFONO, "
					+ "SOL_FECHA, SOL_ESTADO) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?)");
			st.setString(1, solicitud.getSol_ci());
			st.setString(2, solicitud.getSol_apellidos());
			st.setString(3, solicitud.getSol_nombres());
			st.setInt(4, solicitud.getSol_codprov());
			st.setInt(5, solicitud.getSol_codciu());
			st.setString(6, solicitud.getSol_sexo());
			st.setString(7, solicitud.getSol_fechaNac());
			st.setInt(8, solicitud.getSol_nummiem());
			st.setInt(9, solicitud.getSol_disc() ? 1 : 0);
			st.setString(10, solicitud.getSol_telefono());
			st.setString(11, solicitud.getSol_fecha());
			st.setString(12, solicitud.getSol_estado());
			//st.setString(13, solicitud.getSol_usr());
			System.out.println("se ha guardado la solicitud");
			st.executeUpdate();
			st.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Error al guardar!");
			e.printStackTrace();
		}
	}
	
}
