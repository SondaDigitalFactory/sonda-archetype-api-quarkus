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
public class BhInstitution {

    @JsonProperty("INS_NCODE")
    private Integer insNcode;

    @JsonProperty("INS_CIDENTIFICATIONNUMBER")
    private String insCidentificationnumber;
}

