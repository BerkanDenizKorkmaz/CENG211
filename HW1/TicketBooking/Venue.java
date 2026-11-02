package TicketBooking;

import java.util.Arrays;

public class Venue
{
    private int numberOfSections;
    // A one-dimensional array of Section objects
    private Section[] sections;

    public Venue(int numberOfSections)// change this part depending on the future actions
    {
        this.numberOfSections = numberOfSections;
        this.sections = new Section[numberOfSections];
        
    }

    // Copy constructor
    public Venue(Venue anotherVenue)
    {
        this.numberOfSections = anotherVenue.getNumberOfSections();
        this.sections = new Section[anotherVenue.getNumberOfSections()];
        
        for (int i = 0; i < anotherVenue.getNumberOfSections(); i++) {
            this.sections[i] = new Section(anotherVenue.getSections()[i]);
        }
    }
    
    public void setNumberOfSections(int numberOfSections)
    {
        this.numberOfSections = numberOfSections;
    }

    public int getNumberOfSections()
    {
        return numberOfSections;
    }
    
    public void addSection(Section section, int index)
    {
        if (index < 0 || index >= numberOfSections)
        {
            System.out.println("Invalid index");
            System.exit(0);
        } else{
            sections[index] = section;
        }
        
    }
    
    public Section[] getSections()
    {
        Section[] newSections = new Section[sections.length];
        
        for (int i = 0; i < sections.length; i++) {
            newSections[i] = new Section(sections[i]); 
        }
        return newSections;
    }

    public Ticket getTicketInSection(int sectionNumber, int rowNumber, int seatNumber) {
        
        if (sectionNumber < 0 || sectionNumber >= numberOfSections) {
            System.out.println("Invalid section number");
            System.exit(0);
        }

        Section section = sections[sectionNumber];
        Ticket[][] ticketsInSection = section.getTicketsInSection2DArray();
        
        if (rowNumber < 0 || rowNumber >= ticketsInSection.length || seatNumber < 0 || seatNumber >= ticketsInSection[rowNumber].length) {
            System.err.println("Invalid row or seat number");
            System.exit(0);
        }

        // Returning a copy of the ticket object
        return new Ticket(ticketsInSection[rowNumber][seatNumber]);
    }
    
    // return 2d array of tickets for specified section
    public Ticket[][] getTicketsInSection(int sectionNumber) {
        if (sectionNumber < 0 || sectionNumber >= numberOfSections) {
            System.out.println("Invalid section number");
            System.exit(0);
        }

        Section section = sections[sectionNumber];
        return section.getTicketsInSection2DArray();
    }

    public void reserveTicketInVenue(int sectionNumber, int rowNumber, int seatNumber) {
        Ticket ticket = getTicketInSection(sectionNumber, rowNumber, seatNumber);
        ticket.setBookingStatus(true);
        sections[sectionNumber].setTicket(ticket);
    
    }

    // toString
    @Override
    public String toString() {
        return "Venue [numberOfSections=" + numberOfSections + ", sections=" + Arrays.toString(sections) + "]";
    }
    
}
