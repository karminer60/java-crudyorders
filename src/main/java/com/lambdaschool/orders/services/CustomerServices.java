package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.views.Orders;

import java.util.List;

public interface CustomerServices
{
    Customer save(Customer customer);

    List<Customer> findAllCustomers();

    Customer findById(long id);

    List<Customer> findByNameLike(String subname);

    List<Orders> getOrders();

    void delete(long custcode)

}
