package co.com.keralty.archetype.infrastructure.rest.exception;

import co.com.keralty.archetype.domain.exception.ConsultaException;
import co.com.keralty.archetype.infrastructure.rest.dto.ErrorResponseDto;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof ConsultaException consultaException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponseDto(consultaException.getMessage()))
                    .build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponseDto("Error interno del servidor: " + exception.getMessage()))
                .build();
    }
}

