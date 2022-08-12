package com.knowledgebase.service;

import com.knowledgebase.model.Package;

import java.util.List;
public interface PackageService {
    List<Package> getAllPackages();
    Package getPackage(int id);
}
