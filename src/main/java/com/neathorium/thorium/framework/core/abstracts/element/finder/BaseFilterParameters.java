package com.neathorium.thorium.framework.core.abstracts.element.finder;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.core.namespaces.extensions.boilers.LazyLocatorList;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;


import java.util.Map;
import java.util.Objects;
import java.util.function.Function;


public abstract class BaseFilterParameters<DependencyType, GetterType, ReturnType> {
    public final LazyLocatorList LOCATORS;
    public final Map<GetterType, Function<LazyLocatorList, Function<DependencyType, Data<ReturnType>>>> GETTER_MAP;
    public final GetterType GETTER;

    public BaseFilterParameters(LazyLocatorList locators, Map<GetterType, Function<LazyLocatorList, Function<DependencyType, Data<ReturnType>>>> getterMap, GetterType getter) {
        this.LOCATORS = locators;
        this.GETTER_MAP = getterMap;
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

        final var that = (BaseFilterParameters<?, ?, ?>) o;
        return (
            EqualsPredicates.isEqual(LOCATORS, that.LOCATORS) &&
            EqualsPredicates.isEqual(GETTER_MAP, that.GETTER_MAP) &&
            EqualsPredicates.isEqual(GETTER, that.GETTER)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOCATORS, GETTER_MAP, GETTER);
    }

    @Override
    public String toString() {
        return (
            "BaseFilterParameters{" +
            "LOCATORS=" + LOCATORS +
            ", GETTER_MAP=" + GETTER_MAP +
            ", GETTER=" + GETTER +
            '}'
        );
    }
}
