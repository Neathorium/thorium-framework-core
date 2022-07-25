package com.neathorium.thorium.framework.core.selector.records;

import com.neathorium.selector.specificity.tuples.SpecificityData;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.Objects;

public class SelectorKeySpecificityData {
    public final String selectorKey;
    public final SpecificityData specifics;

    public SelectorKeySpecificityData(String selectorKey, SpecificityData specifics) {
        this.selectorKey = selectorKey;
        this.specifics = specifics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (SelectorKeySpecificityData) o;
        return (
            EqualsPredicates.isEqual(selectorKey, that.selectorKey) &&
            EqualsPredicates.isEqual(specifics, that.specifics)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectorKey, specifics);
    }

    @Override
    public String toString() {
        return ("SelectorKeySpecificityData{selectorKey='" + selectorKey + "\', specifics=" + specifics + '}');
    }
}
