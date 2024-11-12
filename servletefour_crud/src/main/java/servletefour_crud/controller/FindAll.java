package servletefour_crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletefour_crud.dao.StudentDao;

@WebServlet("/fa")
public class FindAll extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao dao=new StudentDao();
		Object o=dao.fetchAll();
		resp.getWriter().print(o);
	}
}
