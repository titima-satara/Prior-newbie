package com.prior.newbie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Getter
@Setter
@Table(name = "color")
public class Color {
    @Id
    public String color_code;
    public String color_name;
    public String decimal_code;
}
