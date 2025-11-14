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
public class BhProduct {

    @JsonProperty("PRO_NCODE")
    private Integer proNcode;

    @JsonProperty("PRO_CLEGALCODE")
    private String proCLegalcode;

    @JsonProperty("PRO_CNAME")
    private String proCname;
}

