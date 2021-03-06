package it.objectmethod.world.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.dao.impl.CountryDaoImpl;

@WebServlet("/ContinentList")
public class ContinentListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6710175699090842143L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> continents = new ArrayList<>();
		ICountryDao countryDao = new CountryDaoImpl();

		try {
			continents = countryDao.getAllContinent();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// output
		req.setAttribute("continentList", continents);
		req.getRequestDispatcher("pages/continentList.jsp").forward(req, resp);
	}

}
