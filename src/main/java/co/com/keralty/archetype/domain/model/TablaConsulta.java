package co.com.keralty.archetype.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TablaConsulta {
    MEMBERS("BH_MPP_MEMBER"),
    PERSON("BH_PERSONAS"),
    INSTITUTION("BH_INSTITUTION"),
    PLAN("BH_PLAN"),
    CONTRACT("BH_MPP_CONTRACT"),
    COVER("BH_MPP_COVER"),
    MEMBER("BH_MEMBER"),
    AFF_CONTRACT("BH_AFF_CONTRACT"),
    CONTRACT_DETAIL("BH_CONTRACT"),
    MEM_STATUS_HISTO("BH_MEM_STATUS_HISTO"),
    PRODUCT("BH_PRODUCT"),
    IDENT_TYPE("BH_IDENT_TYPE");

    private final String nombre;
}

