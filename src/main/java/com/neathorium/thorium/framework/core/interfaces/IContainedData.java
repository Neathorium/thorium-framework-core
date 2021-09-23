package com.neathorium.thorium.framework.core.interfaces;

import com.neathorium.thorium.core.extensions.interfaces.functional.boilers.IContained;
import com.neathorium.thorium.core.records.Data;

import java.util.function.Function;

@FunctionalInterface
public interface IContainedData<T, U> extends IContained<T, Data<U>> {
    Function<T, Data<U>> get();
}