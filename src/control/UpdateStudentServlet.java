package control;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import control.UserDao;

public class UpdateStudentServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			int id=Integer.valueOf(request.getParameter("id"));
			String stuId=request.getParameter("stuId");
			String password=request.getParameter("password");
			String stuName=request.getParameter("stuName");
			String pro=request.getParameter("pro");
			String phone=request.getParameter("phone");
			UserBean user=new UserBean();
			user.setId(id);
			user.setStuId(stuId);
			user.setPassword(password);
			user.setStuName(stuName);
			user.setPro(pro);
			user.setPhone(phone);
			UserDao ud=new UserDao();
			int row=ud.updateStudent(user);
			
			if(row>0){
				
				//getServletContext().setAttribute("count",count++);
//				RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
//				dispatcher.forward(request, response);
			    response.sendRedirect("SelectAllStudent.jsp");
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
