package com.hotel.book.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.book.pojo.GuestBook;
import com.hotel.book.pojo.HotelRoom;
import com.hotel.book.service.BookingService;
import com.hotel.book.service.BookingServiceImpl;


public class HotelBookingController {  
   private  BookingService bookingService= new BookingServiceImpl();
   

    /**
     * request url like:http://localhost:8080/guest/availAbleBook?date=2021-11-21
     * request url:/guest/availAbleBook
     * @param date
     * @return
     * @throws ParseException 
     * @throws IOException 
     */
    public void getAllAvailableRoom(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException{
    	String dateStr = request.getParameter("date");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = sdf.parse(dateStr);
    	List<HotelRoom>  allList = bookingService.getAllAvailableRoom(date);
    	StringBuilder sb = new StringBuilder();
    	allList.forEach(dto->{
    	String str=	dto.toString();
    	sb.append(str);
    	//sb.append("<br/>");
    		//sb.append(dto.)
    	});
    	response.getWriter().println(sb.toString());
    	response.flushBuffer();
    };
    
    /**
     * request url:/guest/book
     * @param date
     * @return
     * @throws ParseException 
     * @throws IOException 
     */
    public void bookingRoom(HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
    	String roomIdStr = request.getParameter("roomId");
    	String guestName = request.getParameter("guestName");
    	String startDateStr = request.getParameter("startDate");
    	String endDateStr = request.getParameter("endDate");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date startDate = sdf.parse(startDateStr);
    	Date endDate = sdf.parse(endDateStr);
    	Integer roomId = Integer.parseInt(roomIdStr);
    	boolean result= bookingService.BookingRoom(roomId, guestName, startDate, endDate);
    	response.getWriter().print(result);
    	response.flushBuffer();
    };
    
    /**
     * /guest/list/books
     * @param guest
     * @return
     * @throws IOException 
     */
    public void findAllTheBookingForGuest(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	String guest = request.getParameter("guest");
    	List<GuestBook> listBooks = bookingService.findAllTheBookingForGuest(guest);
    	StringBuilder sb = new StringBuilder();
    	listBooks.forEach(dto->{
    		String str = dto.toString();
    		sb.append(str);
    	});
    	response.getWriter().println(sb.toString());
    	response.flushBuffer();
    };
}
