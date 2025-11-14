package co.com.keralty.archetype.infrastructure.rest.dto;

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
public class ConsultaPersonasInstitucionesResponseDto {

    private String idCodProd;
    private String codProd;
    private String idNombreProducto;
    private String nombreProducto;
    private String idPlan;
    private String codPlan;
    private String idContrato;
    private String numContrato;
    private String idFamilia;
    private Integer numFamilia;
    private String idNombrePlan;
    private String nombrePlan;
    private Long mcoAcoNcode;
    private Integer tipoContrato;
}

