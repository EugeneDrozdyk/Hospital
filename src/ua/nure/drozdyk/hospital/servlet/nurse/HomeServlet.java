package ua.nure.drozdyk.hospital.servlet.nurse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.drozdyk.hospital.servlet.BaseServlet;

/**
 * Controller for view nurse home page.
 * 
 * @author E.Drozdyk
 * @version 1.0
 */
@WebServlet("/nurse/home")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = -7834937634600129996L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		forwardToPage("nurse/home.jsp", request, response);
	}
}
