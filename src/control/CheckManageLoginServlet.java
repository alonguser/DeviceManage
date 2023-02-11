package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.ManageUserDao;
import model.ManageUserBean;

public class CheckManageLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String userId=request.getParameter("userId");
		ManageUserDao mud=new ManageUserDao();
		ManageUserBean slogin=mud.sLogin(userId);
		ManageUserBean sslogin=mud.ssLogin(userId);
		if(slogin !=null) {
			String pwd=slogin.getPassword();
			String password=request.getParameter("password");
			if(password.equals(pwd)) {
			String name=slogin.getName();
//			getServletContext().setAttribute("stuName",stuName);
			//getServletContext().setAttribute("count",count++);
			RequestDispatcher dispatcher=request.getRequestDispatcher("repairShow.jsp?name="+name);
			dispatcher.forward(request, response);
			}else {
				String cz="µ«¬º ß∞‹£¨«ÎºÏ≤È√‹¬Î£°";
				RequestDispatcher dispatcher=request.getRequestDispatcher("failure.jsp?cz="+cz);
				dispatcher.forward(request, response);
			}
		}else if(sslogin !=null) {
			String pwd=sslogin.getPassword();
			String password=request.getParameter("password");
			if(password.equals(pwd)) {
			String name=sslogin.getName();
//			getServletContext().setAttribute("stuName",stuName);
			//getServletContext().setAttribute("count",count++);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Show.jsp?name="+name);
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
