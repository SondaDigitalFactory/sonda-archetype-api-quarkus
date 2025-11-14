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
public class BhPlan {

    @JsonProperty("PLA_NCODE")
    private Integer plaNcode;

    @JsonProperty("PLA_CLEGALCODE")
    private String plaCLegalcode;

    @JsonProperty("PLA_CNAME")
    private String plaCname;

    @JsonProperty("PRO_NCODE")
    private Integer proNcode;
}

