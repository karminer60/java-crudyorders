package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.models.Order;

import java.util.*;

public interface OrderServices
{
    List<Order> findAllOrders();

    Order findById(long id);

}
