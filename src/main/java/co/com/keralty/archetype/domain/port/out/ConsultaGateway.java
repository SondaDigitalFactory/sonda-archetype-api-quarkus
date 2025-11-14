package co.com.keralty.archetype.domain.port.out;

import co.com.keralty.archetype.domain.model.BhMppMember;
import co.com.keralty.archetype.infrastructure.external.consulta.dto.ResponseMultyConsulta;

import java.util.List;

/**
 * Puerto de salida para interactuar con el servicio de consultas externo.
 */

public interface ConsultaGateway {

    /**
     * Consulta miembros usando una operación simple en el servicio externo.
     *
     * @return lista de miembros obtenidos
     */
    List<BhMppMember> consultar();

    /**
     * Realiza una consulta múltiple de miembros contra el servicio externo.
     *
     * @return lista de miembros construida desde la respuesta multi consulta
     */
    List<BhMppMember> consultarMultiple();

    /**
     * Invoca el servicio externo para obtener personas e instituciones asociadas a un documento.
     *
     * @param numeroIdentificacion número de identificación a consultar
     * @return respuestas crudas provenientes del servicio externo
     */
    List<ResponseMultyConsulta> consultarPersonasEInstitucionesPorNumeroIdentificacion(String numeroIdentificacion);
}

