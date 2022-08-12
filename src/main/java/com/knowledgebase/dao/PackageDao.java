package com.knowledgebase.dao;

import com.knowledgebase.model.Package;

import java.util.List;

public interface PackageDao {
     List<Package> getAllPackages();
     Package getPackage(int packageId);
}
