package com.mbolatov.jsoncurrenciessavedb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name ="tbl_currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    private String name_kaz;
    private String name_rus;
    private String codename;
    private String unit;
    private String ratio;
    private String rate;


    public Currency(){

    }
}