package co.com.keralty.archetype.infrastructure.external.consulta.http;

import co.com.keralty.archetype.infrastructure.external.consulta.dto.RequestConsultaClient;
import co.com.keralty.archetype.infrastructure.external.consulta.dto.ResponseMultyConsulta;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

/**
 * Cliente REST que encapsula las llamadas al servicio legado de consultas.
 */
@RegisterRestClient(configKey = "consulta-client")
public interface ConsultaExternalClient {

    /**
     * Ejecuta una consulta simple en el servicio legado.
     *
     * @param query parámetros básicos de la consulta
     * @return respuesta sin transformar retornada por el servicio
     */
    @Path("/search")
    @POST
    List<Object> consulta(RequestConsultaClient query);

    /**
     * Ejecuta una consulta múltiple en el servicio legado.
     *
     * @param multyQuery lista de consultas a ejecutar
     * @return respuesta agrupada enviada por el servicio
     */
    @Path("/multiQuery")
    @POST
    List<ResponseMultyConsulta> consultaMulty(List<RequestConsultaClient> multyQuery);
}

