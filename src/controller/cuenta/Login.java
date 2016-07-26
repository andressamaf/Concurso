package controller.cuenta;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidades.Administrador;
import modelo.servicio.ServicioAdministrador;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		boolean redireccion = true;
		try {
			redireccion = (boolean) request.getSession().getAttribute("usuarioActivo");
			System.out.println(redireccion);
			if (redireccion == true) {
				getServletConfig().getServletContext().getRequestDispatcher("/Home").forward(request,
						response);
			} else {
				getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al iniciar");
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request, response);
		}

		if (redireccion == false) {
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ci = "";
		String password = "";
		try {
			ci = request.getParameter("ci");
			password = request.getParameter("clave");
		} catch (Exception e) {
			ci = "";
			password = "";
		}
		Administrador usr = new Administrador();
		usr.setUsr_ci(ci);
		usr.setUsr_clave(password);

		ServicioAdministrador se = new ServicioAdministrador();
		request.getSession().setAttribute("usuarioActivo", true);
		System.out.println(true);
		doGet(request, response);
	}

}
