package com.knowledge.service.impl;

import com.knowledge.dao.PackageDao;
import com.knowledge.model.Package;
import com.knowledge.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
