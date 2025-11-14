package co.com.keralty.archetype.infrastructure.rest;

import co.com.keralty.archetype.domain.exception.ConsultaException;
import co.com.keralty.archetype.domain.port.in.ConsultarPersonasEInstitucionesUseCase;
import co.com.keralty.archetype.infrastructure.rest.dto.ConsultaRequestDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/consulta-personas-instituciones")
public class ConsultaPersonasInstitucionesResource {

    private final ConsultarPersonasEInstitucionesUseCase consultarPersonasEInstitucionesUseCase;

    @Inject
    public ConsultaPersonasInstitucionesResource(
            ConsultarPersonasEInstitucionesUseCase consultarPersonasEInstitucionesUseCase) {
        this.consultarPersonasEInstitucionesUseCase = consultarPersonasEInstitucionesUseCase;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(ConsultaRequestDto request) {
        if (request.getNumIdent() == null || request.getNumIdent().trim().isEmpty()) {
            throw new ConsultaException("El número de identificación es requerido");
        }

        var resultado = consultarPersonasEInstitucionesUseCase.ejecutar(request.getNumIdent());
        return Response.ok(resultado).build();
    }
}

