package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;

public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String stuId = request.getParameter("stuId");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String stuName = request.getParameter("stuName");
		String pro = request.getParameter("pro");
		String phone = request.getParameter("phone");
		if(password.equals(password2)) {
		UserBean user = new UserBean();
		user.setStuId(stuId);
		user.setPassword(password);
		user.setStuName(stuName);
		user.setPro(pro);
		user.setPhone(phone);
		UserDao ud=new  UserDao();
		int row=ud.addStudent(user);
		if(row>0){
			
			//getServletContext().setAttribute("count",count++);
//			RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
//			dispatcher.forward(request, response);
		    response.sendRedirect("SelectAllStudent.jsp");
		}else {
			String cz="添加失败，请检查！";
			RequestDispatcher dispatcher=request.getRequestDispatcher("failure.jsp?cz="+cz);
			dispatcher.forward(request, response);
		}
	}else {
		String cz="两次密码不一样，请重新输入！";
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
