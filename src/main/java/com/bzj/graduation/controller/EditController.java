package com.bzj.graduation.controller;

import com.bzj.graduation.bean.*;
import com.bzj.graduation.service.ConfigListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EditController {

    @Autowired
    private ConfigListService configListService;

    @PostMapping("/cpuEdit")
    public String cpuEdit(@ModelAttribute Cpu cpu){
        if (cpu.getId()==0){
            configListService.addCpu(cpu);
        }
        else
            configListService.editCpu(cpu);
        return "indexManager";
    }

    @PostMapping("/mainBoardEdit")
    public String mainBoardEdit(@ModelAttribute MainBoard mainBoard){
        if (mainBoard.getId()==0){
            configListService.addMainBoard(mainBoard);
        }
        else
            configListService.editMainBoard(mainBoard);
        return "indexManager";
    }
//
    @PostMapping("/memoryEdit")
    public String memoryEdit(@ModelAttribute Memory memory){
        if (memory.getId()==0){
            configListService.addMemory(memory);
        }
        else
            configListService.editMemory(memory);
        return "indexManager";
    }
//
    @PostMapping("/hardDriverEdit")
    public String hardDriverEdit(@ModelAttribute HardDisk hardDisk){
        if (hardDisk.getId()==0){
            configListService.addHardDisk(hardDisk);
        }
        else
            configListService.editHardDisk(hardDisk);
        return "indexManager";
    }
//
    @PostMapping("/displayEdit")
    public String displayEdit(@ModelAttribute Display display){
        if (display.getId()==0){
            configListService.addDisplay(display);
        }
        else
            configListService.editDisplay(display);
        return "indexManager";
    }
//
    @PostMapping("/boxEdit")
    public String hardDriverEdit(@ModelAttribute Box box){
        if (box.getId()==0){
            configListService.addBox(box);
        }
        else
            configListService.editBox(box);
        return "indexManager";
    }
//
    @PostMapping("/powerEdit")
    public String hardDriverEdit(@ModelAttribute Power power){
        if (power.getId()==0){
            configListService.addPower(power);
        }
        else
            configListService.editPower(power);
        return "indexManager";
    }

    @PostMapping("/radiatorEdit")
    public String hardDriverEdit(@ModelAttribute Radiator radiator){
        if (radiator.getId()==0){
            configListService.addRadiator(radiator);
        }
        else
            configListService.editRadiator(radiator);
        return "indexManager";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Map<String,Integer> map){
        configListService.delete(map);
        return "indexManager";
    }

    @PostMapping("/softEdit")
    public String editSoft(@ModelAttribute Resource resource){
        if (resource.getId()==null)
            configListService.addSoft(resource);
        else
            configListService.editSoft(resource);
        return "resourceManager";
    }

    @RequestMapping("/resource/delete")
    public String deleteResource(@RequestBody Map<String,Integer> map){
        configListService.deleteResource(map.get("id"));
        return "resourceManager";
    }

    @RequestMapping("/configList/delete")
    public String deleteConfigList(@RequestBody Map<String,Integer> map){
        configListService.deleteConfigList(map.get("id"));
        return "configListManager";
    }
}
