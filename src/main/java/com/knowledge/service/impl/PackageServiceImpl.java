package com.knowledge.service.impl;

import com.knowledge.dao.PackageDao;
import com.knowledge.model.Package;
import com.knowledge.model.dto.PackageCommonDto;
import com.knowledge.service.PackageService;
import com.knowledge.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageServiceImpl implements PackageService {

    PackageDao packageDao;
    MappingUtils mappingUtils = new MappingUtils();

    @Autowired
    public void setPackageDao(PackageDao packageDao) {
        this.packageDao = packageDao;
    }

    public PackageServiceImpl(PackageDao packageDao) {
        this.packageDao = packageDao;
    }

    @Override
    public List<PackageCommonDto> getAllPackages() {
        return packageDao.getAllPackages()
                .stream()
                .map(mappingUtils::mapToPackageCommonDto)
                .collect(Collectors.toList());
    }

    @Override
    public Package getPackage(int id) {
        return packageDao.getPackage(id);
    }

    public PackageDao getPackageDao() {
        return packageDao;
    }
}
