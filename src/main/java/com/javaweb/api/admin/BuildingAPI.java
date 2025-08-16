package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;
    @PostMapping
    public String createOrUpdateBuilding(@RequestBody BuildingDTO dto) {
        buildingService.addOrUpdateBuilding(dto);
        return new String("Da them thanh cong");
    }

    @DeleteMapping("/{ids}")
    public String deleteBuilding(@PathVariable List<Long> ids) {
        buildingService.delteBuilding(ids);
        return new String("Da xoa thanh cong");
    }

    @GetMapping("/{buildingId}/staffs")
    public ResponseDTO getAllStaffs(@PathVariable Long buildingId) {
        //xuong buildingService xu ly
        ResponseDTO responseDTO = buildingService.getAllStaffs(buildingId);
        return responseDTO;
    }

    @PostMapping("/staff")
    public String updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        //xuong service de them da ta
        buildingService.updateAssignmentBuilding(assignmentBuildingDTO);
         return new String("Da update thanh cong");
    }
}
