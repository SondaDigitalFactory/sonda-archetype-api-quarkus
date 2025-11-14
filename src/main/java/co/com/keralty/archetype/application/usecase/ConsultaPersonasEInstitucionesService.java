package co.com.keralty.archetype.application.usecase;

import co.com.keralty.archetype.domain.model.BhPerson;
import co.com.keralty.archetype.domain.model.TablaConsulta;
import co.com.keralty.archetype.domain.port.in.ConsultarPersonasEInstitucionesUseCase;
import co.com.keralty.archetype.domain.port.out.ConsultaGateway;
import co.com.keralty.archetype.infrastructure.rest.dto.ConsultaPersonasInstitucionesResponseDto;
import co.com.keralty.archetype.infrastructure.util.JsonParserUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ConsultaPersonasEInstitucionesService implements ConsultarPersonasEInstitucionesUseCase {

    private final ConsultaGateway consultaGateway;

    @Inject
    public ConsultaPersonasEInstitucionesService(ConsultaGateway consultaGateway) {
        this.consultaGateway = consultaGateway;
    }

    @Override
    public List<ConsultaPersonasInstitucionesResponseDto> ejecutar(String numeroIdentificacion) {
        return consultaGateway.consultarPersonasEInstitucionesPorNumeroIdentificacion(numeroIdentificacion).stream()
                .filter(respuesta -> TablaConsulta.PERSON.getNombre().equals(respuesta.getTabla()))
                .findFirst()
                .map(respuesta -> JsonParserUtil.parsearLista(respuesta.getRetorno(), BhPerson.class))
                .orElse(List.of())
                .stream()
                .map(this::mapearPersona)
                .toList();
    }

    private ConsultaPersonasInstitucionesResponseDto mapearPersona(BhPerson persona) {
        var identificacion = persona.getPerCidentificationnumber();
        var codigoPersona = persona.getPerNcode();

        return ConsultaPersonasInstitucionesResponseDto.builder()
                .idCodProd(cadenaONull(codigoPersona))
                .codProd("DEMO-" + cadenaONull(codigoPersona))
                .idContrato(identificacion)
                .numContrato(identificacion)
                .nombreProducto("Producto demostración")
                .nombrePlan("Plan demostración")
                .tipoContrato(1)
                .mcoAcoNcode(codigoPersona == null ? null : codigoPersona.longValue())
                .build();
    }

    private String cadenaONull(Integer valor) {
        return valor == null ? null : valor.toString();
    }
}
