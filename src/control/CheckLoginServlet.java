package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.UserDao;
import model.UserBean;

public class CheckLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String stuId=request.getParameter("stuId");
		UserDao ud=new UserDao();
		UserBean login=ud.stuLogin(stuId);
		if(login !=null) {
			String pwd=login.getPassword();
			String password=request.getParameter("password");
			if(password.equals(pwd)) {
			String stuName=login.getStuName();
//			getServletContext().setAttribute("stuName",stuName);
			//getServletContext().setAttribute("count",count++);
			RequestDispatcher dispatcher=request.getRequestDispatcher("studentShow.jsp?name="+stuName);
			dispatcher.forward(request, response);
			}else {
				String cz="µ«¬º ß∞‹£¨«ÎºÏ≤È√‹¬Î£°";
				RequestDispatcher dispatcher=request.getRequestDispatcher("failure.jsp?cz="+cz);
				dispatcher.forward(request, response);
			}
		}else {
			String cz="”√ªß≤ª¥Ê‘⁄£°";
			RequestDispatcher dispatcher=request.getRequestDispatcher("failure.jsp?cz="+cz);
			dispatcher.forward(request, response);
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
