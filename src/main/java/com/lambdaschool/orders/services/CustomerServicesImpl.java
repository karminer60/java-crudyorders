package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomerRepository;
import com.lambdaschool.orders.views.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServicesImpl implements CustomerServices {
    @Autowired
    private CustomerRepository customerrepos;

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();
        if(customer.getCustcode() ! = 0)
        {
            customerrepos.findById(customer.getCustcode())
                    .orElseThrow(() -> new EntityNotFoundException("Restaurant " + customer.getCustcode() + " Not Found"));


            newCustomer.setCustcode(customer.getCustcode());
        }
        return customerrepos.save(newCustomer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();
        customerrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findById(long id) {
        Customer c = new Customer();

        return customerrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " does not exist"));


    }

    @Override
    public List<Customer> findByNameLike(String subname) {
        return customerrepos.findByCustnameContainingIgnoringCase(subname);
    }

    @Override
    public List<Orders> getOrders() {
        return customerrepos.getOrders();
    }

    @Override
    public void delete(long custcode) {
        customerrepos.findById(custcode)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant " + custcode + " not Found!");
        customerrepos.deleteById(custcode);
    }
}
