package com.knowledgebase.service.impl;

import com.knowledgebase.dao.KnowledgeDao;
import com.knowledgebase.model.Knowledge;
import com.knowledgebase.service.KnowledgeService;
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
