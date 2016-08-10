package controller.cuenta;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean redireccion = true;
		try {
			redireccion = (boolean) request.getSession().getAttribute("usuarioActivo");

			if (redireccion == true) {
				getServletConfig().getServletContext().getRequestDispatcher("/vistas/home2.jsp").forward(request,
						response);
			} else {
				getServletConfig().getServletContext().getRequestDispatcher("/Login").forward(request,
						response);
			}
		} catch (Exception e) {
			System.out.println("Error al iniciar");
		}
		
		if (redireccion == false) {
			getServletConfig().getServletContext().getRequestDispatcher("/Login").forward(request,
					response);
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
