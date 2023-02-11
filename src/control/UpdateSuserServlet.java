package control;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManageUserBean;
import control.ManageUserDao;

public class UpdateSuserServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			int id=Integer.valueOf(request.getParameter("id"));
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			ManageUserBean suser=new ManageUserBean();
			suser.setId(id);
			suser.setUserId(userId);
			suser.setPassword(password);
			suser.setName(name);
			suser.setPhone(phone);
			ManageUserDao mud=new ManageUserDao();
			int row=mud.updateSuser(suser);
			
			if(row>0){
				
				//getServletContext().setAttribute("count",count++);
//				RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
//				dispatcher.forward(request, response);
			    response.sendRedirect("SelectAllSuser.jsp");
			}else {
				String cz="ÐÞ¸ÄÊ§°Ü£¡";
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
