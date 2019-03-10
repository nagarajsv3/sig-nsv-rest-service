package com.nsv.jsmbaba.domain;

import com.nsv.jsmbaba.annotation.DateRangeValid;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.*;

@Slf4j
@Getter
@Setter
@ToString
@Entity
@Table(name="Person")
//@DateRangeValid(message = "StartDate/EndDate Either both should be present or both should be absent")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Custom message-Please Enter Your Name. It cant be null")
    @NotEmpty(message = "Custom message-Please Enter Your Name. It cant be Empty")
    @Size(min=3, max=8, message = "Custom message-Please Enter Your Name >2 & <8")
    @Column(name="name")
    private String name;

    @Column(name="startdate")
    private String startDate;

    @Column(name="enddate")
    private String endDate;


    //@NotNull(message = "Custom message-Please Enter Your Name. It cant be null")
    @Size(min=3, max=8, message = "Custom message-Please Enter Your Last Name >1 & <10")
    @Column(name="lastname")
    private String lastName;

    @NotNull
    @Min(value = 18,message = "Custom message-Please Input Your Age > 18 ")
    @Column(name="age")
    private int age;
}
