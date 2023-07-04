package co.santhu.phonebook.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/theme")
public class ChangeThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String theme = request.getParameter("name");
		List<String> list = Arrays.asList("blue","minty","orange","sketchy","vapor");
		
		if(list.contains(theme)==false) {
			theme="orange";
		}
		
		Cookie c1 = new Cookie("theme", theme);
		c1.setMaxAge(365*24*60*60);
		
		//Send this back to the browser
		response.addCookie(c1);
		response.sendRedirect("./");
	}

}
