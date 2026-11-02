package TicketBooking;

import java.util.Random;
public class VenueCreator {
    

    
    public Venue createEmptyVenue()
    {
        // Create a Venue object
        Venue venue = new Venue(4);

        Random rand = new Random();
        
        int[] boundaries = {3000,4000,5001};
        
        // add sections to the venue
        for (int sectionNumber = 0; sectionNumber < venue.getNumberOfSections(); sectionNumber++) {
            
            int boundaryIndex = 0;
            for(int boundary : boundaries){
                boundaries[boundaryIndex] = boundary - sectionNumber*500;
                boundaryIndex++;
            }
            
            // randomly generate max and min prices for given section
            int maxPrice = rand.nextInt(boundaries[1], boundaries[2]); 
            int minPrice = rand.nextInt(boundaries[0], boundaries[1]);
            
            //create a section object and add it to the venue
            Section section = new Section(sectionNumber, maxPrice, minPrice, 10, 60);
            section.createTicketsForSection();

            venue.addSection(section, sectionNumber);
        }
    
        return venue;
    }

}
