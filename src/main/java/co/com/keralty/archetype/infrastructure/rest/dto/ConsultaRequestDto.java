package co.com.keralty.archetype.infrastructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class ConsultaRequestDto {

    @JsonProperty("procType")
    private Integer procType;

    @JsonProperty("tipoIdent")
    private String tipoIdent;

    @JsonProperty("numIdent")
    private String numIdent;

    @JsonProperty("edadMin")
    private Integer edadMin;

    @JsonProperty("edadMax")
    private Integer edadMax;

    @JsonProperty("parentesco")
    private Integer parentesco;

    @JsonProperty("codProd")
    private String codProd;

    @JsonProperty("codPlan")
    private String codPlan;

    @JsonProperty("numContrato")
    private String numContrato;

    @JsonProperty("numFamilia")
    private String numFamilia;

    @JsonProperty("traePacientes")
    private boolean traePacientes;

    @JsonProperty("traeUltimoVig")
    private boolean traeUltimoVig;

    @JsonProperty("guid")
    private String guid;

    @JsonProperty("fecha")
    private LocalDate fecha;

    @JsonProperty("numCur")
    private Integer numCur;
}

