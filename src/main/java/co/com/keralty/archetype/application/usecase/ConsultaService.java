package co.com.keralty.archetype.application.usecase;

import co.com.keralty.archetype.domain.model.BhMppMember;
import co.com.keralty.archetype.domain.port.in.ConsultarMembersUseCase;
import co.com.keralty.archetype.domain.port.out.ConsultaGateway;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ConsultaService implements ConsultarMembersUseCase {

    private final ConsultaGateway consultaGateway;

    @Inject
    public ConsultaService(ConsultaGateway consultaGateway) {
        this.consultaGateway = consultaGateway;
    }

    @Override
    public List<BhMppMember> consultar() {
        return consultaGateway.consultar();
    }

    @Override
    public List<BhMppMember> consultarMultiple() {
        return consultaGateway.consultarMultiple();
    }
}

