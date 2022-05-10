package com.prior.newbie.repository;

import com.prior.newbie.entities.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Slf4j
public class EntityManagerCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<People> findAll() {
        System.out.println("######## get people all entity manager ########");
        String jpql = "SELECT p FROM People p";
        TypedQuery<People> query = entityManager.createQuery(jpql, People.class);
        return query.getResultList();
    }

    @Transactional
    public People findById(String cid) {
        System.out.println("######## get people by cid entity manager ########");
        return entityManager.find(People.class, cid);
    }

    @Transactional
    public String createPeople(People people) {
        System.out.println("######## create people entity manager ########");
        entityManager.persist(people);
        return "create succeed";
    }

    @Transactional
    public String updatePeople(String cid, People people) {
        System.out.println("######## update people entity manager ########");
        entityManager.merge(entityManager.find(People.class, cid));
        return "update succeed";
    }

    @Transactional
    public String deletePeople(String cid) {
        System.out.println("######## delete people entity manager ########");
        People p = entityManager.find(People.class, cid);
        p.setIs_deleted("Y");
        return "delete succeed";
    }

    @Transactional
    public String deletePeopleAllCid(String cid) {
        System.out.println("######## delete all entity manager ########");
        entityManager.remove(entityManager.find(People.class, cid));
        return "delete all succeed";
    }
}
