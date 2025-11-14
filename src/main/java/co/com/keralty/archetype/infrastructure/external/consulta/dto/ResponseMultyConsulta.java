package co.com.keralty.archetype.infrastructure.external.consulta.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@RegisterForReflection
public class ResponseMultyConsulta {

    private String tabla;
    private List<Object> retorno;
}

