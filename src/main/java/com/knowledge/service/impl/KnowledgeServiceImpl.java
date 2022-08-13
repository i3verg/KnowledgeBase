package com.knowledge.service.impl;

import com.knowledge.dao.KnowledgeDao;
import com.knowledge.model.Knowledge;
import com.knowledge.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    @Autowired
    KnowledgeDao knowledgeDao;

    @Override
    public int create(Knowledge knowledge) {
        return knowledgeDao.createKnowledge(knowledge);
    }

    @Override
    public List<Knowledge> getAllKnowledge() {
        return knowledgeDao.findAll();
    }

    @Override
    public int deleteKnowledge(int id) {
        return knowledgeDao.deleteKnowledge(id);
    }

    public KnowledgeDao getKnowledgeDao() {
        return knowledgeDao;
    }
}
