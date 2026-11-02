package TicketBooking;

import java.util.Arrays;

public class Customer {
    
    private String name;
    private int numberOfTickets;
    // A one-dimensional array that holds Ticket objects
    private Ticket[] bookedTickets;

    public Customer(String name, int numberOfTickets)
    {
        this.name = name;
        this.numberOfTickets = numberOfTickets;
        this.bookedTickets = new Ticket[numberOfTickets];
    }

    // Copy constructor
    public Customer(Customer anotherCustomer)
    {
        name = anotherCustomer.getName();
        numberOfTickets = anotherCustomer.getNumberOfTickets();
        bookedTickets = new Ticket[anotherCustomer.getNumberOfTickets()];

        for (int i = 0; i < anotherCustomer.getNumberOfTickets(); i++) {
            bookedTickets[i] = new Ticket(anotherCustomer.getBookedTickets()[i]);
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setNumberOfTickets(int numberOfTickets)
    {
        this.numberOfTickets = numberOfTickets;
    }

    public int getNumberOfTickets()
    {
        return numberOfTickets;
    }

    public void bookTicket(Ticket ticket,int index)
    {   
        if(index >= numberOfTickets)
        {
            System.err.println("Amount of tickets was exceeded");
            System.exit(0);
        } else
        {
            bookedTickets[index] = ticket;
            ticket.setBookingStatus(true);
            
        }
    }
    
    public Ticket[] getBookedTickets()
    {
        Ticket[] newTickets = new Ticket[bookedTickets.length];
        
        for (int i = 0; i < bookedTickets.length; i++) {
            newTickets[i] = new Ticket(bookedTickets[i]);
        }
        return newTickets;
    }

    @Override
    public String toString() {
        return "Customer [bookedTickets=" + Arrays.toString(bookedTickets) + ", name=" + name + ", numberOfTickets="
                + numberOfTickets + "]";
    }

    

}
    

