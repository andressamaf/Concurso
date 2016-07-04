package controller.solicitud;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Solicitud;
import modelo.servicio.ServicioSolicitud;
import modelo.servicio.ServicioUsuario;

/**
 * Servlet implementation class Consulta
 */
@WebServlet("/Consulta")
public class ConsultaSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultaSolicitud() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean redireccion = false;
		try {
			redireccion = (boolean) request.getSession().getAttribute("usuarioActivo");

			if (redireccion == true) {
				getServletConfig().getServletContext().getRequestDispatcher("/vistas/consultaInformacion.jsp")
						.forward(request, response);
			}

		} catch (Exception e) {

		}

		if (redireccion == false) {
			getServletConfig().getServletContext().getRequestDispatcher("/Login").forward(request, response);

		}

		else {
			String ci = request.getParameter("ci");
			String apellido = request.getParameter("apellido");
			System.out.println(ci + "\t" + apellido);

			ServicioSolicitud sc = new ServicioSolicitud();
			List<Solicitud> listaSolicitud = sc.consultarPorCIyApellidos(ci, apellido);
			System.out.println(listaSolicitud.size());
			if (listaSolicitud.size() == 0){
				request.setAttribute("mensaje", "No se encuentran registros relacionados. Intente con otro criterio.");
			}
			request.setAttribute("listaSolicitud", listaSolicitud);

			getServletConfig().getServletContext().getRequestDispatcher("/vistas/consultaInformacion.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
