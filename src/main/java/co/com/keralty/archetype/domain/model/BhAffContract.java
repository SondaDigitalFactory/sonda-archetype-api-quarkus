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
public class BhAffContract {

    @JsonProperty("ACO_NCODE")
    private Integer acoNcode;

    @JsonProperty("PLA_NCODE")
    private Integer plaNcode;

    @JsonProperty("ACO_CONTRACTCODE")
    private String acoContractcode;
}

