package co.com.keralty.archetype.infrastructure.external.consulta.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@RegisterForReflection
public class RequestConsultaClient {

    private String tabla;
    private String condiciones;
}

