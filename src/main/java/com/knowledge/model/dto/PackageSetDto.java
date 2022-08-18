package com.knowledge.model.dto;

import java.util.List;

public class PackageSetDto {

    private int knowledgePackageId;
    private String knowledgePackageTitle;
    private List<Integer> knowledgeIds;

    public PackageSetDto() {
    }

    public PackageSetDto(int knowledgePackageId, String knowledgePackageTitle, List<Integer> knowledgeIds) {
        this.knowledgePackageId = knowledgePackageId;
        this.knowledgePackageTitle = knowledgePackageTitle;
        this.knowledgeIds = knowledgeIds;
    }

    public PackageSetDto(String knowledgePackageTitle, List<Integer> knowledgeIds) {
        this.knowledgePackageTitle = knowledgePackageTitle;
        this.knowledgeIds = knowledgeIds;
    }

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

    public List<Integer> getKnowledgeIds() {
        return knowledgeIds;
    }

    public void setKnowledgeIds(List<Integer> knowledgeIds) {
        this.knowledgeIds = knowledgeIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageSetDto that = (PackageSetDto) o;

        if (knowledgePackageId != that.knowledgePackageId) return false;
        if (!knowledgePackageTitle.equals(that.knowledgePackageTitle)) return false;
        return knowledgeIds.equals(that.knowledgeIds);
    }

    @Override
    public int hashCode() {
        int result = knowledgePackageId;
        result = 31 * result + knowledgePackageTitle.hashCode();
        result = 31 * result + knowledgeIds.hashCode();
        return result;
    }
}
