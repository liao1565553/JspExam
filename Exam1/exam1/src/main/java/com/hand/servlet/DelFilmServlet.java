package com.hand.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.service.FilmService;

public class DelFilmServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5254153631018077801L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		short filmId = Short.parseShort(req.getParameter("film_id"));
		try {
			if (FilmService.delFilmById(filmId)) {
				// req.getSession().setAttribute("is_del", "del_success");
				System.out.println("删除成功！删除id=" + req.getParameter("film_id"));
//				List<Map<?, ?>> newlists = (List<Map<?, ?>>) req.getSession().getAttribute("lists");
//				newlists.remove(filmId);
//				req.setAttribute("lists", newlists);
				List<Map<?, ?>> lists=FilmService.getFilmList();
				req.getSession().setAttribute("lists", lists);
				
				RequestDispatcher rd = req.getRequestDispatcher("mainFilm.jsp");
				rd.forward(req, resp);
			} else {
				System.out.println("删除失败！删除id=" + req.getParameter("film_id"));
				RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
				rd.forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL异常");
			RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
			rd.forward(req, resp);
		}

	}
}
