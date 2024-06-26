package com.neathorium.thorium.framework.core.namespaces.validators;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.framework.core.abstracts.AbstractLazyResult;
import com.neathorium.thorium.framework.core.abstracts.AbstractLazyElementWithOptionsData;
import com.neathorium.thorium.framework.core.records.GetByFilterFormatterData;
import com.neathorium.thorium.framework.core.records.InternalSelectorData;
import com.neathorium.thorium.framework.core.records.ProbabilityData;
import com.neathorium.thorium.framework.core.records.lazy.ExternalSelectorData;
import com.neathorium.thorium.framework.core.records.lazy.LazyLocator;
import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.namespaces.validators.CoreFormatter;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;
import com.neathorium.thorium.java.extensions.interfaces.functional.TriFunction;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.neathorium.thorium.core.namespaces.validators.CoreFormatter.getNamedErrorMessageOrEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

public interface FrameworkCoreFormatter {
    static String getCountOfTypeMessage(boolean status, int value, String type) {
        return (status ? value : "No") + " " + type + " found" + CoreFormatterConstants.END_LINE;
    }

    static <T> String getLazyParameterErrorMessage(AbstractLazyResult<T> element, String nameof) {
        var message = isNullLazyElementMessage(element) + CoreFormatter.isBlankMessageWithName(nameof, "Name of the function");
        return getNamedErrorMessageOrEmpty("getLazyParameterErrorMessage", message);
    }

    static String getInternalSelectorDataMessage(InternalSelectorData internalData) {
        var message = CoreFormatter.isNullMessageWithName(internalData, "Internal Data");
        if (isBlank(message)) {
            message += CoreFormatter.getCommandAmountRangeErrorMessage(internalData.LIMIT(), internalData.RANGE());
        }

        return getNamedErrorMessageOrEmpty("getInternalSelectorDataMessage", message);
    }

    static <T> String getExternalSelectorDataMessage(ExternalSelectorData<T> object) {
        var message = CoreFormatter.isNullMessageWithName(object, "External Selector Data");
        if (isBlank(message)) {
            message += (
                CoreFormatter.isNullMessageWithName(object.GET_SELECTOR, "Selector getter function") +
                CoreFormatter.isNullMessageWithName(object.PREFERRED_PROPERTIES, "Preferred properties ") +
                CoreFormatter.isNullMessageWithName(object.SELECTOR_TYPE, "Selector type") +
                CoreFormatter.getCommandAmountRangeErrorMessage(object.LIMIT, object.RANGE) +
                CoreFormatter.isNullMessageWithName(object.DEFAULT_SELECTOR, "Default Selector value")
            );
        }
        return getNamedErrorMessageOrEmpty("getExternalSelectorDataMessage", message);
    }

    static <T, U> String getExternalSelectorDataErrorMessage(AbstractLazyResult<T> element, ExternalSelectorData<U> externalData, String nameof) {
        return getNamedErrorMessageOrEmpty(
            "getExternalSelectorDataErrorMessage",
            (
                CoreFormatter.isBlankMessageWithName(nameof, "Name of the function") +
                getLazyParameterErrorMessage(element, nameof) +
                getExternalSelectorDataMessage(externalData)
            )
        );
    }

    static <T> String isNullLazyElementParametersMessage(String name, Map<String, T> parameters, Predicate<T> validator) {
        var message = (
            CoreFormatter.isBlankMessageWithName(name, "Element name") +
            CoreFormatter.isNullMessageWithName(parameters, "Element parameters") +
            CoreFormatter.isNullMessageWithName(validator, "Element validator")
        );
        if (isBlank(message)) {
            message += CoreFormatter.areInvalidParametersMessage(parameters.values(), validator);
        }

        return getNamedErrorMessageOrEmpty("isNullLazyElementParametersMessage", message);
    }

    static <T> String isNullLazyElementMessage(AbstractLazyResult<T> object) {
        var message = CoreFormatter.isNullMessageWithName(object, "Lazy Element");
        if (isBlank(message)) {
            message += isNullLazyElementParametersMessage(object.NAME, object.PARAMETERS, object.VALIDATOR);
        }

        return getNamedErrorMessageOrEmpty("isNullLazyElementMessage", message);
    }

    static <T> String getAmountParameterErrorMessage(
        Data<T> sizable,
        TriFunction<Boolean, Integer, String, String> messageHandler,
        Predicate<Integer> condition
    ) {
        return getNamedErrorMessageOrEmpty("getAmountParameterErrorMessage", (
            CoreFormatter.isInvalidOrFalseMessage(sizable) +
            CoreFormatter.isNullMessageWithName(messageHandler, "Message Handler") +
            CoreFormatter.isNullMessageWithName(condition, "Condition")
        ));
    }

    static <T> String getLazyResultWithExternalMessage(String nameof, AbstractLazyResult<T> element, InternalSelectorData internalData, DecoratedList<String> getOrder, ProbabilityData data) {
        return getNamedErrorMessageOrEmpty("getLazyResultWithExternalMessage", (
            getLazyParameterErrorMessage(element, nameof) +
            getInternalSelectorDataMessage(internalData) +
            CoreFormatter.getListNotEnoughMessage(getOrder, "GetOrder list", 1) +
            CoreFormatter.isNullMessageWithName(data, "Probability data")
        ));
    }

    static <T> String getLazyResultWithOptionsMessage(AbstractLazyElementWithOptionsData<?, ?, ?, ?> data, String nameof) {
        var message = CoreFormatter.isNullMessageWithName(data, "Data");
        if (isBlank(message)) {
            message += getLazyResultWithExternalMessage(nameof, data.ELEMENT, data.INTERNAL_DATA, data.GET_ORDER, data.PROBABILITY_DATA);
        }

        return getNamedErrorMessageOrEmpty("getLazyResultWithOptionsMessage", message);
    }

    static String getElementsAmountMessage(String locator, boolean status, int expectedSize, int size) {
        return (status ? expectedSize : (size > 0 ? "Wrong(" + expectedSize + ") amount of" : "No")) + " elements found by: " + locator + CoreFormatterConstants.END_LINE;
    }

    static <T> String isInvalidLocatorMessage(String locator, Function<String, T> locatorGetter) {
        final var parameterName = "Lazy locator";
        var message = (
            CoreFormatter.isNullMessageWithName(locator, parameterName) +
            CoreFormatter.isNullMessageWithName(locatorGetter, parameterName + " getter")
        );

        if (isBlank(message)) {
            message += CoreFormatter.isNullMessageWithName(locatorGetter.apply(locator), "Actual locator from locator");
        }

        return getNamedErrorMessageOrEmpty("isNotNullLazyDataMessage", message);
    }

    static <T> String isInvalidLazyLocatorMessage(LazyLocator locator, Function<LazyLocator, T> locatorGetter) {
        final var parameterName = "Lazy locator";
        var message = (
            CoreFormatter.isNullMessageWithName(locator, parameterName) +
            CoreFormatter.isNullMessageWithName(locatorGetter, parameterName + " getter")
        );
        if (isBlank(message)) {
            message += (
                CoreFormatter.isNullMessageWithName(locator.LOCATOR, parameterName + " value") +
                CoreFormatter.isNullMessageWithName(locator.STRATEGY, parameterName + " strategy")
            );
        }

        if (isBlank(message)) {
            message += CoreFormatter.isNullMessageWithName(locatorGetter.apply(locator), "Actual locator from locator");
        }

        return getNamedErrorMessageOrEmpty("isInvalidLazyLocatorMessage", message);
    }

    static String getProbabilityAdjustmentMessage(String key, double original, double adjusted, boolean increase, boolean generated, boolean belowThreshold) {
        var message = (increase ? "Increased" : "Reduced") + " probability of selector(\"" + original + "\") to \"" + adjusted + "\"" + CoreFormatterConstants.END_LINE;
        if (belowThreshold) {
            message += (generated ? "External" : "Regular") + "selector by key(\"" + key + "\") is below threshold(\"" + adjusted + "\"), set to \"0.0\"" + CoreFormatterConstants.END_LINE;
        }

        return message;
    }

    static <T> String getInvalidGetByFilterFormatterDataMessage(GetByFilterFormatterData<T> data) {
        var message = CoreFormatter.isNullMessageWithName(data, "Get By filter data");
        if (isBlank(message)) {
            message += (
                CoreFormatter.isMoreThanExpectedMessage(data.LIST_SIZE(), -1, "List size") +
                CoreFormatter.isBlankMessageWithName(data.FILTER_NAME(), "Filter name") +
                CoreFormatter.isBlankMessageWithName(data.MESSAGE(), "Message") +
                CoreFormatter.isNullMessageWithName(data.FILTER(), "Filter") +
                CoreFormatter.isNullMessage(data.STATUS())
            );
        }

        return getNamedErrorMessageOrEmpty("getInvalidGetByFilterFormatterDataMessage", message);
    }

    static <T> String getByFilterMessage(GetByFilterFormatterData<T> data) {
        var message = getInvalidGetByFilterFormatterDataMessage(data);
        return isBlank(message) ? (
            data.FILTER_NAME() + " was" + (data.STATUS() ? "" : "n't") + " found by " + data.FILTER_NAME() + "(\"" + data.FILTER() + "\"), list size: " + data.LIST_SIZE() + CoreFormatterConstants.END_LINE + message
        ) : message;
    }
}
