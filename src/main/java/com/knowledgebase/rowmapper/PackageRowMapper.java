package com.knowledgebase.rowmapper;

import com.knowledgebase.model.Package;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PackageRowMapper implements RowMapper<Package> {
    @Override
    public Package mapRow(ResultSet rs, int rowNum) throws SQLException {
        Package pack = new Package();
        pack.setKnowledgePackageId(rs.getInt("PACKAGE_ID"));
        pack.setKnowledgePackageTitle(rs.getString("TITLE"));
        return pack;
    }
}
