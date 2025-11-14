package co.com.keralty.archetype.domain.port.in;

import co.com.keralty.archetype.infrastructure.rest.dto.ConsultaPersonasInstitucionesResponseDto;

import java.util.List;

/**
 * Caso de uso encargado de consultar personas e instituciones asociadas a un documento.
 */
public interface ConsultarPersonasEInstitucionesUseCase {

    /**
     * Obtiene un listado simplificado de coberturas asociadas al documento suministrado.
     *
     * @param numeroIdentificacion número de identificación a consultar
     * @return lista de resultados en formato de respuesta para el API
     */
    List<ConsultaPersonasInstitucionesResponseDto> ejecutar(String numeroIdentificacion);
}

