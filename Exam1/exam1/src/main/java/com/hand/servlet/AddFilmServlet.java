package com.hand.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.bean.Film;
import com.hand.service.FilmService;
import com.hand.service.LanguageService;

public class AddFilmServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7505787360218029367L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		System.out.println("添加电影");
		String title=(String) req.getParameter("title");
		String description=(String) req.getParameter("description");
		String language=(String) req.getParameter("language");
		System.out.println("language="+language);
		
		Film film=new Film();
		film.setDescription(description);
		film.setTitle(title);
		boolean b=false;
		try {
			byte by=LanguageService.getIdByName(language);
			film.setLanguageId(by);
			b=FilmService.addFilm(film);
			if (b) {
				System.out.println("添加成功");
				List<Map<?, ?>> lists=FilmService.getFilmList();
				req.getSession().setAttribute("lists", lists);
				resp.sendRedirect(req.getContextPath() + "/addSuccess.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("添加失败！");
		}
		
		
	}

}
