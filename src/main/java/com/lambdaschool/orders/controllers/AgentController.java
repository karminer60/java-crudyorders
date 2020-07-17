package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController
{
    @Autowired
    private AgentServices agentServices;

    //http://localhost:2019/agents/agents
    @GetMapping(value = "/agents", produces = {"application/json"})
    public ResponseEntity<?> listAllMenus()
    {
        List<Agent> myAgents = agentServices.findAllAgents();
        return new ResponseEntity<>(myAgents, HttpStatus.OK);
    }

    //http://localhost:2019/agetns/agent/9
    @GetMapping(value = "/agent/{agentcode}")
    public ResponseEntity<?> findAgentById(@PathVariable long agentcode)
    {
        Agent a = agentServices.findById(agentcode);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }




}
