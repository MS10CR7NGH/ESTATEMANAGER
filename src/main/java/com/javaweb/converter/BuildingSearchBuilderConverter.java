package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest buildingSearchRequest) {
        return BuildingSearchBuilder.builder()
                .name(buildingSearchRequest.getName())
                .floorArea(buildingSearchRequest.getFloorArea())
                .ward(buildingSearchRequest.getWard())
                .street(buildingSearchRequest.getStreet())
                .district(buildingSearchRequest.getDistrict())
                .numberOfBasement(buildingSearchRequest.getNumberOfBasement())
                .managerName(buildingSearchRequest.getManagerName())
                .managerPhoneName(buildingSearchRequest.getManagerPhone())
                .rentAreaFrom(buildingSearchRequest.getAreaFrom())
                .rentAreaTo(buildingSearchRequest.getAreaTo())
                .rentPriceFrom(buildingSearchRequest.getRentPriceFrom())
                .rentPriceTo(buildingSearchRequest.getRentPriceTo())
                .staffId(buildingSearchRequest.getStaffId())
                .typeCode(buildingSearchRequest.getTypeCode())
                .build();
    }
}
