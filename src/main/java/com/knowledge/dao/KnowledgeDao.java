package com.knowledge.dao;

import com.knowledge.model.Knowledge;

import java.util.List;

public interface KnowledgeDao {
    List<Knowledge> findAll();
    int createKnowledge(Knowledge knowledge);
    int deleteKnowledge(int knowledgeId);
}
