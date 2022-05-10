package com.prior.newbie.service;

import com.prior.newbie.entities.People;
import com.prior.newbie.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> findAll() {
        System.out.println("######## People Service get people all ########");
        return peopleRepository.findAll();
    }
    public People findById(String cid) {
        System.out.println("######## People Service get people by cid ########");
        Optional<People> user = peopleRepository.findById(cid);
        return user.get();
    }

    public String createPeople(People people) {
        System.out.println("######## People Service create people ########");
        peopleRepository.save(people);
        return "create succeed";
    }

    public String updatePeople(String cid, People people) {
        System.out.println("######## People Service update people ########");
        people.setCid(cid);
        peopleRepository.save(people);
        return "update succeed";
    }

    public String deletePeople(String cid) {
        System.out.println("######## People Service delete people ########");
        People user = peopleRepository.findById(cid).get();
        user.setIs_deleted("Y");
        peopleRepository.save(user);
        return "delete succeed";
    }

    public String deletePeopleAllCid(String cid) {
        System.out.println("######## People Service delete all people ########");
        peopleRepository.deleteById(cid);
        return "delete all succeed";
    }
}