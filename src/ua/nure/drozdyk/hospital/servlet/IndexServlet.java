package ua.nure.drozdyk.hospital.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller for processing GET-queries on index.html
 * 
 * @author E.Drozdyk
 * @version 1.0
 *
 */
@WebServlet(urlPatterns = { "/index.html", "/index" })
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 828189882115078785L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login");
	}
}
