package com.hotel.book.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hotel.book.dao.GuestBookDao;
import com.hotel.book.dao.GuestBookDaoImpl;
import com.hotel.book.dao.HotelRoomDao;
import com.hotel.book.dao.HotelRoomDaoImpl;
import com.hotel.book.pojo.GuestBook;
import com.hotel.book.pojo.HotelRoom;
import com.hotel.book.util.HelpUtil;

public class BookingServiceImpl implements BookingService {
	
	GuestBookDao guestBookDao = new GuestBookDaoImpl();
	HotelRoomDao hotelRoomDao = new HotelRoomDaoImpl();

	@Override
	public List<HotelRoom> getAllAvailableRoom(Date date) {
		List<HotelRoom>  hotelRooms = hotelRoomDao.findAll();
		List<HotelRoom> availableList= new ArrayList<HotelRoom>();
		hotelRooms.forEach(hotelRoom->{
			if(hotelRoom.getGuestBooks().size()==0) {
				availableList.add(hotelRoom);
			}else {
				//boolean ordered = false;
				List<GuestBook> books = hotelRoom.getGuestBooks();
				books.forEach(book->{
					Date start = book.getBookStartDate();
					Date end = book.getBookEndDate();
					if(date.after(start)&&date.before(end)||date.equals(start)||date.equals(end)) {
						return;
					}
					availableList.add(hotelRoom);
				});
			}
		});
		return availableList;
	}

	@Override
	public boolean BookingRoom(int roomId, String guestName, Date startDate, Date endDate) {
		GuestBook guestBook = new GuestBook();
		guestBook.setGuestName(guestName);
		guestBook.setRoomId(roomId);
		guestBook.setBookStartDate(startDate);
		guestBook.setBookEndDate(endDate);
		guestBook.setId(HelpUtil.getId());
		guestBookDao.addGuestBook(guestBook);
		hotelRoomDao.updateHotelRoom(roomId, guestBook);
		return true;
	}

	@Override
	public List<GuestBook> findAllTheBookingForGuest(String guest) {
		 List<GuestBook> guestBooks = new ArrayList<>();
		guestBookDao.findAll().forEach(dto->{
			if(dto.getGuestName().equals(guest)) {
				guestBooks.add(dto);
			}
			
			
			
		});
		return guestBooks;
	}

    
}
