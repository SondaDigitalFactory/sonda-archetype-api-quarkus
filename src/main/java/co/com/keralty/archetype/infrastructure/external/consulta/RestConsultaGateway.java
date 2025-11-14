package co.com.keralty.archetype.infrastructure.external.consulta;

import co.com.keralty.archetype.domain.exception.ConsultaException;
import co.com.keralty.archetype.domain.model.BhMppMember;
import co.com.keralty.archetype.domain.model.TablaConsulta;
import co.com.keralty.archetype.domain.port.out.ConsultaGateway;
import co.com.keralty.archetype.infrastructure.external.consulta.dto.RequestConsultaClient;
import co.com.keralty.archetype.infrastructure.external.consulta.dto.ResponseMultyConsulta;
import co.com.keralty.archetype.infrastructure.external.consulta.http.ConsultaExternalClient;
import co.com.keralty.archetype.infrastructure.util.JsonParserUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class RestConsultaGateway implements ConsultaGateway {

    private final ConsultaExternalClient consultaExternalClient;

    @Inject
    public RestConsultaGateway(@RestClient ConsultaExternalClient consultaExternalClient) {
        this.consultaExternalClient = consultaExternalClient;
    }

    @Override
    public List<BhMppMember> consultar() {
        var request = RequestConsultaClient.builder()
                .tabla(TablaConsulta.MEMBERS.getNombre())
                .build();

        var respuesta = consultaExternalClient.consulta(request);
        return JsonParserUtil.parsearLista(respuesta, BhMppMember.class);
    }

    @Override
    public List<BhMppMember> consultarMultiple() {
        var request = RequestConsultaClient.builder()
                .tabla(TablaConsulta.MEMBERS.getNombre())
                .build();

        var respuestas = consultaExternalClient.consultaMulty(List.of(request));
        var primeraRespuesta = respuestas.stream()
                .findFirst()
                .orElseThrow(() -> new ConsultaException("La respuesta de multi consulta no contiene datos"));

        return JsonParserUtil.parsearLista(primeraRespuesta.getRetorno(), BhMppMember.class);
    }

    @Override
    public List<ResponseMultyConsulta> consultarPersonasEInstitucionesPorNumeroIdentificacion(String numeroIdentificacion) {
        var requests = List.of(
                RequestConsultaClient.builder()
                        .tabla(TablaConsulta.PERSON.getNombre())
                        .condiciones("PER_CIDENTIFICATIONNUMBER = " + numeroIdentificacion)
                        .build(),
                RequestConsultaClient.builder()
                        .tabla(TablaConsulta.INSTITUTION.getNombre())
                        .condiciones("INS_CIDENTIFICATIONNUMBER = " + numeroIdentificacion)
                        .build()
        );

        return consultaExternalClient.consultaMulty(requests);
    }
}
