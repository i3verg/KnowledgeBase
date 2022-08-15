package com.knowledge.utils;

import com.knowledge.model.Package;
import com.knowledge.model.dto.PackageCommonDto;

public class MappingUtils {

    public PackageCommonDto mapToPackageCommonDto(Package unit){
        PackageCommonDto packageCommonDto = new PackageCommonDto();
        packageCommonDto.setKnowledgePackageId(unit.getKnowledgePackageId());
        packageCommonDto.setKnowledgePackageTitle(unit.getKnowledgePackageTitle());
        return packageCommonDto;
    }

    public Package mapToPackage(PackageCommonDto packageCommonDto){
        Package entity = new Package();
        entity.setKnowledgePackageId(packageCommonDto.getKnowledgePackageId());
        entity.setKnowledgePackageTitle(packageCommonDto.getKnowledgePackageTitle());
        return entity;
    }
}
