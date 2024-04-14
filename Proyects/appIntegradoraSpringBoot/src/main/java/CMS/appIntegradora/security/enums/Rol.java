package CMS.appIntegradora.security.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Rol implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
