package com.prior.newbie.service;

import com.prior.newbie.entities.People;
import com.prior.newbie.repository.EntityManagerCustomRepository;
import com.prior.newbie.repository.JdbcCustomRepository;
import com.prior.newbie.repository.NamedParameterCustomRepository;
import com.prior.newbie.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private JdbcCustomRepository jdbcRepository;

    @Autowired
    private EntityManagerCustomRepository entityManagerCustomRepository;

    @Autowired
    private NamedParameterCustomRepository namedParameterCustomRepository;

    public List<People> findAll() {
        System.out.println("######## People Service ########");

        /*
        System.out.println("######## get people all ########");
        return peopleRepository.findAll();
        */

        //jdbc
        //return jdbcRepository.findAll();

        //entityManager
        //return entityManagerCustomRepository.findAll();

        //namedParameterJdbcTemplate
        return namedParameterCustomRepository.findAll();
    }
    public People findById(String cid) {
        System.out.println("######## People Service ########");

        /*
        System.out.println("######## get people by cid ########");
        Optional<People> user = peopleRepository.findById(cid);
        return user.get();
        */

        //jdbc
        //return jdbcRepository.findByCid(cid);

        //entity manager
        //return entityManagerCustomRepository.findById(cid);

        //namedParameterJdbcTemplate
        return namedParameterCustomRepository.findById(cid);
    }

    public String createPeople(People people) {
        System.out.println("######## People Service ########");

        /*
        System.out.println("######## create people ########");
        peopleRepository.save(people);
        return "create succeed";
        */

        //jdbc
        //return jdbcRepository.createPeople(people);

        //entity manager
        //return entityManagerCustomRepository.createPeople(people);

        //namedParameterJdbcTemplate
        return namedParameterCustomRepository.createPeople(people);
    }

    public String updatePeople(String cid, People people) {
        System.out.println("######## People Service ########");

        /*
        System.out.println("######## update people ########");
        people.setCid(cid);
        peopleRepository.save(people);
        return "update succeed";
        */

        //jdbc
        //return jdbcRepository.updatePeople(cid, people);

        //entity manager
        //return entityManagerCustomRepository.updatePeople(cid, people);

        //namedParameterJdbcTemplate
        return namedParameterCustomRepository.updatePeople(cid,people);
    }

    public String deletePeople(String cid) {
        System.out.println("######## People Service ########");

        /*
        System.out.println("######## delete people ########");
        People user = peopleRepository.findById(cid).get();
        user.setIs_deleted("Y");
        peopleRepository.save(user);
        return "delete succeed";
        */

        //jdbc
        //return jdbcRepository.deletePeople(cid);

        //entity manager
        //return entityManagerCustomRepository.deletePeople(cid);

        //namedParameterJdbcTemplate
        return namedParameterCustomRepository.deletePeople(cid);
    }

    public String deletePeopleAllCid(String cid) {
        System.out.println("######## People Service ########");

        /*
        System.out.println("######## delete all people ########");
        peopleRepository.deleteById(cid);
        return "delete all succeed";
        */

        //jdbc
        //return jdbcRepository.deletePeopleAllCid(cid);

        //entity manager
        //return entityManagerCustomRepository.deletePeopleAllCid(cid);

        //namedParameterJdbcTemplate
        return namedParameterCustomRepository.deletePeopleAllCid(cid);
    }
}