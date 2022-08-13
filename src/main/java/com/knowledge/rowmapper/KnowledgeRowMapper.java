package com.knowledge.rowmapper;

import com.knowledge.model.Knowledge;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KnowledgeRowMapper implements RowMapper<Knowledge> {
    @Override
    public Knowledge mapRow(ResultSet rs, int rowNum) throws SQLException {
        Knowledge knowledge = new Knowledge();
        knowledge.setKnowledgeId(rs.getInt("KNOWLEDGE_ID"));
        knowledge.setKnowledgeTitle(rs.getString("TITLE"));
        knowledge.setKnowledgeDescription(rs.getString("KNOWLEDGE_DESCRIPTION"));
        knowledge.setCreationDate(rs.getDate("CREATION_DATE"));
        return knowledge;
    }
}
