package com.hotel.book.dao;

import java.util.ArrayList;
import java.util.List;

import com.hotel.book.mapper.GuestBookMapper;
import com.hotel.book.pojo.GuestBook;
import com.hotel.book.pojo.HotelRoom;

public class HotelRoomDaoImpl implements HotelRoomDao {

	@Override
	public List<HotelRoom> findAll() {
		List<HotelRoom> roomsAll = new ArrayList<>();
		GuestBookMapper.rooms.forEach((key,list)->{
			HotelRoom room= new HotelRoom();
			room.setId(key);
			room.setGuestBooks(list);
			roomsAll.add(room);
			
		});
		return roomsAll;
	}

	@Override
	public HotelRoom findById(int id) {
		HotelRoom room= new HotelRoom();
		room.setId(id);
		room.setGuestBooks(GuestBookMapper.rooms.get(id));
		return room;
		
	}

	@Override
	public void updateHotelRoom(int roomId, GuestBook guestBook) {
		GuestBookMapper.rooms.get(roomId).add(guestBook);
		
	}

	@Override
	public void deleteBooking(int roomId, GuestBook guestBook) {
		List<GuestBook> guestBooks=GuestBookMapper.rooms.get(roomId);
		for(int i = 0 ;i<guestBooks.size();i++) {
			if(guestBooks.get(i).equals(guestBooks)) {
				guestBooks.remove(i);
			}
		}
		
	}

	

  
}
