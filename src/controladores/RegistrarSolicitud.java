package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class RegistrarSolicitud
 */
@WebServlet("/RegistrarSolicitud")
public class RegistrarSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarSolicitud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletConfig().getServletContext().getRequestDispatcher("/vistas/solicitudRegistro.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServicioSolicitud ss = new ServicioSolicitud();	
		Solicitud solicitud = new Solicitud();
		solicitud.setSol_ci(request.getParameter("SOL_CI"));
		if (!ss.existe(solicitud)){
			System.out.println("Ya existe");
			solicitud.setSol_nombres(request.getParameter("SOL_NOMBRES"));
			solicitud.setSol_apellidos(request.getParameter("SOL_APELLIDOS"));
			solicitud.setSol_codprov(Integer.parseInt(request.getParameter("SOL_CODPROV")));
			solicitud.setSol_codciu(Integer.parseInt(request.getParameter("SOL_CODCIU")));
			solicitud.setSol_sexo(request.getParameter("SOL_SEXO_H") != null ? "H" : "M");
			
			try {
				System.out.println(request.getParameter("SOL_FECHANAC"));
				solicitud.setSol_fechaNac(new SimpleDateFormat(Constantes.FORMATOFECHA).parse(request.getParameter("SOL_FECHANAC")));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			solicitud.setSol_telefono(request.getParameter("SOL_TELEFONO"));
			solicitud.setSol_nummiem(Integer.parseInt(request.getParameter("SOL_NUMMIEM")));
			solicitud.setSol_disc(request.getParameter("SOL_DISC_SI") != null ? true : false);
			solicitud.setSol_fecha(new Date());
			solicitud.setSol_estado("S");
			ss.guardar(solicitud);			
			getServletConfig().getServletContext().getRequestDispatcher("/Home").forward(request, response);;
		}
		else{
			getServletConfig().getServletContext().getRequestDispatcher("/vistas/solicitudRegistro.jsp").forward(request, response);
		}
		this.doGet(request, response);
		
	}

}
