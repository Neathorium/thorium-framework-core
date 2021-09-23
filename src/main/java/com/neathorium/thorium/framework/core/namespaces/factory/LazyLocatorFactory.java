package com.neathorium.thorium.framework.core.namespaces.factory;

import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;

public interface LazyLocatorFactory {
    static LazyLocator get(String locator, String strategy) {
        return new LazyLocator(locator, strategy);
    }
}
