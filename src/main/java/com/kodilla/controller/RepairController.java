package com.kodilla.controller;

import com.kodilla.dto.RepairDto;
import com.kodilla.mapper.RepairMapper;
import com.kodilla.sercive.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class RepairController {

    @Autowired
    private RepairMapper repairMapper;

    @Autowired
    private RepairService repairService;

    @RequestMapping(method = RequestMethod.GET, value = "/repairs")
    public List<RepairDto> getRepairs() {
        return repairMapper.mapToRepairDtoList(repairService.getRepairs());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/repairs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRepair(@RequestBody RepairDto repairDto) {
        repairService.saveRepair(repairMapper.mapToRepair(repairDto));
    }
}
