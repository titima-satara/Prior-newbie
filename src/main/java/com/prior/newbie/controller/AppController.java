package com.prior.newbie.controller;

import com.prior.newbie.entities.People;
import com.prior.newbie.repository.EntityManagerCustomRepository;
import com.prior.newbie.repository.JdbcCustomRepository;
import com.prior.newbie.repository.NamedParameterCustomRepository;
import com.prior.newbie.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/people")
public class AppController {
    @Autowired
    private PeopleService peopleService;

    @Autowired
    private JdbcCustomRepository jdbcRepository;

    @Autowired
    private EntityManagerCustomRepository entityManagerCustomRepository;

    @Autowired
    private NamedParameterCustomRepository namedParameterCustomRepository;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //get people all

    //Repository
    @GetMapping(value = "/all_repo")
    public List<People> findAllRrpo() {
        return peopleService.findAll();
    }

    //jdbcTemplate
    @GetMapping(value = "/all_jdbc")
    public List<People> findAllJdbc() {
        return jdbcRepository.findAll();
    }

    //entityManager
    @GetMapping(value = "/all_entity_manager")
    public List<People> findAllEntityManager() {
        return entityManagerCustomRepository.findAll();
    }

    //namedParameterJdbcTemplate
    @GetMapping(value = "/all_named_parameter")
    public List<People> findAllNamedParameter() {
        return namedParameterCustomRepository.findAll();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //get people by cid

    //Repository
    @GetMapping(value = "/show_by_cid_repo/{cid}")
    public People findByIdRepo(@PathVariable String cid) {
        return peopleService.findById(cid);
    }

    //jdbcTemplate
    @GetMapping(value = "/show_by_cid_jdbc/{cid}")
    public People findByIdJdbc(@PathVariable String cid) {
        return jdbcRepository.findById(cid);
    }

    //entityManager
    @GetMapping(value = "/show_by_cid_entity_manager/{cid}")
    public People findByIdEntityManager(@PathVariable String cid) {
        return entityManagerCustomRepository.findById(cid);
    }

    //namedParameterJdbcTemplate
    @GetMapping(value = "/show_by_cid_named_parameter/{cid}")
    public People findByIdnNamedParameter(@PathVariable String cid) {
        return namedParameterCustomRepository.findById(cid);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //create people

    //Repository
    @PostMapping(value = "/create_repo")
    public String createPeople(@RequestBody People people){
        return peopleService.createPeople(people);
    }

    //jdbcTemplate
    @PostMapping(value = "/create_jdbc")
    public String createPeopleJdbc(@RequestBody People people) {
        return jdbcRepository.createPeople(people);
    }

    //entityManager
    @PostMapping(value = "/create_entity_manager")
    public String createPeopleEntityManager(@RequestBody People people) {
        return entityManagerCustomRepository.createPeople(people);
    }

    //namedParameterJdbcTemplate
    @PostMapping(value = "/create_named_parameter")
    public String createPeopleNamedParameter(@RequestBody People people) {
        return namedParameterCustomRepository.createPeople(people);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //update people

    //Repository
    @PutMapping(value = "/update_repo/{cid}")
    public String updatePeopleRrpo(@PathVariable("cid") String cid, @RequestBody People people){
        return peopleService.updatePeople(cid, people);
    }

    //jdbcTemplate
    @PutMapping(value = "/update_jdbc/{cid}")
    public String updatePeopleJdbcTemplate(@PathVariable("cid") String cid, @RequestBody People people){
        return jdbcRepository.updatePeople(cid, people);
    }

    //entityManager
    @PutMapping(value = "/update_entity_manager/{cid}")
    public String updatePeopleEntityManager(@PathVariable("cid") String cid, @RequestBody People people){
        return entityManagerCustomRepository.updatePeople(cid, people);
    }

    //namedParameterJdbcTemplate
    @PutMapping(value = "/update_named_parameter/{cid}")
    public String updatePeopleNamedParameterJdbcTemplate(@PathVariable("cid") String cid, @RequestBody People people){
        return namedParameterCustomRepository.updatePeople(cid, people);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //delete people ปรับ flag is_deleted = Y

    //Repository
    @DeleteMapping(value = "/delete_repo/{cid}")
    public String deletePeopleRepo(@PathVariable("cid") String cid){
        return peopleService.deletePeople(cid);
    }

    //jdbcTemplate
    @DeleteMapping(value = "/delete_jdbc/{cid}")
    public String deletePeopleJdbcTemplate(@PathVariable("cid") String cid){
        return jdbcRepository.deletePeople(cid);
    }

    //entityManager
    @DeleteMapping(value = "/delete_entity_manager/{cid}")
    public String deletePeopleEntityManager(@PathVariable("cid") String cid){
        return entityManagerCustomRepository.deletePeople(cid);
    }

    //namedParameterJdbcTemplate
    @DeleteMapping(value = "/delete_named_parameter/{cid}")
    public String deletePeople(@PathVariable("cid") String cid){
        return namedParameterCustomRepository.deletePeople(cid);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //delete people all

    //Repository
    @DeleteMapping(value = "/delete_all_repo/{cid}")
    public String deletePeopleAllCidRepo(@PathVariable("cid") String cid){
        return peopleService.deletePeopleAllCid(cid);
    }

    //jdbcTemplate
    @DeleteMapping(value = "/delete_all_jdbc/{cid}")
    public String deletePeopleAllCidJdbcTemplate(@PathVariable("cid") String cid){
        return jdbcRepository.deletePeopleAllCid(cid);
    }

    //entityManager
    @DeleteMapping(value = "/delete_all_entity_manager/{cid}")
    public String deletePeopleAllCidEntityManager(@PathVariable("cid") String cid){
        return entityManagerCustomRepository.deletePeopleAllCid(cid);
    }

    //namedParameterJdbcTemplate
    @DeleteMapping(value = "/delete_all_named_parameter/{cid}")
    public String deletePeopleAllCidNamedParameterJdbcTemplate(@PathVariable("cid") String cid){
        return namedParameterCustomRepository.deletePeopleAllCid(cid);
    }
}