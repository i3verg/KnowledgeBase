package com.knowledge.service;

import com.knowledge.model.Knowledge;

import java.util.List;

public interface KnowledgeService {
    int create(Knowledge knowledge);
    List<Knowledge> getAllKnowledge();
    int deleteKnowledge(int id);
}
