package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.views.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long>
{
    Customer findByCustnameIgnoringCase(String custname);

    @Query(value = "Select c.custname as name, o.ordnum as orders FROM customers c LEFT JOIN orders o ON c.custcode = o.custcode", nativeQuery = true)
    List<Orders> getOrders();

    List<Customer> findByCustnameContainingIgnoringCase(String subname);
}


