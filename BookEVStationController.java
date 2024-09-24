package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class BookEVStationController
 */
@WebServlet("/BookEVStationController")
public class BookEVStationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookEVStationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 
		String name = request.getParameter("name");		
		String vehicalname = request.getParameter("vehicalname");		
		String vehicalno = request.getParameter("vehicalno");
		String city = request.getParameter("city");
		String area = request.getParameter("area");	
		String time = request.getParameter("time");		
		String date = request.getParameter("date");
	 	String ownername = request.getParameter("ownername");
		String accountname = request.getParameter("accountname");
		String accountno = request.getParameter("accountno");
		String ifsc = request.getParameter("ifsc");
		String amount = request.getParameter("amount");
		String status = "Pending";

		UserBean b = new UserBean();		

		b.setName(name);
		b.setVehicalname(vehicalname);
		b.setVehicalno(vehicalno);	
		b.setCity(city);
		b.setArea(area);
		b.setTime(time);
		b.setDate(date);
		b.setOwnername(ownername);
		b.setAccountname(accountname);
		b.setAccountno(accountno);	
		b.setIfsc(ifsc);
		b.setAmount(amount);
		b.setStatus(status);

		UserDao dao = new UserDao();

		if (dao.InsertBookingEVStationData(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Booking Successfully...')");
			out.println("location='UserHome.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Booking UnSuccessful')");
			out.println("location='BookEVStation.jsp';");
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
