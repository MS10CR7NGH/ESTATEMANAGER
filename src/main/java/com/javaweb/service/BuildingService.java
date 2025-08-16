package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface BuildingService {
    List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest);
    BuildingDTO addOrUpdateBuilding(BuildingDTO buildingDTO);
    BuildingDTO getBuildingById(Long id);
    void delteBuilding(List<Long> ids);
    ResponseDTO getAllStaffs(Long buildingId);
    void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
}
