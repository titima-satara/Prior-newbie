package com.prior.newbie.repository;

import com.prior.newbie.entities.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class NamedParameterCustomRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<People> findAll() {
        System.out.println("######## get people all namedParameterJdbcTemplate ########");
        String sql = "SELECT * FROM PEOPLE";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(People.class));
    }

    public People findById(String cid) {
        System.out.println("######## get people by cid namedParameterJdbcTemplate ########");
        String sql = "SELECT * FROM PEOPLE WHERE cid = :cid";
        return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("cid", cid), new BeanPropertyRowMapper<>(People.class));
    }


    public String createPeople(People people) {
        System.out.println("######## create people namedParameterJdbcTemplate ########");
        String sql = "INSERT INTO PEOPLE (CID, TITLE, FIRSTNAME, LASTNAME, MIDDLE_NAME, MOBILE, GENDER, BIRTH_DATE, IS_DELETED, CREATED_BY, CREATED_DATE, UPDATE_BY, UPDATE_DATE)" +
                     "VALUES (:cid, :title, :firstname, :lastname, :middle_name, :mobile, :gender, :birth_date, :is_deleted, :created_by, :created_date, :update_by, :update_date)";
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(people));
        return "create succeed";
    }

    public String updatePeople(String cid, People people) {
        System.out.println("######## update people namedParameterJdbcTemplate ########");
        String sql = "UPDATE PEOPLE " +
                     "SET TITLE = :title, FIRSTNAME = :firstname, LASTNAME = :lastname, MIDDLE_NAME = :middle_name, MOBILE = :mobile, GENDER = :gender, BIRTH_DATE = :birth_date, IS_DELETED = :is_deleted, CREATED_BY = :created_by, CREATED_DATE = :created_date, UPDATE_BY = :update_by, UPDATE_DATE = :update_date " +
                     "WHERE cid = :cid";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("cid", cid).addValue("title", people.getTitle())
                .addValue("firstname", people.getFirstname()).addValue("lastname", people.getLastname())
                .addValue("middle_name", people.getMiddle_name()).addValue("mobile", people.getMobile())
                .addValue("gender", people.getGender()).addValue("birth_date", people.getBirth_date())
                .addValue("is_deleted", people.getIs_deleted()).addValue("created_by",people.getCreated_by())
                .addValue("created_date", people.getCreated_date()).addValue("update_by", people.getUpdate_by())
                .addValue("update_date",people.getUpdate_date()));
        return "update succeed";
    }

    public String deletePeople(String cid) {
        System.out.println("######## delete people namedParameterJdbcTemplate ########");
        String sql = "UPDATE PEOPLE SET IS_DELETED = 'Y' WHERE cid = :cid";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource( "cid", cid));
        return "delete succeed";
    }

    public String deletePeopleAllCid(String cid) {
        System.out.println("######## delete all namedParameterJdbcTemplate ########");
        String sql = "DELETE FROM PEOPLE WHERE cid = :cid";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("cid", String.valueOf(cid)));
        return "delete all succeed";
    }
}
