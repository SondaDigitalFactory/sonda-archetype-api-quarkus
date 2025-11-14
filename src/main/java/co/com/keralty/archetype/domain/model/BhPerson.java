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
public class BhPerson {

    @JsonProperty("PER_NCODE")
    private Integer perNcode;

    @JsonProperty("PER_CDOCUMENTNUMBER")
    private String perCdocumentnumber;

    @JsonProperty("PER_CIDENTIFICATIONNUMBER")
    private String perCidentificationnumber;

    @JsonProperty("TID_NCODE")
    private Integer tidNcode;
}

