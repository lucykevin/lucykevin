package com.hotel.book.dao;

import java.util.List;

import com.hotel.book.mapper.GuestBookMapper;
import com.hotel.book.pojo.GuestBook;


public class GuestBookDaoImpl implements GuestBookDao {

	@Override
	public List<GuestBook> findAll() {
		
		
		return GuestBookMapper.guestBooks;
	}

	@Override
	public GuestBook findById(int id) {
		List<GuestBook> allist =findAll() ;
		 for(int i =0;i<allist.size();i++) {
			 if(allist.get(i).getId()==id) {
				 return allist.get(i);
			 }
		 }
		 
		return null;
	}

	@Override
	public void deleteBooking(GuestBook guestBook) {
		List<GuestBook> allist =findAll() ;
		 for(int i =0;i<allist.size();i++) {
			 if(allist.get(i).equals(guestBook)) {
				 
				 allist.remove(i);
				 int roomId = allist.get(i).getRoomId();
				 
				 List<GuestBook> books = GuestBookMapper.rooms.get(roomId);
				 for(int y =0;y<books.size();y++) {
					 if(books.get(y).equals(guestBook)) {
						 books.remove(y);
						 break;
					 }
				 }
				 
				 break;
			 }
		 }
		
	}

	@Override
	public void addGuestBook(GuestBook guestBook) {
		GuestBookMapper.guestBooks.add(guestBook);
		
	}

   
}
