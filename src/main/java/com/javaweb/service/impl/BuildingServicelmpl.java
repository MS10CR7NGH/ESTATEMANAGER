package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import com.javaweb.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServicelmpl implements BuildingService {
    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private BuildingConverter buildingConverter;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RentAreaService rentAreaService;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Override
    public List<BuildingSearchResponse> searchBuilding(BuildingSearchRequest buildingSearchRequest) {
        BuildingSearchBuilder builder = buildingSearchBuilderConverter.toBuildingSearchBuilder(buildingSearchRequest);
        List<BuildingEntity> buildingRepositories = buildingRepository.findAll(builder);
        List<BuildingSearchResponse> results = new ArrayList<BuildingSearchResponse>();
        for (BuildingEntity item : buildingRepositories) {
            BuildingSearchResponse dto = buildingConverter.toBuildingSearchResponse(item);
            results.add(dto);
        }

        return results;
    }

    @Override
    public BuildingDTO addOrUpdateBuilding(BuildingDTO buildingDTO) {
        BuildingEntity toBuildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
        toBuildingEntity.setType(String.join(",", buildingDTO.getTypeCode()));
        BuildingEntity savedBuildingEntity = buildingRepository.save(toBuildingEntity);
        buildingDTO.setId(savedBuildingEntity.getId());
        if (StringUtils.check(buildingDTO.getRentArea())){
            rentAreaService.addRentArea(buildingDTO);
        }

        return buildingDTO;
    }



    @Override
    public BuildingDTO getBuildingById(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();
        BuildingDTO dto = modelMapper.map(buildingEntity, BuildingDTO.class);
        List<RentAreaEntity> rentAreaEntities = buildingEntity.getRentAreas();
        String rentArea = rentAreaEntities.stream().map(it-> it.getValue().toString()).collect(Collectors.joining(","));
        dto.setRentArea(rentArea);
        return dto;
    }


    @Override
    @Transactional
    public void delteBuilding(List<Long> ids) {
        List<BuildingEntity> buildingEntities = buildingRepository.findAllById(ids);
        rentAreaRepository.deleteByBuildingIn(buildingEntities);
        buildingRepository.deleteByIdIn(ids);
    }

    @Override
    public ResponseDTO getAllStaffs(Long buildingId) {
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        List<AssignmentBuildingEntity> staffAssigmentBuilding = buildingEntity.getAssignmentBuildingEntitiesBuilding();
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        for (UserEntity item : staffs) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setStaffId(item.getId());
            staffResponseDTO.setFullName(item.getFullName());
            boolean isAssigned = staffAssigmentBuilding.stream()
                    .anyMatch(staff -> staff.getStaff().getId().equals(item.getId()));

//            boolean isAssigned = staffAssigmentBuilding.stream()
//                    .anyMatch(staff -> staff.getId().equals(item.getId()));

            staffResponseDTO.setChecked(isAssigned ? "checked" : "");
            staffResponseDTOS.add(staffResponseDTO);
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(staffResponseDTOS);
        responseDTO.setMessage("Success");
        return responseDTO;
    }

    @Transactional
    @Override
    public void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
        assignmentBuildingRepository.deleteAllByBuildingId(assignmentBuildingDTO.getBuildingId());
        BuildingEntity buildingEntity = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
        List<AssignmentBuildingEntity> assignmentBuildingEntityList = new ArrayList<>();
        for (Long staffId : assignmentBuildingDTO.getStaffs()){
            UserEntity userEntity = userRepository.findById(staffId).get();
            AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
            assignmentBuildingEntity.setBuilding(buildingEntity);
            assignmentBuildingEntity.setStaff(userEntity);
            assignmentBuildingEntityList.add(assignmentBuildingEntity);
        }
        assignmentBuildingRepository.saveAll(assignmentBuildingEntityList);

    }


}
