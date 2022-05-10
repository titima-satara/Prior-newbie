package com.prior.newbie.entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter

@Data

@Entity
@Table(name = "people")
public class People {
    @Id
    public String cid;
    public String title;
    public String firstname;
    public String lastname;
    public String middle_name;
    public String mobile;
    public String gender;
    public String birth_date;
    public String is_deleted;
    public String created_by;
    public String created_date;
    public String update_date;
    public String update_by;

    public  People(){

    }

    public People(String cid, String title, String firstname, String lastname, String middle_name, String mobile,
                  String gender, String birth_date, String is_deleted, String created_by, String created_date,
                  String update_by, String update_date){
        this.cid = cid;
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middle_name = middle_name;
        this.mobile = mobile;
        this.gender = gender;
        this.birth_date = birth_date;
        this.is_deleted = is_deleted;
        this.created_by = created_by;
        this.created_date = created_date;
        this.update_by = update_by;
        this.update_date = update_date;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_By(String update_By) {
        this.update_by = update_By;
    }
}