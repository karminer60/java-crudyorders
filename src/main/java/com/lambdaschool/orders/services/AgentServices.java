package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;

import java.util.List;

public interface AgentServices
{
    Agent save(Agent agent);

    List<Agent> findAllAgents();

    Agent findById(long id);
}
