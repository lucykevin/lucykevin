package com.hotel.book.pojo;


import java.text.SimpleDateFormat;
import java.util.Date;
public class GuestBook {
    int id;
    int roomId;
    String guestName;
    Date bookStartDate;
    Date bookEndDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public Date getBookStartDate() {
		return bookStartDate;
	}

	public void setBookStartDate(Date bookStartDate) {
		this.bookStartDate = bookStartDate;
	}

	public Date getBookEndDate() {
		return bookEndDate;
	}

	public void setBookEndDate(Date bookEndDate) {
		this.bookEndDate = bookEndDate;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookEndDate == null) ? 0 : bookEndDate.hashCode());
		result = prime * result + ((bookStartDate == null) ? 0 : bookStartDate.hashCode());
		result = prime * result + ((guestName == null) ? 0 : guestName.hashCode());
		result = prime * result + id;
		result = prime * result + roomId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuestBook other = (GuestBook) obj;
		if (bookEndDate == null) {
			if (other.bookEndDate != null)
				return false;
		} else if (!bookEndDate.equals(other.bookEndDate))
			return false;
		if (bookStartDate == null) {
			if (other.bookStartDate != null)
				return false;
		} else if (!bookStartDate.equals(other.bookStartDate))
			return false;
		if (guestName == null) {
			if (other.guestName != null)
				return false;
		} else if (!guestName.equals(other.guestName))
			return false;
		
		if (roomId != other.roomId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDateStr="";
		String endDateStr="";
		if(this.getBookStartDate()!=null) {
			startDateStr=sdf.format(this.getBookStartDate());
		}
		if(this.getBookEndDate()!=null) {
			endDateStr= sdf.format(this.getBookEndDate());
		}
		return "GuestBook [id=" + id + ", roomId=" + roomId + ", guestName=" + guestName + ", bookStartDate="
				+ startDateStr + ", bookEndDate=" + endDateStr + "]";
	}

   
}
