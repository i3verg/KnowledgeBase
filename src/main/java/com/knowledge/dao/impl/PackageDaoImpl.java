package com.knowledge.dao.impl;

import com.knowledge.dao.PackageDao;
import com.knowledge.model.Knowledge;
import com.knowledge.model.Package;
import com.knowledge.rowmapper.KnowledgeRowMapper;
import com.knowledge.rowmapper.PackageRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("packageDao")
public class PackageDaoImpl implements PackageDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Package[] getAllPackages() {
        List<Package> packages = jdbcTemplate.query("select * from PACKAGE", new PackageRowMapper());
        return packages.toArray(Package[]::new);
    }

    @Override
    public Package getPackage(int packageId) {
        return null;
    }

    @Override
    public List<Knowledge> getPackageWithKnowledge(int id) {
        String sql = "select * from knowledge where KNOWLEDGE_ID in\n" +
                "(select KNOWLEDGE_ID from knowledge_package join package p on p.PACKAGE_ID = knowledge_package.PACKAGE_ID" +
                " where p.PACKAGE_ID=?)";
        return jdbcTemplate.query(sql, new KnowledgeRowMapper(), id);
    }

    @Override
    @Transactional
    public void addPackage(String packageName, List<Knowledge> knowledgeList) {
        Map<String, Object> parameters = new HashMap<>();
        var simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("PACKAGE").usingGeneratedKeyColumns("PACKAGE_ID");
        parameters.put("TITLE", packageName);
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        parameters.clear();

        for (Knowledge knowledge : knowledgeList) {
            simpleJdbcInsert.withTableName("KNOWLEDGE_PACKAGE");
            parameters.put("KNOWLEDGE_ID", knowledge.getKnowledgeId());
            parameters.put("PACKAGE_ID", insertedId);
            simpleJdbcInsert.execute(parameters);
            parameters.clear();
        }
    }

    @Override
    @Transactional
    public int deletePackage(int packageId) {
        return jdbcTemplate.update("delete from PACKAGE where PACKAGE_ID = ?", packageId);
    }
}
