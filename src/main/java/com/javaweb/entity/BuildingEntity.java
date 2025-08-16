package com.javaweb.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "building")
public class BuildingEntity {
    @Id //khoa chinh
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto tu dong tang dan
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "street")
    private String street;

    @Column (name = "ward")
    private String ward;

    @Column (name = "district")
    private String district;

    @Column (name = "structure")
    private String structure;

    @Column (name = "numberofbasement")
    private Long numberOfBasement;

    @Column (name = "floorarea")
    private Long floorArea;

    @Column (name = "direction")
    private String direction;

    @Column (name = "level")
    private Long level;

    @Column (name = "rentprice")
    private Long rentPrice;

    @Column (name = "rentpricedescription")
    private String rentPriceDescription;

    @Column (name = "servicefee")
    private Long serviceFee;

    @Column (name = "carfee")
    private Long carFee;

    @Column (name = "motofee")
    private Long motoFee;

    @Column (name = "overtimefee")
    private Long overtimeFee;

    @Column (name = "waterfee")
    private Long waterfee;

    @Column (name = "electricityfee")
    private Long electricityfee;

    @Column (name = "payment")
    private Long payment;

    @Column (name = "renttime")
    private Long rentTime;

    @Column (name = "deposit")
    private Long deposit;

    @Column (name = "decorationtime")
    private Long decorationTime;

    @Column (name = "managername")
    private String managername;

    @Column (name = "managerphone")
    private Long managerphone;

    @Column (name = "type")
    private String type;

    @Column (name = "brokeragefee")
    private Long brokerageFee;

    @Column (name = "note")
    private String note;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<RentAreaEntity> rentAreas = new ArrayList<RentAreaEntity>();

//    @ManyToMany(mappedBy = "buildings", fetch = FetchType.LAZY)
//    private List<UserEntity> users = new ArrayList<UserEntity>();

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private List<AssignmentBuildingEntity> assignmentBuildingEntitiesBuilding = new ArrayList<AssignmentBuildingEntity>();


}
