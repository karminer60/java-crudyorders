package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "agentService")
public class AgentServiceImpl implements AgentServices
{
    @Autowired
    private AgentRepository agentrepos;

    @Transactional
    @Override
    public Agent save(Agent agent) {
        return agentrepos.save(agent);
    }

    @Override
    public List<Agent> findAllAgents()
    {
        List<Agent> list = new ArrayList<>();

        agentrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Agent findById(long id)
    {

        return  agentrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + id +" does not exist"));


    }
}
