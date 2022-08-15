package com.knowledge.service;

import com.knowledge.model.Package;
import com.knowledge.model.dto.PackageCommonDto;

import java.util.List;
public interface PackageService {
    List<PackageCommonDto> getAllPackages();
    Package getPackage(int id);
}
