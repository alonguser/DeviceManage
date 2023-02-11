
package control;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeviceBean;
import control.DeviceDao;

public class AddDeviceServlet extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.setCharacterEncoding("utf-8");
			
			String name=request.getParameter("name");
			String location=request.getParameter("location");
			String address=request.getParameter("address");
			String repair=request.getParameter("repair");
			String time=request.getParameter("time");
			DeviceBean dev=new DeviceBean();
			
			dev.setName(name);
			dev.setLocation(location);
			dev.setAddress(address);
			dev.setRepair(repair);
			dev.setTime(time);
			DeviceDao dd=new DeviceDao();
			int row=dd.addDevice(dev);
			
			if(row>0){
				
				//getServletContext().setAttribute("count",count++);
//				RequestDispatcher dispatcher=request.getRequestDispatcher("success.jsp");
//				dispatcher.forward(request, response);
			    response.sendRedirect("SelectAllDevice.jsp");
			}else {
				String cz="ÃÌº” ß∞‹£°";
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
