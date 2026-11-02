package TicketBooking;

import java.util.Random;

public class Section
{
    private int sectionNumber; //may change to string // changes to sectionNumber(from Id) for convenience
    int numberOfRows; // 10
    int numberOfSeatsInRow; // 60
    private int maxPrice;
    private int minPrice;
    private Ticket[][] tickets;

    public Section(int sectionNumber, int maxPrice, int minPrice, int numberOfRows, int numberOfSeatsInRow) //change here depending on the fields
    {
        this.sectionNumber = sectionNumber;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.numberOfRows = numberOfRows;
        this.numberOfSeatsInRow = numberOfSeatsInRow;
        this.tickets = new Ticket[numberOfRows][numberOfSeatsInRow];

    }

    // Copy constructor
    public Section(Section anotherSection)
    {
        this.sectionNumber = anotherSection.getSectionNumber();
        this.maxPrice = anotherSection.getMaxPrice();
        this.minPrice = anotherSection.getMinPrice();
        this.numberOfRows = anotherSection.getNumberOfRows();
        this.numberOfSeatsInRow = anotherSection.getNumberOfSeatsInRow();
        this.tickets = anotherSection.getTicketsInSection2DArray();
    }

    public void setSectionNumber(int sectionNumber)
    {
        this.sectionNumber = sectionNumber;
    }

    public int getSectionNumber()
    {
        return sectionNumber;
    }

    public void setMaxPrice(int maxPrice)
    {
        this.maxPrice = maxPrice;
    }

    public int getMaxPrice()
    {
        return maxPrice;
    }

    public void setMinPrice(int minPrice)
    {
        this.minPrice = minPrice;
    }

    public int getMinPrice()
    {
        return minPrice;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfSeatsInRow() {
        return numberOfSeatsInRow;
    }

    public void setNumberOfSeatsInRow(int numberOfSeatsInRow) {
        this.numberOfSeatsInRow = numberOfSeatsInRow;
    }

    // retuns a two-dimensional array of Ticket objects
    public Ticket[][] getTicketsInSection2DArray() {
        
        Ticket[][] newTickets = new Ticket[tickets.length][tickets[0].length];
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < tickets[i].length; j++) {
                newTickets[i][j] = new Ticket(tickets[i][j]);
            }
        }

        return newTickets;
    }

    public void setTicket(Ticket ticket) {
        int row = ticket.getRowNumber();
        int seat = ticket.getSeatNumber();

        if (row < 0 || row >= numberOfRows || seat < 0 || seat >= numberOfSeatsInRow) {
            System.out.println("Invalid row or seat number");
            System.exit(0);
        }else{
            tickets[row][seat] = ticket;
        }
    }

    public Ticket getTicket(int row, int seat) {
        if (row < 0 || row >= numberOfRows || seat < 0 || seat >= numberOfSeatsInRow) {
            System.out.println("Invalid row or seat number");
            System.exit(0);
        }
        
        return new Ticket(tickets[row][seat]);
        
    }

    public void createTicketsForSection()
    {
        Random  rand = new Random();
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++)
            {
                for (int seatNumber = 0; seatNumber < numberOfSeatsInRow; seatNumber++)
                {
                    
                    switch (rowNumber)
                    {
                        case 0 -> setTicket(new Ticket(sectionNumber, rowNumber, seatNumber, maxPrice, false));
                        
                        case 1 -> setTicket(new Ticket(sectionNumber, rowNumber, seatNumber, maxPrice*8/10, false));
                        
                        default ->
                        {
                            int price = rand.nextInt(minPrice, maxPrice);
                            setTicket(new Ticket(sectionNumber, rowNumber, seatNumber, price, false));
                        }
                    }
                    
                }
            }
    }

    @Override
    public String toString()
    {
        return "Section Number: " + sectionNumber + "\n" +
                "Max Price: " + maxPrice + "\n" +
                "Min Price: " + minPrice + "\n" +
                "Number of Rows: " + numberOfRows + "\n" +
                "Number of Seats in Row: " + numberOfSeatsInRow + "\n";
    }
}
