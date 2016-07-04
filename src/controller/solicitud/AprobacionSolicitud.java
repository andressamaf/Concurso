package controller.solicitud;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Solicitud;
import modelo.servicio.ServicioSolicitud;
import utilidades.Constantes;

/**
 * Servlet implementation class AprobacionSolicitud
 */
@WebServlet("/AprobacionSolicitud")
public class AprobacionSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AprobacionSolicitud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean redireccion = false;
		try {
			redireccion = (boolean) request.getSession().getAttribute("usuarioActivo");

			if (redireccion == true) {
				getServletConfig().getServletContext().getRequestDispatcher("/vistas/aprobacionSolicitud.jsp")
						.forward(request, response);
			} 
		} catch (Exception e) {

		}

		if (redireccion == false) {
			getServletConfig().getServletContext().getRequestDispatcher("/Login").forward(request, response);
		} else {

			String fechaInicio = request.getParameter("fechaInicio") == null ? "":request.getParameter("fechaInicio");
			String fechaFin = request.getParameter("fechaFin")== null ? "":request.getParameter("fechaFin");
			// System.out.println(ci + "\t" + apellido);

			ServicioSolicitud sc = new ServicioSolicitud();
			List<Solicitud> listaSolicitud = new ArrayList<Solicitud>();
			try {
				if (!fechaInicio.equals("") || !fechaFin.equals("")){
					listaSolicitud = sc.consultarPorRangoFechasDos(new SimpleDateFormat(Constantes.FORMATOFECHA).parse(fechaInicio), new SimpleDateFormat(Constantes.FORMATOFECHA).parse(fechaFin));
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("listaSolicitud", listaSolicitud);

			getServletConfig().getServletContext().getRequestDispatcher("/vistas/aprobacionSolicitud.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
