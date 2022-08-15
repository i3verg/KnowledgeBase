package com.knowledge.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;

public class Package {
    @Id
    private int knowledgePackageId;
    @Column("TITLE")
    private String knowledgePackageTitle;
    @MappedCollection(idColumn ="PACKAGE_ID")
    private Set<KnowledgeReference> knowledgeSet = new HashSet<>();

    public void addKnowledge(Knowledge knowledge){
        knowledgeSet.add(new KnowledgeReference(knowledge.getKnowledgeId()));
    }

    public Package() {
    }

    public Package(int knowledgePackageId, String knowledgePackageTitle, Set<KnowledgeReference> knowledgeSet) {
        this.knowledgePackageId = knowledgePackageId;
        this.knowledgePackageTitle = knowledgePackageTitle;
        this.knowledgeSet = knowledgeSet;
    }



    /*private void addKnowledge(Knowledge knowledge){
        this.knowledgeSet.add(createKnowledgeReference(knowledge));
    }
    private KnowledgeReference createKnowledgeReference(Knowledge knowledge){
        KnowledgeReference knowledgeReference = new KnowledgeReference();
        knowledgeReference.knowledgeRefId = knowledge.getKnowledgeId();
        knowledgeReference.referenceTitle = knowledge.getKnowledgeTitle();
        return knowledgeReference;
    }*/

    public int getKnowledgePackageId() {
        return knowledgePackageId;
    }

    public void setKnowledgePackageId(int knowledgePackageId) {
        this.knowledgePackageId = knowledgePackageId;
    }

    public String getKnowledgePackageTitle() {
        return knowledgePackageTitle;
    }

    public void setKnowledgePackageTitle(String knowledgePackageTitle) {
        this.knowledgePackageTitle = knowledgePackageTitle;
    }

}
