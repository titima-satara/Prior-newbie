package com.prior.newbie.controller;

import com.prior.newbie.entities.People;
import com.prior.newbie.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/people")
public class AppController {
    @Autowired
    private PeopleService peopleService;

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }

    //get people all
    @GetMapping(value = "/all")
    public List<People> findAll() {
        return peopleService.findAll();
    }

    //get people by cid
    @GetMapping(value = "/{cid}")
    public People findById(@PathVariable String cid) {
        return peopleService.findById(cid);
    }

    //create people
    @PostMapping(value = "/create")
    public String createPeople(@RequestBody People people){
        return peopleService.createPeople(people);
    }

    //update people
    @PutMapping(value = "/update/{cid}")
    public String updatePeople(@PathVariable("cid") String cid, @RequestBody People people){
        return peopleService.updatePeople(cid, people);
    }

    //delete people ปรับ flag is_deleted = Y
    @DeleteMapping(value = "/delete/{cid}")
    public String deletePeople(@PathVariable("cid") String cid){
        return peopleService.deletePeople(cid);
    }

    //delete people all
    @DeleteMapping(value = "/delete_all/{cid}")
    public String deletePeopleAllCid(@PathVariable("cid") String cid){
        return peopleService.deletePeopleAllCid(cid);
    }
}