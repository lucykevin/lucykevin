package com.hotel.book.service;

import java.util.Date;
import java.util.List;

import com.hotel.book.pojo.GuestBook;
import com.hotel.book.pojo.HotelRoom;

public interface BookingService {
	
    public List<HotelRoom> getAllAvailableRoom(Date date);
    
    public boolean BookingRoom(int roomId,String guestName,Date startDate,Date endDate);
    
    
    public List<GuestBook> findAllTheBookingForGuest(String guest);
}
