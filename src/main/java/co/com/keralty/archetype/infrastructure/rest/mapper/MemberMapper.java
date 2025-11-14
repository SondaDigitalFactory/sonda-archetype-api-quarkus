package co.com.keralty.archetype.infrastructure.rest.mapper;

import co.com.keralty.archetype.domain.model.BhMppMember;
import co.com.keralty.archetype.infrastructure.rest.dto.MemberResponseDto;

import java.util.List;

public final class MemberMapper {

    private MemberMapper() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static MemberResponseDto toDto(BhMppMember member) {
        if (member == null) {
            return null;
        }
        return MemberResponseDto.builder()
                .id(member.getId())
                .contractCode(member.getContractCode())
                .personCode(member.getPersonCode())
                .relationCode(member.getRelationCode())
                .statusCode(member.getStatusCode())
                .startingDate(member.getStartingDate())
                .endingDate(member.getEndingDate())
                .exclusionDate(member.getExclusionDate())
                .productCode(member.getProductCode())
                .planCode(member.getPlanCode())
                .age(member.getAge())
                .consecutive(member.getConsecutive())
                .coverCode(member.getCoverCode())
                .build();
    }

    public static List<MemberResponseDto> toDtoList(List<BhMppMember> members) {
        if (members == null) {
            return List.of();
        }
        return members.stream()
                .map(MemberMapper::toDto)
                .toList();
    }
}

