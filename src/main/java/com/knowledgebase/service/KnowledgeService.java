package com.knowledgebase.service;

import com.knowledgebase.model.Knowledge;
import org.springframework.stereotype.Service;

import java.util.List;

public interface KnowledgeService {
    int create(Knowledge knowledge);
    List<Knowledge> getAllKnowledge();
    int deleteKnowledge(int id);
}
