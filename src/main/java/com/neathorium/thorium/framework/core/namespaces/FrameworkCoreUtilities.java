package com.neathorium.thorium.framework.core.namespaces;

import com.neathorium.thorium.framework.core.constants.lazy.LazyLocatorConstants;
import com.neathorium.thorium.framework.core.namespaces.extensions.boilers.LazyLocatorList;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.framework.core.selector.records.SelectorKeySpecificityData;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;
import com.neathorium.thorium.java.extensions.namespaces.factories.DecoratedListFactory;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EmptiablePredicates;
import com.neathorium.thorium.java.extensions.namespaces.predicates.GuardPredicates;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

public interface FrameworkCoreUtilities {
    static boolean isNullLazyLocator(LazyLocator data) {
        return isNull(data) || isBlank(data.LOCATOR) || isNull(data.STRATEGY);
    }

    static boolean areNullLazyLocator(Function<LazyLocator, String> locatorValidator, LazyLocator... data) {
        return GuardPredicates.areAll(locatorValidator, data);
    }

    static boolean areNullLazyLocator(LazyLocator... data) {
        return GuardPredicates.areAll(FrameworkCoreUtilities::isNullLazyLocator, data);
    }

    static boolean areNullLazyLocator(List<LazyLocator> data) {
        return areNullLazyLocator(data.toArray(LazyLocatorConstants.NULL_LAZY_LOCATOR_ARRAY));
    }

    static boolean isInvalidLazyLocatorList(LazyLocatorList list) {
        return EmptiablePredicates.isNullOrEmpty(list) || areNullLazyLocator(list.list);
    }

    static boolean isNotNullLazyData(LazyLocator data) {
        return !isNullLazyLocator(data);
    }

    static <T> boolean isNullAbstractLazyElementParametersList(Collection<T> data, Predicate<T> validator) {
        for(T params : data) {
            if (validator.test(params)) {
                return false;
            }
        }

        return true;
    }

    static Map<String, DecoratedList<SelectorKeySpecificityData>> getKeysCopy(Map<String, DecoratedList<SelectorKeySpecificityData>> source) {
        final var keys = source.keySet().iterator();
        final var values = source.values().iterator();

        final var map = Collections.synchronizedMap(new LinkedHashMap<String, DecoratedList<SelectorKeySpecificityData>>());
        while(keys.hasNext() && values.hasNext()) {
            map.putIfAbsent(keys.next(), DecoratedListFactory.getWith(values.next(), SelectorKeySpecificityData.class));
        }

        return map;
    }
}
