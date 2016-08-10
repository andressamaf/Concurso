package controller.cuenta;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Usuario;
import modelo.servicio.ServicioUsuario;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/usuario/modificar")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServicioUsuario su = new ServicioUsuario();
		String ci = request.getParameter("usuarioModificar");
		if (ci == null)
			ci = "";
		System.out.println(ci);
		Usuario u = su.buscarUsuario(ci);
		System.out.println(u.getUsr_nombre());
		request.setAttribute("usuarioEditar", u);
		getServletConfig().getServletContext()
				.getRequestDispatcher("/vistas/usuario/modificar.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		String ci = request.getParameter("ci");
		ServicioUsuario su = new ServicioUsuario();
		u.setUsr_ci(ci);
		u.setUsr_nombre(request.getParameter("nombre"));
		u.setUsr_telefono(request.getParameter("telefono"));
		u.setUsr_correo(request.getParameter("email"));
		u.setUsr_rol(request.getParameter("rol"));
		u.setUsr_clave(request.getParameter("clave"));
		try {
			su.modificarUsuario(u);
			getServletConfig().getServletContext()
					.getRequestDispatcher("/usuario/administrar")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			getServletConfig().getServletContext()
					.getRequestDispatcher("/vistas/usuario/modificar.jsp")
					.forward(request, response);
		}

	}

}
