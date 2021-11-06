package com.hotel.book.service;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.book.config.RequestPathConfig;
import com.hotel.book.controller.HotelBookingController;
import com.hotel.book.util.HelpUtil;

/**
 * Servlet implementation class HotelServlet
 */
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestUri = HelpUtil.getRequestUri(request);
		
		HotelBookingController controller = new HotelBookingController();
		if(requestUri.contains(RequestPathConfig.BOOKING_REQUEST)) {
			try {
				controller.bookingRoom(request,response);
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  else if(requestUri.contains(RequestPathConfig.BOOKING_REQUEST_AVAILABLE)) {
			try {
				controller.getAllAvailableRoom(request,response);
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(requestUri.contains(RequestPathConfig.BOOKING_REQUEST_ALL_GUEST_BOOKS)) {
			controller.findAllTheBookingForGuest(request,response);
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
