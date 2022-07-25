package com.neathorium.thorium.framework.core.records;

import com.neathorium.thorium.core.records.command.CommandRangeData;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.NullablePredicates;

import java.util.Objects;

public class InternalSelectorData {
    public final CommandRangeData RANGE;
    public final int LIMIT;

    public InternalSelectorData(CommandRangeData range, int limit) {
        this.RANGE = range;
        this.LIMIT = limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (NullablePredicates.isNull(o) || EqualsPredicates.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (InternalSelectorData) o;
        return (
            EqualsPredicates.isEqual(LIMIT, that.LIMIT) &&
            EqualsPredicates.isEqual(RANGE, that.RANGE)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(RANGE, LIMIT);
    }

    @Override
    public String toString() {
        return (
            "InternalSelectorData{" +
            "RANGE=" + RANGE +
            ", LIMIT=" + LIMIT +
            '}'
        );
    }
}
