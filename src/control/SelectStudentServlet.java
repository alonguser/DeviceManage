package control;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SelectStudentServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			
			String selectdevice=request.getParameter("selectdevice");
			String content=request.getParameter("content");
			
			if(content!=null) {
				request.setAttribute("content",content);
				request.setAttribute("selectdevice",selectdevice);
				RequestDispatcher dispatcher=request.getRequestDispatcher("SelectStudentByContent.jsp");
				dispatcher.forward(request, response);
			}else {			
			
				//getServletContext().setAttribute("count",count++);
//				RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
//				dispatcher.forward(request, response);
				String cz="≤È—Ø ß∞‹£°";
				RequestDispatcher dispatcher=request.getRequestDispatcher("failure.jsp?cz="+cz);
				dispatcher.forward(request, response);
			
		}}
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(request, response);
		}

}
