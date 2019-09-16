package com.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Registration;
import com.beans.Tour;
import com.dao.TourDaoFactory;
import com.dao.TourData;
import com.dao.TourDataBasic;
import com.dao.TourUserDAO;

/**
 * Servlet implementation class TourServlet
 */
@WebServlet("/TourServlet")
public class TourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourDataBasic tourData = new TourDataBasic();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		
		if("addTourPage".equals(page)) {
			String tourName  = request.getParameter("tourNameBox");
			String startTour  = request.getParameter("startLocBox");
			String tourPoi  = request.getParameter("poiBox");
			int tourCost  = Integer.parseInt(request.getParameter("costBox"));
			int tourDays  = Integer.parseInt(request.getParameter("nodaysBox"));
			String availTour  = request.getParameter("availRadio");
			
			
			Tour tourBean = new Tour();
			tourBean.setTourName(tourName);
			tourBean.setStartLoc(startTour);
			tourBean.setPlaceInc(tourPoi);
			tourBean.setTourCost(tourCost);
			tourBean.setTourDays(tourDays);
			if(availTour == "YES") {
				int discount  = Integer.parseInt(request.getParameter("discountBox"));
				tourBean.setDiscount(discount);
			}
			else {
				tourBean.setDiscount(0);
			}
			
			TourData tourDao = TourDaoFactory.getTourFactoryInstance().getTourStorage("basic");
			tourDao.addTour(tourBean);
			
			RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/home.jsp");
			reqDispatch.forward(request, response);
		}
		else if("searchTourPage".equals(page)) {
			String tourCost  = request.getParameter("searchTourCostText");
			String tourPOI  = request.getParameter("searchPOIText");
			
			TourData tourDao = TourDaoFactory.getTourFactoryInstance().getTourStorage("basic");
			List<Tour> tourList = new ArrayList<Tour>();
			if(tourCost.isEmpty()) {
				tourList = tourDao.getToursByCost(Integer.parseInt(tourCost));
			}
			else if(tourPOI.isEmpty()) {
				tourList = tourDao.getToursByPOI(tourPOI);
			}
			else {
				tourList = tourDao.getToursByBoth(Integer.parseInt(tourCost), tourPOI);
			}
			
			request.setAttribute("tourList", tourList);
			
			RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/searchplan.jsp");
			reqDispatch.forward(request, response);
		}
		else if("subscribeTourPage".equals(page)) {
			String tourName = request.getParameter("subscribe");
			request.setAttribute("answer", tourName);
			
			RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/enrollplan.jsp");
			reqDispatch.forward(request, response);
		
		}
		else if("enrollTourPage".equals(page)) {
			
			String tourName  = request.getParameter("tourNameBox");
			String memberName  = request.getParameter("memberBox");
			String noPass  = request.getParameter("noPassBox");
			int tourCost  = Integer.parseInt(request.getParameter("costBox"));
			String startDate  = request.getParameter("startDateBox");
			String remarks  = request.getParameter("remarksTextArea");
			
			
			Tour tour = new Tour();
			tour = tourData.getToursByName(tourName);
			
			int noPassReal = 0;
			if(!noPass.isEmpty()) {
				noPassReal = Integer.parseInt(noPass);
			}
			
			Registration regi = new Registration();
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date date;
			try {
				date = sdf1.parse(startDate);
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
				regi.setJourneyStartDate(sqlStartDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			regi.setMemberName(memberName);
			regi.setNoPassengers(noPassReal);
			regi.setAmtPaid(tourCost);
			//regi.setJourneyStartDate(startDate);
			regi.setTourID(tour.getTourId());
			regi.setActive(true);
			regi.setRemarks(remarks);
			TourUserDAO tourDAO = new TourUserDAO();
			tourDAO.subscribeTourPackage(regi);
			
			request.setAttribute("tour", tour);
			
			RequestDispatcher reqDispatch = request.getRequestDispatcher("pages/home.jsp");
			reqDispatch.forward(request, response);
		
		}
		else if("cancelTourPage".equals(page)) {
			int tourId = Integer.parseInt(request.getParameter("cancelIDBox"));
			TourData tourDao = TourDaoFactory.getTourFactoryInstance().getTourStorage("basic");
			
			int validation = tourDao.cancelTourByID(tourId);
			if(validation == 1) {
				String message = "<font color=red>Successfully Deleted</font>";
				response.sendRedirect("pages/cancelplan.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			else {
				String message = "<font color=red>Was Not Deleted</font>";
				response.sendRedirect("pages/cancelplan.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		}
	}

}
