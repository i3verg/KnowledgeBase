package com.knowledge.service;

import com.knowledge.model.Knowledge;
import com.knowledge.model.Package;
import com.knowledge.model.dto.PackageCommonDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PackageService {
    List<PackageCommonDto> getAllPackages();
    Package getPackage(int id);
    int deletePackage(int id);
    void addPackageSet(String packageTitle, List<Integer> knowledgeIds);

}
