package co.com.keralty.archetype.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@RegisterForReflection
public class BhMppMember {

    @JsonProperty("MME_NCODE")
    private Integer id;

    @JsonProperty("MCO_NCODE")
    private Integer contractCode;

    @JsonProperty("PER_NCODE")
    private Integer personCode;

    @JsonProperty("REL_NCODE")
    private Integer relationCode;

    @JsonProperty("MSM_NCODE")
    private Integer statusCode;

    @JsonProperty("MME_DSTARTINGDATE")
    private LocalDate startingDate;

    @JsonProperty("MME_DENDINGDATE")
    private LocalDate endingDate;

    @JsonProperty("MME_DEXCLUSIONDATE")
    private LocalDate exclusionDate;

    @JsonProperty("PRO_NCODE")
    private Integer productCode;

    @JsonProperty("PLA_NCODE")
    private Integer planCode;

    @JsonProperty("MME_NAGE")
    private Integer age;

    @JsonProperty("MME_NCONSECUTIVE")
    private Integer consecutive;

    @JsonProperty("MCV_NCODE")
    private Integer coverCode;
}

