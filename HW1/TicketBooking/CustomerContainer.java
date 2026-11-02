package TicketBooking;

import java.util.Arrays;

public class CustomerContainer {
    private Customer[] customers;

    public CustomerContainer()
    {
    }

    public Customer[] getCustomers()
    {
        Customer[] newCustomers = new Customer[customers.length];
        
        for (int i = 0; i < customers.length; i++) {
            newCustomers[i] = new Customer(customers[i]); 
        }
        return newCustomers;
    }

    public void addCustomer(Customer customer)
    {
        if (customers == null)
        {
            customers = new Customer[1];
            customers[0] = customer;
        }
        else
        {
            Customer[] temp = Arrays.copyOf(customers, customers.length + 1);
            temp[temp.length - 1] = customer;
            customers = temp;
        }
    }
}
