package TicketBooking;

import java.util.Random;

public class RandomTicketGenerator {
    
    public Ticket generateRandomTicketInSection(Venue venue, int sectionNumber)
    {
        if (sectionNumber < 0 || sectionNumber >= venue.getNumberOfSections()) {
            System.out.println("Invalid section number");
            System.exit(0);
        }
        Random rand = new Random();
        Section section = venue.getSections()[sectionNumber];
        int numberOfRows = section.getNumberOfRows();
        int numberOfSeatsInRow = section.getNumberOfSeatsInRow();

        Ticket ticket;
        int rowNumber;
        int seatNumber;

        // Maximum attempts to prevent infinite loop
        int attempts = 0;
        int maxAttempts = numberOfRows * numberOfSeatsInRow; 

        do {

            rowNumber = rand.nextInt(numberOfRows);
            seatNumber = rand.nextInt(numberOfSeatsInRow);
            ticket = venue.getTicketInSection(sectionNumber, rowNumber, seatNumber);
            attempts++;

            //if all tickets are booked
            if (attempts >= maxAttempts) {
                System.out.println("There are no available ticket left."); 
                System.exit(0);
            }
        
        } while (ticket.isBooked());

        
         
        return new Ticket(ticket);
    }
    

}
