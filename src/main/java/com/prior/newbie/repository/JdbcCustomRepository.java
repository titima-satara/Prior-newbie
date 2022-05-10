
package com.prior.newbie.repository;

import com.prior.newbie.entities.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Slf4j
public class JdbcCustomRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<People> findAll(){
        System.out.println("######## get people all jdbcTemplate ########");
        String sql = "SELECT * FROM people";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(People.class));
    }

    public People findById(String cid) {
        System.out.println("######## get people by cid jdbcTemplate ########");
        String sql = "SELECT CID, TITLE, FIRSTNAME, LASTNAME, MIDDLE_NAME, MOBILE, GENDER, BIRTH_DATE, IS_DELETED, CREATED_BY, CREATED_DATE, UPDATE_BY, UPDATE_DATE " +
                     "FROM PEOPLE " +
                     "WHERE CID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cid}, new BeanPropertyRowMapper<>(People.class));
    }

    //create information in table people
    public String createPeople(People people){
        System.out.println("######## create people jdbcTemplate ########");
        String sql = "INSERT INTO PEOPLE (CID, TITLE, FIRSTNAME, LASTNAME, MIDDLE_NAME, MOBILE, GENDER, BIRTH_DATE, IS_DELETED, CREATED_BY, CREATED_DATE, UPDATE_BY, UPDATE_DATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, people.getCid(), people.getTitle(), people.getFirstname(), people.getLastname(),
                people.getMiddle_name(), people.getMobile(), people.getGender(), people.getBirth_date(), people.getIs_deleted(),
                people.getCreated_by(), people.getCreated_date(), people.getUpdate_by(),people.getUpdate_date());
        return "create succeed";
    }

    //update people
    public String updatePeople(String cid, People people) {
        System.out.println("######## update people jdbcTemplate ########");
        String sql = "UPDATE PEOPLE SET TITLE = ?, FIRSTNAME = ?, LASTNAME = ?, MIDDLE_NAME = ?, MOBILE = ?, GENDER = ?, BIRTH_DATE = ?, IS_DELETED = ?, CREATED_BY = ?, CREATED_DATE = ?, UPDATE_BY = ?, UPDATE_DATE = ? " +
                     "WHERE CID = ?";
        jdbcTemplate.update(sql, people.getTitle(), people.getFirstname(), people.getLastname(),
                people.getMiddle_name(), people.getMobile(), people.getGender(), people.getBirth_date(), people.getIs_deleted(),
                people.getCreated_by(), people.getCreated_date(), people.getUpdate_by(),people.getUpdate_date(),cid);
        return "update succeed";
    }

    //delete people
    public String deletePeople(String cid) {
        System.out.println("######## delete people jdbcTemplate ########");
        String sql = "UPDATE PEOPLE SET IS_DELETED = 'Y' WHERE CID = ?";
        jdbcTemplate.update(sql,cid);
        return "delete succeed";
    }

    //delete people all
    public String deletePeopleAllCid(String cid) {
        System.out.println("######## delete all jdbcTemplate ########");
        String sql = "DELETE FROM PEOPLE WHERE CID = ?";
        jdbcTemplate.update(sql,cid);
        return "delete all succeed";
    }
}