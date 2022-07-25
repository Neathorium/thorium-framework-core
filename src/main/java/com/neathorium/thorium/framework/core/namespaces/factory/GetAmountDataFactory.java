package com.neathorium.thorium.framework.core.namespaces.factory;

import com.neathorium.thorium.framework.core.namespaces.validators.FrameworkCoreFormatter;
import com.neathorium.thorium.framework.core.records.GetAmountData;
import com.neathorium.thorium.java.extensions.interfaces.functional.TriFunction;

import java.util.function.Predicate;

public interface GetAmountDataFactory {
    static GetAmountData getWith(String nameof, TriFunction<Boolean, Integer, String, String> messageHandler, Predicate<Integer> condition, String elementName) {
        return new GetAmountData(nameof, messageHandler, condition, elementName);
    }

    static GetAmountData getWithDefaultMessageHandler(String nameof, Predicate<Integer> condition, String elementName) {
        return getWith(nameof, FrameworkCoreFormatter::getCountOfTypeMessage, condition, elementName);
    }
}
