package com.neathorium.thorium.framework.core.namespaces.factory;

import com.neathorium.thorium.framework.core.records.credentials.Credentials;
import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;

public interface CredentialsFactory {
    static Credentials getWith(String username, String password, String description) {
        return new Credentials(username, password, description);
    }

    static Credentials getWithDefaultDescription(String username, String password) {
        return getWith(username, password, CoreFormatterConstants.EMPTY);
    }
}
