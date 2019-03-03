package com.nsv.jsmbaba.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Slf4j
@Getter
@Setter
@ToString
@Entity
@Table(name="Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Custom message-Please Enter Your Name. It cant be null")
    @Size(min=3, max=8, message = "Custom message-Please Enter Your Name >2 & <8")
    @Column(name="name")
    private String name;

    @NotNull
    @Min(value = 18,message = "Custom message-Please Input Your Age > 18 ")
    @Column(name="age")
    private int age;
}
