package com.neathorium.thorium.framework.core.namespaces;

import com.neathorium.thorium.core.data.constants.CoreDataConstants;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.core.namespaces.validators.FrameworkCoreFormatter;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;
import com.neathorium.thorium.java.extensions.classes.boilers.StringSet;
import com.neathorium.thorium.java.extensions.interfaces.ISizable;
import com.neathorium.thorium.java.extensions.interfaces.functional.TriFunction;
import com.neathorium.thorium.java.extensions.namespaces.predicates.BasicPredicates;


import java.util.function.Function;
import java.util.function.Predicate;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public interface FrameworkFunctions {
    static <T extends ISizable> Data<Integer> getAmount(
        String nameof,
        Data<T> sizable,
        TriFunction<Boolean, Integer, String, String> messageHandler,
        Predicate<Integer> condition,
        String elementName
    ) {
        final var localNameof = isNotBlank(nameof) ? nameof : "getAmount";
        final var errorMessage = FrameworkCoreFormatter.getAmountParameterErrorMessage(sizable, messageHandler, condition);
        if (isNotBlank(errorMessage)) {
            return DataFactoryFunctions.replaceName(CoreDataConstants.NULL_INTEGER, localNameof);
        }

        final var size = sizable.OBJECT().size();
        final var status = condition.test(size);
        return DataFactoryFunctions.getWith(size, status, nameof, messageHandler.apply(status, size, elementName));
    }

    static <T extends ISizable> Data<Integer> getCountOfElements(Data<T> data, String elementName) {
        return getAmount("getCountOfElements", data, FrameworkCoreFormatter::getCountOfTypeMessage, BasicPredicates::isNonNegative, elementName);
    }

    static <T extends ISizable> Data<Integer> getWindowHandleAmount(Data<T> data, String elementName) {
        return getAmount("getWindowHandleAmount", data, FrameworkCoreFormatter::getCountOfTypeMessage, BasicPredicates::isPositiveNonZero, elementName);
    }

    static <T> Function<Data<DecoratedList<?>>, Data<Integer>> getCountOfElements(String elementName) {
        return data -> getCountOfElements(data, elementName);
    }

    static Function<Data<StringSet>, Data<Integer>> getWindowHandleAmount(String elementName) {
        return data -> getWindowHandleAmount(data, elementName);
    }
}
