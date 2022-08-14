package com.knowledge.dao;

import com.knowledge.model.Knowledge;
import com.knowledge.model.Package;

import java.util.List;

public interface PackageDao {
     List<Package> getAllPackages();
     Package getPackage(int packageId);
     List<Knowledge> getPackageWithKnowledge(int id);
     void addPackage(String packageName, List<Knowledge> knowledgeList);
     int deletePackage(int packageId);



}
