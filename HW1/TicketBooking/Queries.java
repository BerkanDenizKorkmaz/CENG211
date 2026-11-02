package TicketBooking;

public class Queries
{   
    private Venue venue;
    private Customer[] customers;

    public Queries()
    {
        TicketBookingManagement ticketBookingManagement = new TicketBookingManagement();
        ticketBookingManagement.ManageTicketBooking();
        
        venue = ticketBookingManagement.getProcessedVenue();
        customers = ticketBookingManagement.getProcessedCustomers();        
    }


    public int calculateRevenueForSection(int sectionNumber) 
    {
        Ticket[][] tickets = venue.getTicketsInSection(sectionNumber);
        int revenue = 0;

        for (Ticket[] row : tickets) {
            for (Ticket ticket : row) {
                if (ticket.isBooked()) {
                    revenue += ticket.getPrice();
                }
            }
        }
        return revenue;
    }


    public String getHighestRevenueSection()
    {
        Section highestRevenueSection = null;
        int highestRevenue = 0;

        for (Section section : venue.getSections()) {
            int revenue = calculateRevenueForSection(section.getSectionNumber());
            if (revenue > highestRevenue) {
                highestRevenue = revenue;
                highestRevenueSection = section;
            }
        }

        return highestRevenueSection + "Section Revenue: " + highestRevenue;
    }


    public int getTotalRevenue() {
        int totalRevenue = 0;
    
        for (Section section : venue.getSections()) {
            totalRevenue += calculateRevenueForSection(section.getSectionNumber());
        }
        
        return totalRevenue;
    }
    

    public double getOccupancyRate() {
        int totalSeats = 0;
        int bookedSeats = 0;
    
        for (Section section : venue.getSections()) {
            Ticket[][] tickets = section.getTicketsInSection2DArray();
            for (Ticket[] row : tickets) {
                totalSeats += row.length;
                for (Ticket ticket : row) {
                    if (ticket.isBooked()) {
                        bookedSeats++;
                    }
                }
            }
        }
        
        // Prevent division by zero
        if (totalSeats == 0) {
            return 0;
        }

        return (double) Math.round((double) bookedSeats / totalSeats * 100 * 100) / 100;
    }
    

    public Customer getHighestPricedCustomer() {
        Customer highestPricedCustomer = null;
        int highestTotalPrice = 0;
    
        for (Customer customer : customers) {
            int customerTotalPrice = 0;
            for (Ticket ticket : customer.getBookedTickets()) {
                customerTotalPrice += ticket.getPrice();
            }
            if (customerTotalPrice > highestTotalPrice) {
                highestTotalPrice = customerTotalPrice;
                highestPricedCustomer = customer;
            }
        }
    
        return highestPricedCustomer;
    }
    

    public void printHighestPayingCustomerTickets() {
    Customer highestPricedCustomer = getHighestPricedCustomer();

    if (highestPricedCustomer != null) {
        System.out.println("Highest paying customer: " + highestPricedCustomer.getName());

        System.out.println(highestPricedCustomer.getName() + "'s Booked Tickets:");
        for (Ticket ticket : highestPricedCustomer.getBookedTickets())
        {
            System.out.println(ticket);
        }
    }
    else {
        System.out.println("No customers have booked any tickets.");
    }
}

    public void displaySectionOccupancies() {   
        for (int sectionNumber = 0; sectionNumber< venue.getNumberOfSections(); sectionNumber++) {
            
            System.out.println("Seat occupancy in Section " + sectionNumber + ":");
            Ticket[][] ticketsInSection = venue.getTicketsInSection(sectionNumber);

            for (Ticket[] row : ticketsInSection) {
                for (Ticket ticket : row) {
                
                    if (ticket.isBooked()) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public Ticket getMostExpensiveTicket() {
        Ticket mostExpensiveTicket = null;
        int highestPrice = 0;
    
        for (Section section : venue.getSections()) {
            Ticket[][] tickets = section.getTicketsInSection2DArray();
            for (Ticket[] row : tickets) {
                for (Ticket ticket : row) {
                    if (ticket.getPrice() > highestPrice) {
                        highestPrice = ticket.getPrice();
                        mostExpensiveTicket = ticket;
                    }
                }
            }
        }
    
        return mostExpensiveTicket;
    }
    
    public void printQueryResults() {

        System.out.println("Highest Revenue Section: " + getHighestRevenueSection() + "$");
        System.out.println();
        displaySectionOccupancies();
        System.out.println();
        System.out.println("Total Revenue: " + getTotalRevenue() + "$");
        System.out.println();
        System.out.println("Occupancy Rate: " + getOccupancyRate() + "%");
        System.out.println();
        printHighestPayingCustomerTickets();        
        System.out.println();
        System.out.println("Most Expensive Ticket: " + getMostExpensiveTicket());

    }

}
