package com.knowledge.service;

import com.knowledge.model.Package;

import java.util.List;
public interface PackageService {
    List<Package> getAllPackages();
    Package getPackage(int id);
}
