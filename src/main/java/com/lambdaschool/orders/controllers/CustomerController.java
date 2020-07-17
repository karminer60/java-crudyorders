package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerServices;
import com.lambdaschool.orders.views.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomerServices customerServices;

    //http://localhost:2019/customers/customers
    @GetMapping(value = "/customers", produces = "application/json")
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myList = customerServices.findAllCustomers();
        return new ResponseEntity<>(myList, HttpStatus.OK);

    }

    //http://localhost:2019/customers/customer/3
    @GetMapping(value = "customer/{custcode}", produces = "application/json")
    public ResponseEntity<?> findCustomersById(@PathVariable long custcode )
    {
        Customer c = customerServices.findById(custcode);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //http://localhost:2019/customers/namelike/mes
    @GetMapping(value =  "/namelike/{subname}", produces = "application/json")
    public ResponseEntity<?> findByNameLike(@PathVariable String subname)
    {
        List<Customer> myList = customerServices.findByNameLike(subname);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //http://localhost2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> findOrders()
    {
        //name, orders
        List<Orders> myList = customerServices.getOrders();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    //Delete http://localhost:2019/customers/customer/54
    @DeleteMapping(value = "/customer/{custcode}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable long custcode)
    {
        customerServices.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
