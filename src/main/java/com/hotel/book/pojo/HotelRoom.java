package com.hotel.book.pojo;
import java.util.List;
public class HotelRoom {
    int id;
    List<GuestBook> guestBooks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public List<GuestBook> getGuestBooks() {
		return guestBooks;
	}

	public void setGuestBooks(List<GuestBook> guestBooks) {
		this.guestBooks = guestBooks;
	}

	@Override
	public String toString() {
		String guestBooksStr="";
		
		if(this.getGuestBooks()!=null && this.getGuestBooks().size()>0) {
			
			StringBuilder sb = new StringBuilder("[");
			this.getGuestBooks().forEach(dto->{
				sb.append("{");
				sb.append(dto.toString());
				sb.append("}");
				
			});
			sb.append("]");
			guestBooksStr= sb.toString();
			
		}
		
		
		return "HotelRoom [id=" + id + ", guestBooks=" + guestBooksStr + "]";
	}

	

   
}
