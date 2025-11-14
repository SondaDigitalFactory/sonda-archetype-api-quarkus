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
public class BhContract {

    @JsonProperty("MCO_NCODE")
    private Integer mcoNcode;

    @JsonProperty("MCV_NCODE")
    private Integer mcvNcode;

    @JsonProperty("MCO_NCONSEC_FAM")
    private Integer mcoNconsecFam;
}

