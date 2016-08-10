package controller.cuenta;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Usuario;
import modelo.servicio.ServicioUsuario;

/**
 * Servlet implementation class AdministrarUsuario
 */
@WebServlet("/usuario/administrar")
public class AdministrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdministrarUsuario() {
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
		String nombre = request.getParameter("nombre");
		
		if (nombre == null)
			nombre = "";			
		List<Usuario> listaUsuarios = su.listarUsuarios(nombre);
		request.setAttribute("listaUsuario", listaUsuarios);
		getServletConfig().getServletContext().getRequestDispatcher("/vistas/usuario/administrar.jsp")
				.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
