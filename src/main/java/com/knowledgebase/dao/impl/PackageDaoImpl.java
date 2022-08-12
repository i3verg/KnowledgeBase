package com.knowledgebase.dao.impl;

import com.knowledgebase.dao.PackageDao;
import com.knowledgebase.model.Package;
import com.knowledgebase.rowmapper.KnowledgeRowMapper;
import com.knowledgebase.rowmapper.PackageRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PackageDaoImpl implements PackageDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Package> getAllPackages() {
       return jdbcTemplate.query("select * from PACKAGE", new PackageRowMapper());
    }

    @Override
    public Package getPackage(int packageId) {
        return null;
    }
}
