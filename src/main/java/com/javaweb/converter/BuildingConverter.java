package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.enums.districtCode;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.utils.DistrictCode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchResponse toBuildingSearchResponse(BuildingEntity item){
        BuildingSearchResponse dto = modelMapper.map(item, BuildingSearchResponse.class);
        Map<String, String> districts = districtCode.type();
        dto.setAddress(item.getStreet() +", "+ item.getWard() +", "+ districts.get(item.getDistrict()));
        dto.setRentArea(item.getRentAreas().stream().map(it-> it.getValue().toString()).collect(Collectors.joining(", ")));
        return dto;
    }

}
