package com.hotel.book.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.hotel.book.config.RoomConfig;
import com.hotel.book.pojo.GuestBook;

public class GuestBookMapper {
	

	
	public static Map<Integer,List<GuestBook>> rooms=new ConcurrentHashMap<Integer,List<GuestBook>>();

  public static List<GuestBook> guestBooks = Collections.synchronizedList(new ArrayList<GuestBook>());
  static {
	  for(Integer roomNum =1;roomNum<=RoomConfig.ROOM_NUMS;roomNum++) {
		  rooms.put(roomNum, new ArrayList<GuestBook>());
		  
	  }
  }

  
  
}
