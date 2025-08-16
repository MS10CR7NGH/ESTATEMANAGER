package com.javaweb.builder;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Builder
public class BuildingSearchBuilder {
    private String name;
    private Long floorArea;
    private String ward;
    private String street;
    private String district;
    private Long numberOfBasement;
    private List<String> typeCode;
    private String managerName;
    private String managerPhoneName;
    private Long rentPriceFrom;
    private Long rentPriceTo;
    private Long rentAreaFrom;
    private Long rentAreaTo;
    private Long staffId;
}


