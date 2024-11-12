package servletefour_crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletefour_crud.dao.StudentDao;

@WebServlet("/did")
public class RemoveById extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("pk");
		System.out.println(email);
		
		StudentDao studentDao=new StudentDao();
		String msg=studentDao.deleteById(email);
		resp.getWriter().print(msg);
	}
}
