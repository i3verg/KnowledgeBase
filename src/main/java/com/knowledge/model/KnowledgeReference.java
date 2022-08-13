package com.knowledge.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("KNOWLEDGE_PACKAGE")
public class KnowledgeReference {
    @Column("KNOWLEDGE_ID")
    public int knowledgeRefId;
    @Column("PACKAGE_ID")
    public int packageRefId;
    public KnowledgeReference(int knowledgeRefId) {
        this.knowledgeRefId = knowledgeRefId;
    }

    public KnowledgeReference() {
    }

    public KnowledgeReference(int knowledgeRefId, int packageRefId) {
        this.knowledgeRefId = knowledgeRefId;
        this.packageRefId = packageRefId;
    }
}
