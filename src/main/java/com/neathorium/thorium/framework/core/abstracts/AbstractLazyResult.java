package com.neathorium.thorium.framework.core.abstracts;

import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class AbstractLazyResult<T>  {
    public final String NAME;
    public final Map<String, T> PARAMETERS;
    public final Predicate<T> VALIDATOR;

    public AbstractLazyResult(String name, Map<String, T> parameters, Predicate<T> validator) {
        this.NAME = name;
        this.PARAMETERS = parameters;
        this.VALIDATOR = validator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (AbstractLazyResult<?>) o;
        return (
            EqualsPredicates.isEqual(NAME, that.NAME) &&
            EqualsPredicates.isEqual(PARAMETERS, that.PARAMETERS) &&
            EqualsPredicates.isEqual(VALIDATOR, that.VALIDATOR)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, PARAMETERS, VALIDATOR);
    }

    @Override
    public String toString() {
        return (
            "AbstractLazyResult{" +
            "NAME='" + NAME + '\'' +
            ", PARAMETERS=" + PARAMETERS +
            ", VALIDATOR=" + VALIDATOR +
            '}'
        );
    }
}
