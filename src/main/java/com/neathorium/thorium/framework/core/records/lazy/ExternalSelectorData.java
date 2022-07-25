package com.neathorium.thorium.framework.core.records.lazy;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.core.records.command.CommandRangeData;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ExternalSelectorData<T> {
    public final BiFunction<String, List<String>, Function<T, Data<String>>> GET_SELECTOR;
    public final String PREFERRED_PROPERTIES;
    public final String SELECTOR_TYPE;
    public final CommandRangeData RANGE;
    public final int LIMIT;
    public final Data<String> DEFAULT_SELECTOR;

    public ExternalSelectorData(
        BiFunction<String, List<String>, Function<T, Data<String>>> getSelector,
        String preferredProperties,
        String selectorType,
        CommandRangeData range,
        int limit,
        Data<String> defaultSelector
    ) {
        this.GET_SELECTOR = getSelector;
        this.PREFERRED_PROPERTIES = preferredProperties;
        this.SELECTOR_TYPE = selectorType;
        this.RANGE = range;
        this.LIMIT = limit;
        this.DEFAULT_SELECTOR = defaultSelector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (ExternalSelectorData<?>) o;
        return (
            EqualsPredicates.isEqual(LIMIT, that.LIMIT) &&
            EqualsPredicates.isEqual(GET_SELECTOR, that.GET_SELECTOR) &&
            EqualsPredicates.isEqual(PREFERRED_PROPERTIES, that.PREFERRED_PROPERTIES) &&
            EqualsPredicates.isEqual(SELECTOR_TYPE, that.SELECTOR_TYPE) &&
            EqualsPredicates.isEqual(RANGE, that.RANGE) &&
            EqualsPredicates.isEqual(DEFAULT_SELECTOR, that.DEFAULT_SELECTOR)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(GET_SELECTOR, PREFERRED_PROPERTIES, SELECTOR_TYPE, RANGE, LIMIT, DEFAULT_SELECTOR);
    }

    @Override
    public String toString() {
        return (
            "ExternalSelectorData{" +
            "GET_SELECTOR=" + GET_SELECTOR +
            ", PREFERRED_PROPERTIES='" + PREFERRED_PROPERTIES + '\'' +
            ", SELECTOR_TYPE='" + SELECTOR_TYPE + '\'' +
            ", RANGE=" + RANGE +
            ", LIMIT=" + LIMIT +
            ", DEFAULT_SELECTOR=" + DEFAULT_SELECTOR +
            '}'
        );
    }
}
