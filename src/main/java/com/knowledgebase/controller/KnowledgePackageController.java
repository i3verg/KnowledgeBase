package com.knowledgebase.controller;

import com.knowledgebase.service.KnowledgeService;
import com.knowledgebase.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class KnowledgePackageController {
    @Autowired
    private KnowledgeService knowledgeService;
    @Autowired
    private PackageService packageService;

    @GetMapping(value = "kpacs")
    public String getAllKnowledge(ModelMap knowledgeModel){
        knowledgeModel.addAttribute("knowledge",knowledgeService.getAllKnowledge());
        return "kpacs";
    }

    @GetMapping(value = "sets")
    public String getPackages(ModelMap packageModel){
        packageModel.addAttribute("package",packageService.getAllPackages());
        return "sets";
    }

    @GetMapping(value = "set/{id}")
    public String getPackage(@PathVariable int id, ModelMap packageModel){
        packageModel.addAttribute("packageModel", packageService.getPackage(id));
        return "set";
    }


}
