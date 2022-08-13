package com.knowledge.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Date;

public class Knowledge {
    @Id
    private int knowledgeId;
    @Column("TITLE")
    private String knowledgeTitle;
    @Column("KNOWLEDGE_DESCRIPTION")
    private String knowledgeDescription;
    @Column("CREATION_DATE")
    private Date creationDate;

    public Knowledge() {
    }

    public Knowledge(int knowledgeId, String knowledgeTitle, String knowledgeDescription, Date creationDate) {
        this.knowledgeId = knowledgeId;
        this.knowledgeTitle = knowledgeTitle;
        this.knowledgeDescription = knowledgeDescription;
        this.creationDate = creationDate;
    }

    public int getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(int knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    public String getKnowledgeTitle() {
        return knowledgeTitle;
    }

    public void setKnowledgeTitle(String knowledgeTitle) {
        this.knowledgeTitle = knowledgeTitle;
    }

    public String getKnowledgeDescription() {
        return knowledgeDescription;
    }

    public void setKnowledgeDescription(String knowledgeDescription) {
        this.knowledgeDescription = knowledgeDescription;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Knowledge{" +
                "knowledgeId=" + knowledgeId +
                ", knowledgeTitle='" + knowledgeTitle + '\'' +
                ", knowledgeDescription='" + knowledgeDescription + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
