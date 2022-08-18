package com.knowledge.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.knowledge.model.dto.PackageCommonDto;
import com.knowledge.model.dto.PackageSetDto;
import com.knowledge.service.KnowledgeService;
import com.knowledge.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class KnowledgePackageController {

    private KnowledgeService knowledgeService;

    private PackageService packageService;

    @Autowired
    public void setServices(KnowledgeService knowledgeService, PackageService packageService) {
        this.knowledgeService = knowledgeService;
        this.packageService = packageService;
    }

    @GetMapping(value = "kpacs")
    public String getAllKnowledge(ModelMap knowledgeModel) {
        knowledgeModel.addAttribute("knowledge", knowledgeService.getAllKnowledge());
        return "kpacs";
    }

    @GetMapping(value = "sets")
    public String getPackages(ModelMap packageModel) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        packageModel.addAttribute("packageSet", gson.toJson(packageService.getAllPackages()));
        return "sets";
    }

    @GetMapping(value = "set/{id}")
    public String getPackage(@PathVariable int id, ModelMap packageModel) {
        packageModel.addAttribute("packageModel", packageService.getPackage(id));
        return "packageModel";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "set/{id}")
    public String deletePackage(@PathVariable int id) {
        packageService.deletePackage(id);
        return "sets";
    }

    @RequestMapping("addPackage")
    public String showPackageForm(Model model) {
        model.addAttribute("package", new PackageSetDto());
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        model.addAttribute("knowledgeSet", gson.toJson(knowledgeService.getAllKnowledge()));
        return "add";
    }

    @PostMapping(value = "add/package")
    public String addPackageSet(@ModelAttribute PackageSetDto packageSetDto) {
        packageService.addPackageSet(packageSetDto.getKnowledgePackageTitle(), packageSetDto.getKnowledgeIds());
        return "redirect::sets";
    }

}
