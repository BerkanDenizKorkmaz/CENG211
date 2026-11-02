package TicketBooking;

import FileInput.FileIO;
import java.util.Random;

public class TicketBookingManagement
{
    private Venue venue;
    private CustomerContainer customerContainer;

    public TicketBookingManagement()
    {
    }

    public void ManageTicketBooking()
    {   
        VenueCreator venueCreator = new VenueCreator();
        RandomTicketGenerator randomTicketGenerator = new RandomTicketGenerator();
        Random rand = new Random();
        
        customerContainer = new CustomerContainer();
        venue = venueCreator.createEmptyVenue();
        
       

        String[][] customerData = getCustomerTicketInfoArray();
        for (String[] customerTicketInfo : customerData)
        {
            if (customerTicketInfo.length != 2)
            {
                System.err.println("Invalid customer ticket info");
                System.exit(0);
            }
            if (customerTicketInfo[0] != null && customerTicketInfo[1] != null)
            {
                String customerName = customerTicketInfo[0];
                int numberOfTickets = Integer.parseInt(customerTicketInfo[1]);
                
                Customer customer = new Customer(customerName, numberOfTickets);
            
                int sectionNumber = rand.nextInt(0, venue.getNumberOfSections());

                for (int j = 0; j < customer.getNumberOfTickets(); j++) 
                {
                    Ticket ticket = randomTicketGenerator.generateRandomTicketInSection(venue, sectionNumber);
                    customer.bookTicket(ticket, j);
                    venue.reserveTicketInVenue(sectionNumber, ticket.getRowNumber(), ticket.getSeatNumber());
                }
                
                customerContainer.addCustomer(customer);
            }
            
        }
    }

    public String[][] getCustomerTicketInfoArray()
    {
        FileIO fileIO = new FileIO();
        return fileIO.readCustomerTicketsInfoInto2DArray();
    }
        
    public Venue getProcessedVenue()
    {
        return new Venue(venue);
    }
 
    public Customer[] getProcessedCustomers()
    {
        
        return customerContainer.getCustomers();
    }

    
    
}