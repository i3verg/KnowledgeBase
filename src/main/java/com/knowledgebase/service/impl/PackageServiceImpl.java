package com.knowledgebase.service.impl;

import com.knowledgebase.dao.PackageDao;
import com.knowledgebase.model.Package;
import com.knowledgebase.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PackageServiceImpl implements PackageService {
    @Autowired
    PackageDao packageDao;

    public PackageServiceImpl(PackageDao packageDao) {
        this.packageDao = packageDao;
    }

    @Override
    public List<Package> getAllPackages() {
        return packageDao.getAllPackages();
    }

    @Override
    public Package getPackage(int id) {
        return packageDao.getPackage(id);
    }

    public PackageDao getPackageDao() {
        return packageDao;
    }
}
