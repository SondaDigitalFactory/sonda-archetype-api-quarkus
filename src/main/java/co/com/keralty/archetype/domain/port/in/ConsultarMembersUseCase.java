package co.com.keralty.archetype.domain.port.in;

import co.com.keralty.archetype.domain.model.BhMppMember;

import java.util.List;

/**
 * Caso de uso de ejemplo para consultar miembros en el sistema legado.
 */
public interface ConsultarMembersUseCase {

    /**
     * Realiza una consulta simple de miembros.
     *
     * @return lista de miembros recuperados
     */
    List<BhMppMember> consultar();

    /**
     * Ejecuta una consulta multi tabla de miembros.
     *
     * @return lista resultante de la consulta múltiple
     */
    List<BhMppMember> consultarMultiple();
}

