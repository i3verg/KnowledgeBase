package com.knowledge.service;

import com.knowledge.model.Knowledge;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface KnowledgeService {
    int create(Knowledge knowledge);
    List<Knowledge> getAllKnowledge();
    int deleteKnowledge(int id);
}
