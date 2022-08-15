package com.knowledge.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.knowledge.model.Package;
import com.knowledge.model.dto.PackageCommonDto;
import com.knowledge.service.KnowledgeService;
import com.knowledge.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class KnowledgePackageController {

    private KnowledgeService knowledgeService;

    private PackageService packageService;

    @Autowired
    public void setServices(KnowledgeService knowledgeService, PackageService packageService){
        this.knowledgeService = knowledgeService;
        this.packageService = packageService;
    }

    @GetMapping(value = "/kpacs")
    public String getAllKnowledge(ModelMap knowledgeModel){
        knowledgeModel.addAttribute("knowledge",knowledgeService.getAllKnowledge());
        return "kpacs";
    }

    @GetMapping(value = "/sets")
    public String getPackages(ModelMap packageModel){
        List<PackageCommonDto> packages = packageService.getAllPackages();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        packageModel.addAttribute("packageSet", gson.toJson(packages));
        return "sets";
    }

    @GetMapping(value = "/set/{id}")
    public String getPackage(@PathVariable int id, ModelMap packageModel){
        packageModel.addAttribute("packageModel", packageService.getPackage(id));
        return "packageModel";
    }

}
