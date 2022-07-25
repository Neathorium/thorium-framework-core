package com.neathorium.thorium.framework.core.records;


import com.neathorium.thorium.java.extensions.interfaces.functional.TriFunction;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.function.Predicate;

public record GetAmountData(String NAMEOF, TriFunction<Boolean, Integer, String, String> MESSAGE_HANDLER, Predicate<Integer> CONDITION, String ELEMENT_NAME) {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (GetAmountData) o;
        return (
            EqualsPredicates.isEqual(NAMEOF, that.NAMEOF) &&
            EqualsPredicates.isEqual(MESSAGE_HANDLER, that.MESSAGE_HANDLER) &&
            EqualsPredicates.isEqual(CONDITION, that.CONDITION) &&
            EqualsPredicates.isEqual(ELEMENT_NAME, that.ELEMENT_NAME)
        );
    }
}
