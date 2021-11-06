package com.hotel.book.dao;

import java.util.List;

import com.hotel.book.pojo.GuestBook;
import com.hotel.book.pojo.HotelRoom;

public interface GuestBookDao {
    public List<GuestBook> findAll();
    public GuestBook findById(int id);
    public void addGuestBook(GuestBook guestBook);
    public void deleteBooking(GuestBook guestBook);
}
