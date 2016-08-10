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

			if (redireccion == true) {
				getServletConfig().getServletContext().getRequestDispatcher("/Home").forward(request,
						response);
			} else {
				getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			System.out.println("Error al iniciar");
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request,
					response);
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
			Usuario usr = new Usuario();
			usr.setUsr_ci(ci);
			usr.setUsr_clave(password);
			ServicioUsuario su = new ServicioUsuario();
			System.out.println("Antes del if");
			if(su.permitirIngreso(usr)==true){
				request.getSession().setAttribute("usuarioActivo", true);
				doGet(request, response);
			}
			else{
				request.getSession().setAttribute("usuarioActivo", false);
				getServletConfig().getServletContext().getRequestDispatcher("/vistas/home.jsp").forward(request, response);
			}
			System.out.println("despues del else");
		} catch (Exception e) {
			ci = "";
			password = "";
			System.out.println("catch del try post");
		}
	}

}
