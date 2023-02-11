package control;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.ManageUserDao;

public class DeleteSuserServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			String stuid = request.getParameter("STUID");
			int id=Integer.parseInt(stuid.toString().trim());
			ManageUserDao mud = new ManageUserDao();
			int row = mud.deleteSuser(id);
			if(row>0){
				
				response.sendRedirect("SelectAllSuser.jsp");
			}else {
				String cz="É¾³ýÊ§°Ü£¡";
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
