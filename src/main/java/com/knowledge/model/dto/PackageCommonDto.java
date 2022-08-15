package com.knowledge.model.dto;

public class PackageCommonDto {
    private int knowledgePackageId;
    private String knowledgePackageTitle;

    public PackageCommonDto() {
    }

    public PackageCommonDto(int knowledgePackageId, String knowledgePackageTitle) {
        this.knowledgePackageId = knowledgePackageId;
        this.knowledgePackageTitle = knowledgePackageTitle;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageCommonDto that = (PackageCommonDto) o;

        if (knowledgePackageId != that.knowledgePackageId) return false;
        return knowledgePackageTitle.equals(that.knowledgePackageTitle);
    }

    @Override
    public int hashCode() {
        int result = knowledgePackageId;
        result = 31 * result + knowledgePackageTitle.hashCode();
        return result;
    }
}
