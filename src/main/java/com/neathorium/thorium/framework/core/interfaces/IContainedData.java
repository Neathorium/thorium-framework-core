package com.neathorium.thorium.framework.core.interfaces;

import com.neathorium.thorium.core.data.records.Data;
import java.util.function.Function;

@FunctionalInterface
public interface IContainedData<T, U> extends IContained<T, Data<U>> {
    Function<T, Data<U>> get();
}