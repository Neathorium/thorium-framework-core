package com.neathorium.thorium.framework.core.constants;

import com.neathorium.thorium.framework.core.namespaces.factory.InternalSelectorDataFactory;
import com.neathorium.thorium.framework.core.records.InternalSelectorData;

public abstract class SelectorDataConstants {
    public static final InternalSelectorData INTERNAL_SELECTOR_DATA = InternalSelectorDataFactory.getWithDefaults();
}
