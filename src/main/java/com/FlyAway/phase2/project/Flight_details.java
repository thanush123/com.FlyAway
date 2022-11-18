package com.FlyAway.phase2.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.crypto.Data;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Flight_details extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/Flight_details")) {
			
			available_flights(request.getParameter("source"), request.getParameter("destination"), request.getParameter("date"), request, response);
		}
		if (path.equals("/flight_name")) {
			selected_flights(request.getParameter("soname"), request.getParameter("dename"), request.getParameter("dedate"),request.getParameter("flight"), request, response);
		}
		if(path.equals("/total_details")) {
			
			saveData(request, response);
			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute("fname", request.getParameter("fname"));
			request.setAttribute("lname", request.getParameter("lname"));
			request.setAttribute("gender", request.getParameter("gender"));
			request.setAttribute("age", request.getParameter("age"));
			request.setAttribute("ph_no", request.getParameter("ph_no"));
			request.setAttribute("sname", request.getParameter("sname"));
			request.setAttribute("dname", request.getParameter("dname"));
			request.setAttribute("date", request.getParameter("date"));
			request.setAttribute("flight", request.getParameter("flight"));
			request.setAttribute("npersons", request.getParameter("npersons"));
			
			RequestDispatcher rd = request.getRequestDispatcher("payment_gateway.jsp");
			rd.forward(request, response);
			
		}
		
		if(path.equals("/Final_Ticket")) {
			
			request.setAttribute("Email", request.getParameter("email"));
			request.setAttribute("Fname", request.getParameter("fname"));
			request.setAttribute("Lname", request.getParameter("lname"));
			request.setAttribute("Gender", request.getParameter("gender"));
			request.setAttribute("Age", request.getParameter("age"));
			request.setAttribute("Ph_no", request.getParameter("ph_no"));
			request.setAttribute("Sname", request.getParameter("sname"));
			request.setAttribute("Dname", request.getParameter("dname"));
			request.setAttribute("Date", request.getParameter("date"));
			request.setAttribute("Flight", request.getParameter("flight"));
			request.setAttribute("npersons", request.getParameter("npersons"));
			
			String fl=request.getParameter("flight");
			
			int per=Integer.parseInt(request.getParameter("npersons"));
			String separator ="₹";
			int sepPos = fl.indexOf(separator);
			int amount=Integer.parseInt(fl.substring(sepPos +       separator.length()));
			int t_amount=per*amount;
			request.setAttribute("t_amount", String.valueOf(t_amount));
			RequestDispatcher rd = request.getRequestDispatcher("Ticket.jsp");
			rd.forward(request, response);
		}
		
		if(path.equals("/admin_info")) {
			/*
			CREATE TABLE ADMIN_CRED(
					Admin_name varchar(255) not null primary KEY ,
				    A_Password varchar(255) not null
				     );
			*/
			String pass=passWord();
			String adm="Thanush";
			if(pass.equals(request.getParameter("passw")) && adm.equals(request.getParameter("adname")) ) {
				RequestDispatcher rd = request.getRequestDispatcher("ad_info.jsp");
				rd.forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("Entered wrong username or password");
			}
			
		}
		if(path.equals("/Changed_Password")) {
			changePass(request, response);
		}
		
	}

	private void available_flights(String sname, String dname, String ddate, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("SNAME", sname);
		request.setAttribute("DNAME", dname);
		request.setAttribute("DDATE", ddate);

		String f1 = null;
		String f2 = null;
		String f3 = null;
		int p1=0;
		int p2=0;
		int p3=0;
		boolean Flag=true;
		if (sname.equals("Hyderabad") && dname.equals("Bengaluru")) {
			f1 = "AirAsia A1518 09:00";
			f2 = "AirAsia A1519 12:00";
			f3 = "IndiGo  I1519 16:00";
			
			p1=4567;
			p2=3467;
			p3=5000;
			
		}
		else if (sname.equals("Hyderabad") && dname.equals("Delhi")) {
			f1 = "IndiGo    I1518 09:00";
			f2 = "AirAsia   A1519 12:00";
			f3 = "Akasa Air Aa1234 16:00";
			
			p1=8000;
			p2=6790;
			p3=10000;
		}
		else if (sname.equals("Hyderabad") && dname.equals("chennai")) {
			f1 = "IndiGo  I1256 09:00";
			f2 = "AirAsia A1789 12:00";
			f3 = "IndiGo  I1519 16:00";
			p1=3500;
			p2=4600;
			p3=4000;
		}
		
		else if (sname.equals("Bengaluru") && dname.equals("Delhi")) {
			f1 = "IndiGo    I4569 09:00";
			f2 = "AirAsia   A4519 12:00";
			f3 = "Akasa Air Aa4234 16:00";
			p1=10000;
			p2=16000;
			p3=13000;
		}
		else if (sname.equals("Bengaluru") && dname.equals("chennai")) {
			f1 = "IndiGo  I7256 09:00";
			f2 = "AirAsia A7789 12:00";
			f3 = "IndiGo  I7519 16:00";
			p1=3567;
			p2=6783;
			p3=2456;
		}else if (sname.equals("Bengaluru") && dname.equals("Hyderabad")) {
			f1 = "IndiGo    I2518 09:00";
			f2 = "AirAsia   A6519 12:00";
			f3 = "Akasa Air Aa7234 16:00";
			p2=4567;
			p1=3467;
			p3=5000;
		}
		else if (sname.equals("Delhi") && dname.equals("chennai")) {
			f1 = "Air India Express  AI1256 09:00";
			f2 = "AirAsia A1709 12:00";
			f3 = "IndiGo  I1619 16:00";
			p1=9987;
			p2=10045;
			p3=11708;
		}
		else if (sname.equals("Delhi") && dname.equals("Hyderabad")) {
			f1 = "IndiGo  I6756 09:00";
			f2 = "Jet Airways A2489 12:00";
			f3 = "IndiGo  I1419 16:00";
			
			p1=9000;
			p2=7790;
			p3=12000;
		}
		else if (sname.equals("Delhi") && dname.equals("Bengaluru")) {
			f1 = "IndiGo  I256 09:00";
			f2 = "AirAsia A189 12:00";
			f3 = "IndiGo  I151 16:00";
			p1=11000;
			p2=15000;
			p3=9000;
		}
		
		else if (sname.equals("chennai") && dname.equals("Bengaluru")) {
			f1 = "IndiGo  I1252 09:00";
			f2 = "AirAsia A1785 12:00";
			f3 = "IndiGo  I1518 16:00";
			p1=3567;
			p2=6783;
			p3=2456;
		}
		else if (sname.equals("chennai") && dname.equals("Hyderabad")) {
			f1 = "IndiGo  I5678 09:00";
			f2 = "AirAsia A1874 12:00";
			f3 = "IndiGo  I1974 16:00";
			p1=3000;
			p2=4300;
			p3=6000;
		}
		else if (sname.equals("chennai") && dname.equals("Delhi")) {
			f1 = "IndiGo  I7654 09:00";
			f2 = "AirAsia A567 12:00";
			f3 = "IndiGo  I2345 16:00";
			p1=9980;
			p2=14045;
			p3=11078;
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("Invalid Inputs Please Try Again");
			Flag=false;
		}
		
		request.setAttribute("F1", f1+" ₹"+p1);
		request.setAttribute("F2", f2+" ₹"+p2);
		request.setAttribute("F3", f3+" ₹"+p3);
		request.setAttribute("npersons", request.getParameter("npersons"));
		if(Flag==true) {
			RequestDispatcher rd = request.getRequestDispatcher("show_avai_flights.jsp");
			rd.forward(request, response);
		}

	}
	
	private void selected_flights(String sname,String dname,String date,String flight,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("sname", sname);
		request.setAttribute("dname", dname);
		request.setAttribute("date", date);
		request.setAttribute("flight", flight);
		request.setAttribute("npersons", request.getParameter("npersons"));
		RequestDispatcher rd = request.getRequestDispatcher("cust_info.jsp");
		rd.forward(request, response);
	}
	
	private void saveData(HttpServletRequest request,HttpServletResponse response) {
		
		/*
		CREATE TABLE USER_FLIGHT_DETAILS(
		     	S_No int NOT NULL PRIMARY KEY auto_increment,
		     	EMAIL varchar (255) NOT NULL,
		    	FIRST_NAME varchar (255) NOT NULL,
		     	LAST_NAME varchar (255) NOT NULL,
		        GENDER varchar (255),
		        AGE int,
		        Ph_No varchar (255),
		        SOURCE_NAME  varchar (255),
		        DESTINATION_NAME varchar (255),
		        DDATE varchar (255),
		        FLIGHT varchar (255)
		     );
		*/
		try {
			Connection con=JDBCUtill.getMySqlConnection();
			PreparedStatement pstmt=con.prepareStatement("INSERT INTO USER_FLIGHT_DETAILS(EMAIL,FIRST_NAME,LAST_NAME,GENDER,AGE,Ph_No,SOURCE_NAME,DESTINATION_NAME,DDATE,FLIGHT) VALUES(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, request.getParameter("email"));
			pstmt.setString(2, request.getParameter("fname"));
			pstmt.setString(3, request.getParameter("lname"));
			pstmt.setString(4, request.getParameter("gender"));
			pstmt.setInt(5, Integer.parseInt(request.getParameter("age")));
			pstmt.setString(6, request.getParameter("ph_no"));
			pstmt.setString(7, request.getParameter("sname"));
			pstmt.setString(8, request.getParameter("dname"));
			pstmt.setString(9, request.getParameter("date"));
			pstmt.setString(10, request.getParameter("flight"));
			pstmt.execute();
			JDBCUtill.cleanUp(pstmt, con);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception Found "+e);
		}
	}
	private void  changePass(HttpServletRequest request,HttpServletResponse response){
		try {
			Connection con=JDBCUtill.getMySqlConnection();
			PreparedStatement pstmt=con.prepareStatement("UPDATE ADMIN_CRED SET A_Password=? where Admin_name='Thanush'");
			pstmt.setString(1,request.getParameter("c_pass"));
			pstmt.execute();
			JDBCUtill.cleanUp(pstmt, con);
			PrintWriter out = response.getWriter();
			out.println("Password Changed succesfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception Found "+e);
		}
	}
	private String passWord() {
		String p=null;
		try {
			Connection con=JDBCUtill.getMySqlConnection();
			Statement stmt=con.createStatement();
			ResultSet rs= stmt.executeQuery("Select A_Password From ADMIN_CRED where Admin_name='Thanush'");
			rs.next();
			p=rs.getString(1);
			rs.close();
			con.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception Found "+e);
		}
		return p;
	}
}
