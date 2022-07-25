package com.neathorium.thorium.framework.core.records.lazy;

import com.neathorium.thorium.java.extensions.namespaces.predicates.BasicPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.Objects;

public class LazyElementParameters<ListType> {
    public final ListType LAZY_LOCATORS;
    public final String GETTER;
    public double PROBABILITY;

    public LazyElementParameters(double probability, ListType lazyLocators, String getter) {
        this.PROBABILITY = probability;
        this.LAZY_LOCATORS = lazyLocators;
        this.GETTER = getter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (LazyElementParameters<?>) o;
        return (
            BasicPredicates.isZero(Double.compare(that.PROBABILITY, PROBABILITY)) &&
            EqualsPredicates.isEqual(LAZY_LOCATORS, that.LAZY_LOCATORS) &&
            EqualsPredicates.isEqual(GETTER, that.GETTER)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(LAZY_LOCATORS, GETTER, PROBABILITY);
    }

    @Override
    public String toString() {
        return (
            "LazyElementParameters{lazyLocators=" +
            LAZY_LOCATORS +
            ", getter='" +
            GETTER +
            "', probability=" +
            PROBABILITY +
            '}'
        );
    }
}
