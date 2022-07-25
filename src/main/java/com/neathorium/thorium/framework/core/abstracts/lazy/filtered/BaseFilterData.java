package com.neathorium.thorium.framework.core.abstracts.lazy.filtered;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.core.abstracts.element.finder.BaseFilterParameters;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.Objects;
import java.util.function.Function;

public abstract class BaseFilterData<DependencyType, GetterType, FilterType, FilterMetaType, ResultListType, ResultType> implements Function<BaseFilterParameters<DependencyType, GetterType, ResultListType>, Function<DependencyType, Data<ResultType>>> {
    public final boolean isFiltered;
    public final Function<FilterMetaType, Function<FilterType, Function<DependencyType, Data<ResultType>>>> handler;
    public final FilterType filterParameter;

    public BaseFilterData(
        boolean isFiltered,
        Function<FilterMetaType, Function<FilterType, Function<DependencyType, Data<ResultType>>>> handler,
        FilterType filterParameter
    ) {
        this.isFiltered = isFiltered;
        this.handler = handler;
        this.filterParameter = filterParameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (BaseFilterData<?, ?, ?, ?, ?, ?>) o;
        return (
            EqualsPredicates.isEqual(isFiltered, that.isFiltered) &&
            EqualsPredicates.isEqual(handler, that.handler) &&
            EqualsPredicates.isEqual(filterParameter, that.filterParameter)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFiltered, handler, filterParameter);
    }

    @Override
    public String toString() {
        return (
            "BaseFilterData{" +
            "isFiltered=" + isFiltered +
            ", handler=" + handler +
            ", filterParameter=" + filterParameter +
            '}'
        );
    }
}
