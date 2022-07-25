package com.neathorium.thorium.framework.core.records.lazy;


import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.Objects;

public class LazyLocator {
    public final String LOCATOR;
    public final String STRATEGY;

    public LazyLocator(String locator, String strategy) {
        this.LOCATOR = locator;
        this.STRATEGY = strategy;
    }

    @Override
    public String toString() {
        return "LazyLocator - By." + STRATEGY + ": " + LOCATOR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (LazyLocator) o;
        return (
            EqualsPredicates.isEqual(LOCATOR, that.LOCATOR) &&
            EqualsPredicates.isEqual(STRATEGY, that.STRATEGY)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOCATOR, STRATEGY);
    }


}
