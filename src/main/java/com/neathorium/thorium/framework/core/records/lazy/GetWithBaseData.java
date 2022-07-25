package com.neathorium.thorium.framework.core.records.lazy;



import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.Objects;
import java.util.function.Function;

public class GetWithBaseData<DependencyType, T, U, V, W> {
    public final T LOCATORS;
    public final Function<T, U> LOCATOR_GETTER;
    public final Function<V, Function<DependencyType, Data<W>>> GETTER;
    public final Data<W> GUARD_DATA;

    public GetWithBaseData(T locators, Function<T, U> locatorGetter, Function<V, Function<DependencyType, Data<W>>> getter, Data<W> guardData) {
        this.LOCATORS = locators;
        this.LOCATOR_GETTER = locatorGetter;
        this.GETTER = getter;
        this.GUARD_DATA = guardData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (GetWithBaseData<?, ?, ?, ?, ?>) o;
        return (
            EqualsPredicates.isEqual(LOCATORS, that.LOCATORS) &&
            EqualsPredicates.isEqual(LOCATOR_GETTER, that.LOCATOR_GETTER) &&
            EqualsPredicates.isEqual(GETTER, that.GETTER) &&
            EqualsPredicates.isEqual(GUARD_DATA, that.GUARD_DATA)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOCATORS, LOCATOR_GETTER, GETTER, GUARD_DATA);
    }

    @Override
    public String toString() {
        return (
            "GetWithBaseData{" +
            "LOCATORS=" + LOCATORS +
            ", LOCATOR_GETTER=" + LOCATOR_GETTER +
            ", GETTER=" + GETTER +
            ", GUARD_DATA=" + GUARD_DATA +
            '}'
        );
    }
}
