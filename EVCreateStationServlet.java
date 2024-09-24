package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.OwnerBean;
import com.bean.UserBean;
import com.dao.OwnerDao;
import com.dao.UserDao;

/**
 * Servlet implementation class EVbunkServlet
 */
@WebServlet("/EVCreateStationServlet")
public class EVCreateStationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EVCreateStationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String ownername = request.getParameter("ownername");		
		String address = request.getParameter("address");		
		String area = request.getParameter("area");
		String city = request.getParameter("city");
		String path = request.getParameter("path");		
		String mobileno = request.getParameter("mobileno");
		String slot = request.getParameter("slot");
		String capacity = request.getParameter("capacity");
		String status = "Active";

		OwnerBean b = new OwnerBean();
		

		b.setOwnername(ownername);	
		b.setAddress(address);
		b.setArea(area);
		b.setCity(city);
		b.setPath(path);
		b.setMobileno(mobileno);
		b.setSlot(slot);
		b.setCapacity(capacity);
		b.setStatus(status);

		OwnerDao dao = new OwnerDao();

		if (dao.InsertEVCreateStationData(b)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Station Created Successfully')");
			out.println("location='CreateEVStation.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('UnSuccessful')");
			out.println("location='CreateEVStation.jsp';");
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
