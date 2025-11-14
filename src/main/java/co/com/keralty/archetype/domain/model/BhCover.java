package co.com.keralty.archetype.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class BhCover {

    @JsonProperty("MCV_NCODE")
    private Integer mcvNcode;

    @JsonProperty("PRO_NCODE")
    private Integer proNcode;

    @JsonProperty("PLA_NCODE")
    private Integer plaNcode;

    @JsonProperty("MCV_CCONTRACTCODE")
    private String mcvCcontractcode;

    @JsonProperty("SCM_NCODE")
    private Integer scmNcode;
}

