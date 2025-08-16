package com.javaweb.controller.admin;
import com.javaweb.enums.buildingType;
import com.javaweb.enums.districtCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.BuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController(value="buildingControllerOfAdmin")
public class BuildingController {
    //sử dụng ModelAndView thì api ko phân nhìu tầng
    @Autowired
    private IUserService userService;
    @Autowired
    private BuildingService buildingService;
    @GetMapping("/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute (name ="modelSearch") BuildingSearchRequest buildingSearchRequest) {
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        modelAndView.addObject("districtCode", districtCode.type());
        modelAndView.addObject("staffs", userService.getStaffs());
        modelAndView.addObject("typeCode", buildingType.typeCode());
        //project-2 Tim kiem
        List<BuildingSearchResponse> resultSearchBuilding = buildingService.searchBuilding(buildingSearchRequest);
        modelAndView.addObject("resultSearchBuilding", resultSearchBuilding);
        return modelAndView;
    }

    @GetMapping("/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute (name ="modelEdit")BuildingDTO buildingDTO) {
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        modelAndView.addObject("districtCode", districtCode.type());
        modelAndView.addObject("staffs", userService.getStaffs());
        modelAndView.addObject("typeCode", buildingType.typeCode());
        return modelAndView;
    }

    @GetMapping("/admin/building-edit-{id}")
    public ModelAndView buildingEdit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        BuildingDTO buildingDTO = buildingService.getBuildingById(id);
        modelAndView.addObject("modelEdit", buildingDTO);
        modelAndView.addObject("districtCode", districtCode.type());
        modelAndView.addObject("typeCode", buildingType.typeCode());
        //findById > BuildingEntity
        //buildingEntity > buildingDTO
        return modelAndView;
    }
}
