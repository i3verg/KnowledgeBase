package com.knowledge.service;

import com.knowledge.model.Package;

import java.util.List;
public interface PackageService {
    Package [] getAllPackages();
    Package getPackage(int id);
}
