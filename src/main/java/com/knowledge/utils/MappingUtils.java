package com.knowledge.utils;

import com.knowledge.model.KnowledgeReference;
import com.knowledge.model.Package;
import com.knowledge.model.dto.PackageCommonDto;
import com.knowledge.model.dto.PackageSetDto;
import org.springframework.data.relational.core.sql.In;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MappingUtils {

    public PackageCommonDto mapToPackageCommonDto(Package unit) {
        PackageCommonDto packageCommonDto = new PackageCommonDto();
        packageCommonDto.setKnowledgePackageId(unit.getKnowledgePackageId());
        packageCommonDto.setKnowledgePackageTitle(unit.getKnowledgePackageTitle());
        return packageCommonDto;
    }

    public Package mapToPackage(PackageCommonDto packageCommonDto) {
        Package entity = new Package();
        entity.setKnowledgePackageId(packageCommonDto.getKnowledgePackageId());
        entity.setKnowledgePackageTitle(packageCommonDto.getKnowledgePackageTitle());
        return entity;
    }

    public PackageSetDto mapToPackageSetDto(Package unit) {
        PackageSetDto packageSetDto = new PackageSetDto();
        packageSetDto.setKnowledgePackageId(unit.getKnowledgePackageId());
        packageSetDto.setKnowledgePackageTitle(unit.getKnowledgePackageTitle());
        List<Integer> knowledgeSet = unit.getKnowledgeSet().stream()
                .map(knowledgeReference -> knowledgeReference.knowledgeRefId).collect(Collectors.toList());
        packageSetDto.setKnowledgeIds(knowledgeSet);
        return packageSetDto;
    }

    public Package mapToPackageWithSet(PackageSetDto packageSetDto) {
        Package entity = new Package();
        entity.setKnowledgePackageId(packageSetDto.getKnowledgePackageId());
        entity.setKnowledgePackageTitle(packageSetDto.getKnowledgePackageTitle());

        Set<KnowledgeReference> knowledgeReferenceSet = new HashSet<>();

        for (Integer knowledgeId : packageSetDto.getKnowledgeIds()) {
            KnowledgeReference knowledgeReference = new KnowledgeReference();
            knowledgeReference.knowledgeRefId = knowledgeId;
            knowledgeReference.packageRefId = entity.getKnowledgePackageId();
            knowledgeReferenceSet.add(knowledgeReference);
        }
        entity.setKnowledgeSet(knowledgeReferenceSet);
        return entity;
    }
}
