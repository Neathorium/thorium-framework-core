package com.neathorium.thorium.framework.core.abstracts;

import com.neathorium.thorium.framework.core.records.lazy.ExternalSelectorData;
import com.neathorium.thorium.framework.core.records.InternalSelectorData;
import com.neathorium.thorium.framework.core.records.ProbabilityData;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.Objects;

public abstract class AbstractLazyElementWithOptionsData<
    FilterType,
    ElementType extends AbstractLazyResult<FilterType>,
    DependencyType,
    ExternalSelectorDataType extends ExternalSelectorData<DependencyType>
> {
    public final ElementType ELEMENT;
    public final InternalSelectorData INTERNAL_DATA;
    public final ExternalSelectorDataType EXTERNAL_DATA;
    public final DecoratedList<String> GET_ORDER;
    public final ProbabilityData PROBABILITY_DATA;

    public AbstractLazyElementWithOptionsData(ElementType element, InternalSelectorData internalData, ExternalSelectorDataType externalData, DecoratedList<String> getOrder, ProbabilityData probabilityData) {
        this.ELEMENT = element;
        this.INTERNAL_DATA = internalData;
        this.EXTERNAL_DATA = externalData;
        this.GET_ORDER = getOrder;
        this.PROBABILITY_DATA = probabilityData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (AbstractLazyElementWithOptionsData<?, ?, ?, ?>) o;
        return (
            EqualsPredicates.isEqual(ELEMENT, that.ELEMENT) &&
            EqualsPredicates.isEqual(INTERNAL_DATA, that.INTERNAL_DATA) &&
            EqualsPredicates.isEqual(EXTERNAL_DATA, that.EXTERNAL_DATA) &&
            EqualsPredicates.isEqual(GET_ORDER, that.GET_ORDER) &&
            EqualsPredicates.isEqual(PROBABILITY_DATA, that.PROBABILITY_DATA)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(ELEMENT, INTERNAL_DATA, EXTERNAL_DATA, GET_ORDER, PROBABILITY_DATA);
    }

    @Override
    public String toString() {
        return (
            "AbstractLazyElementWithOptionsData{" +
            "ELEMENT=" + ELEMENT +
            ", INTERNAL_DATA=" + INTERNAL_DATA +
            ", EXTERNAL_DATA=" + EXTERNAL_DATA +
            ", GET_ORDER=" + GET_ORDER +
            ", PROBABILITY_DATA=" + PROBABILITY_DATA +
            '}'
        );
    }
}
