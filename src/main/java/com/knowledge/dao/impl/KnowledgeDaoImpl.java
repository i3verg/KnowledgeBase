package com.knowledge.dao.impl;

import com.knowledge.dao.KnowledgeDao;
import com.knowledge.model.Knowledge;
import com.knowledge.rowmapper.KnowledgeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnowledgeDaoImpl implements KnowledgeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public List<Knowledge> findAll() {
        return jdbcTemplate.query("select * from KNOWLEDGE", new KnowledgeRowMapper());
    }

    @Override
    @Transactional
    public int createKnowledge(Knowledge knowledge) {
        var simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("KNOWLEDGE").usingGeneratedKeyColumns("KNOWLEDGE_ID");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("TITLE", knowledge.getKnowledgeTitle());
        parameters.put("KNOWLEDGE_DESCRIPTION", knowledge.getKnowledgeDescription());
        parameters.put("CREATION_DATE", knowledge.getCreationDate());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }
    @Override
    @Transactional
    public int deleteKnowledge(int knowledgeId) {
        return jdbcTemplate.update("delete from KNOWLEDGE where KNOWLEDGE_ID = ?", knowledgeId);
    }
}
