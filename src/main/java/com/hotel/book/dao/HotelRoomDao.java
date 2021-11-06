package com.hotel.book.dao;

import java.util.List;

import com.hotel.book.pojo.GuestBook;
import com.hotel.book.pojo.HotelRoom;

public interface HotelRoomDao {
    public List<HotelRoom> findAll();
    public HotelRoom findById(int id);
    public void updateHotelRoom(int roomId,GuestBook guestBook);
    public void deleteBooking(int roomId,GuestBook guestBook);
}
