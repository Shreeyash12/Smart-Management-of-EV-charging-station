package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.OwnerBean;
import com.bean.UserBean;
import com.connection.DBConnection;
import com.dao.UserDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String area=request.getParameter("area");
		UserDao dao=new UserDao();
		//UserBean user;// = new UserBean();
		OwnerBean user=dao.CheckArea(area);
		
		if(user == null) {
			out.println("<script type=\"text/javascript\">");
			 out.println("alert('No Such User Present...')");
			 out.println("location='UserHome.jsp';");
			 out.println("</script>");
		}
		else if((user.getArea()!=null && user.getArea()!=""))
		{
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('View Location)");
			out.println("location='SearchServlet.jsp';");
			out.println("</script>");
			HttpSession session=request.getSession(); 
	        session.setAttribute("ownername",user.getOwnername());  
	        session.setAttribute("address", user.getAddress());
	        session.setAttribute("area", user.getArea());
	        session.setAttribute("city", user.getCity());
	        session.setAttribute("path", user.getPath());
	        session.setAttribute("mobileno", user.getMobileno());
	        session.setAttribute("slot", user.getSlot());
	        session.setAttribute("capacity", user.getCapacity());
	        
	        
		    }
			else {
				request.setAttribute("ErrMsg", "Wait for activation of your account!...");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Wait For Activation')");
				out.println("location='UserHome.jsp';");
				out.println("</script>");
			}
		
		
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
