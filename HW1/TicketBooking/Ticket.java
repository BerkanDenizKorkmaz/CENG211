package TicketBooking;

public class Ticket 
{
    private int sectionNumber;
    private int rowNumber;
    private int seatNumber;
    private int price;
    private boolean bookingStatus; //bookingStatus expects and return true or false

    public Ticket(int sectionNumber, int rowNumber,int seatNumber,int price,boolean bookingStatus)
    {
        this.sectionNumber = sectionNumber;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    //Copy constructor
    public Ticket(Ticket anotherTicket)
    {
        this.sectionNumber = anotherTicket.getSectionNumber();
        this.rowNumber = anotherTicket.getRowNumber();
        this.seatNumber = anotherTicket.getSeatNumber();
        this.price = anotherTicket.getPrice();
        this.bookingStatus = anotherTicket.isBooked();
    }



    public void setSectionNumber(int sectionNumber)
    {
        this.sectionNumber = sectionNumber;
    }

    public int getSectionNumber()
    {
        return sectionNumber;
    }

    public void setRowNumber(int rowNumber)
    {
        this.rowNumber = rowNumber;
    }

    public int getRowNumber()
    {
        return rowNumber;
    }

    public void setSeatNumber(int seatNumber)
    {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber()
    {
        return seatNumber;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getPrice()
    {
        return price;
    }

    public void setBookingStatus(boolean bookingStatus)
    {
        this.bookingStatus = bookingStatus;
    }

    public boolean isBooked()
    {
        return bookingStatus;
    }

    @Override
    public String toString()
    {
        return "Section Number: " + sectionNumber + " Row Number: " + rowNumber + " Seat Number: " + seatNumber + " Price: " + price + "$";
    }   
    
}
