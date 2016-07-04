package modelo.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.entidades.Solicitud;
import utilidades.*;

public class ServicioSolicitud {
	
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
			
		} catch (Exception e) {
			System.out.println("Error al editar!");
			e.printStackTrace();
		}
	}
	
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
	
	
	public ArrayList<Solicitud> consultarPorRangoFechasDos(Date fechaInicio, Date fechaFin){
		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		Solicitud solicitud = null;
		
		try{
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = connection.prepareStatement("select * from SOLICITUD where SOL_FECHA > ? AND SOL_FECHA < ? AND SOL_ESTADO='S'");
			st.setString(1, new SimpleDateFormat(Constantes.FORMATOFECHA).format(fechaInicio));
			st.setString(2, new SimpleDateFormat(Constantes.FORMATOFECHA).format(fechaFin));
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
				solicitud.setSol_fechaNac(new SimpleDateFormat(Constantes.FORMATOFECHA).parse(rs.getString("SOL_FECHANAC")));
				solicitud.setSol_nummiem(rs.getInt("SOL_NUMMIEM"));
				solicitud.setSol_disc(rs.getInt("SOL_DISC") == 1);
				solicitud.setSol_telefono(rs.getString("SOL_TELEFONO"));
				solicitud.setSol_fecha(new SimpleDateFormat(Constantes.FORMATOFECHA).parse(rs.getString("SOL_FECHA")));
				solicitud.setSol_estado(rs.getString("SOL_ESTADO"));
				solicitudes.add(solicitud);
			}
			
		}
		catch (Exception e){
			
		}
		
		
		return solicitudes;
	}
	
	public ArrayList<Solicitud> consultarPorRangoFechas(Date fechaInicio, Date fechaFin){
		ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		Solicitud solicitud = null;
		
		try{
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			PreparedStatement st = connection.prepareStatement("select * from SOLICITUD where SOL_FECHA > ? AND SOL_FECHA < ?");
			st.setString(1, new SimpleDateFormat(Constantes.FORMATOFECHA).format(fechaInicio));
			st.setString(2, new SimpleDateFormat(Constantes.FORMATOFECHA).format(fechaFin));
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
				solicitud.setSol_fechaNac(new SimpleDateFormat(Constantes.FORMATOFECHA).parse(rs.getString("SOL_FECHANAC")));
				solicitud.setSol_nummiem(rs.getInt("SOL_NUMMIEM"));
				solicitud.setSol_disc(rs.getInt("SOL_DISC") == 1);
				solicitud.setSol_telefono(rs.getString("SOL_TELEFONO"));
				solicitud.setSol_fecha(new SimpleDateFormat(Constantes.FORMATOFECHA).parse(rs.getString("SOL_FECHA")));
				solicitud.setSol_estado(rs.getString("SOL_ESTADO"));
				solicitudes.add(solicitud);
			}
			
		}
		catch (Exception e){
			
		}
		
		
		return solicitudes;
	}
	
	public ArrayList<Solicitud> consultarPorCIyApellidos(String ci, String apellidos){
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
				solicitud.setSol_fechaNac(new SimpleDateFormat(Constantes.FORMATOFECHA).parse(rs.getString("SOL_FECHANAC")));
				solicitud.setSol_nummiem(rs.getInt("SOL_NUMMIEM"));
				solicitud.setSol_disc(rs.getInt("SOL_DISC") == 1);
				solicitud.setSol_telefono(rs.getString("SOL_TELEFONO"));
				solicitud.setSol_fecha(new SimpleDateFormat(Constantes.FORMATOFECHA).parse(rs.getString("SOL_FECHA")));
				solicitud.setSol_estado(rs.getString("SOL_ESTADO"));
				solicitudes.add(solicitud);
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
		return solicitudes;
	}
	
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
	
	public void guardar(Solicitud solicitud){
		try {
			Class.forName(Constantes.DRIVER);
			Connection connection = DriverManager.getConnection(Constantes.URL,Constantes.USERNAME, Constantes.PASSWORD);
			
			PreparedStatement st = null;
			
			st= connection.prepareStatement("insert into SOLICITUD (SOL_CI, SOL_APELLIDOS, SOL_NOMBRES, SOL_CODPROV, SOL_CODCIU, SOL_SEXO, SOL_FECHANAC, SOL_NUMMIEM, SOL_DISC, SOL_TELEFONO, SOL_FECHA, SOL_ESTADO) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?)");
			st.setString(1, solicitud.getSol_ci());
			st.setString(2, solicitud.getSol_apellidos());
			st.setString(3, solicitud.getSol_nombres());
			st.setInt(4, solicitud.getSol_codprov());
			st.setInt(5, solicitud.getSol_codciu());
			st.setString(6, solicitud.getSol_sexo());
			st.setString(7, new SimpleDateFormat(Constantes.FORMATOFECHA).format(solicitud.getSol_fechaNac()));
			st.setInt(8, solicitud.getSol_nummiem());
			st.setInt(9, solicitud.getSol_disc() ? 1 : 0);
			st.setString(10, solicitud.getSol_telefono());
			st.setString(11, new SimpleDateFormat(Constantes.FORMATOFECHA).format(solicitud.getSol_fecha()));
			st.setString(12, solicitud.getSol_estado());
					
			st.executeUpdate();
			st.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Error al guardar!");
			e.printStackTrace();
		}
	}
	
}
