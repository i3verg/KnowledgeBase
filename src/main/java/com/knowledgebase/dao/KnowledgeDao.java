package com.knowledgebase.dao;

import com.knowledgebase.model.Knowledge;

import java.util.List;

public interface KnowledgeDao {
    List<Knowledge> findAll();
    int createKnowledge(Knowledge knowledge);
    int deleteKnowledge(int knowledgeId);
}
