package com.neathorium.thorium.framework.core.abstracts;

import com.neathorium.thorium.core.extensions.DecoratedList;
import com.neathorium.thorium.framework.core.selector.records.SelectorKeySpecificityData;
import com.neathorium.thorium.core.extensions.namespaces.CoreUtilities;
import com.neathorium.thorium.core.extensions.namespaces.NullableFunctions;
import com.neathorium.thorium.core.records.Data;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractExternalElementData<T> {
    public final Map<String, DecoratedList<SelectorKeySpecificityData>> TYPE_KEYS;
    public final Data<T> FOUND;

    public AbstractExternalElementData(Map<String, DecoratedList<SelectorKeySpecificityData>> typeKeys, Data<T> found) {
        this.TYPE_KEYS = typeKeys;
        this.FOUND = found;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (NullableFunctions.isNull(o) || CoreUtilities.isNotEqual(getClass(), o.getClass())) {
            return false;
        }

        final var that = (AbstractExternalElementData<?>) o;
        return (
            CoreUtilities.isEqual(TYPE_KEYS, that.TYPE_KEYS) &&
            CoreUtilities.isEqual(FOUND, that.FOUND)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(TYPE_KEYS, FOUND);
    }

    @Override
    public String toString() {
        return (
            "AbstractExternalElementData{" +
            "TYPE_KEYS=" + TYPE_KEYS +
            ", FOUND=" + FOUND +
            '}'
        );
    }
}