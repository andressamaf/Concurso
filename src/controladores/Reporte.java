package controladores;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Solicitud;
import modelo.servicio.ServicioSolicitud;
import utilidades.Constantes;

/**
 * Servlet implementation class Reporte
 */
@WebServlet("/Reporte")
public class Reporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reporte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher("/vistas/reportesSolicitud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServicioSolicitud ss = new ServicioSolicitud();
		
		
		try {
			Date fechaInicio = new SimpleDateFormat(Constantes.FORMATOFECHA).parse(request.getParameter("fechaInicio"));
			Date fechaFin = new SimpleDateFormat(Constantes.FORMATOFECHA).parse(request.getParameter("fechaFin"));
			System.out.println(ss.consultarPorRangoFechas(fechaInicio, fechaFin).size());
			FileWriter fichero = null;
	        PrintWriter out = null;
	        try
	        {
	            fichero = new FileWriter("C:\\Users\\aasf9_000\\Desktop\\reporte.txt",true);
	            out = new PrintWriter(fichero);
	            @SuppressWarnings("unchecked")
				ArrayList<Solicitud> solicitudes = ss.consultarPorRangoFechas(fechaInicio, fechaFin);
	            if(solicitudes != null){
	            	out.println("PROVINCIA" +"\t" + "CIUDAD" +"\t" + "CEDULA" +"\t\t" + "APELLIDOS" +"\t\t" + "NOMBRES" +"\t" + "FECHA" +"\t" + "TELEFONO"  +"\t" + "ESTADO");
	            	for (Solicitud s : solicitudes)
	    			{
	    				out.println(s.getSol_codprov() +"\t" + s.getSol_codciu() +"\t" + s.getSol_ci() +"\t" + s.getSol_apellidos() +"\t" + s.getSol_nombres() +"\t" + s.getSol_fecha() +"\t" + s.getSol_telefono()  +"\t" + s.getSol_estado());	    				
	    			}
	    		}
	            else{
	            	out.println("No se encuentran registros relacionados. Intente con otro criterio.");
	            }
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	        this.doGet(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
