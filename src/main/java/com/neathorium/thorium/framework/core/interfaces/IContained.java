package com.neathorium.thorium.framework.core.interfaces;

import java.util.function.Function;

@FunctionalInterface
public interface IContained<ParameterType, ReturnType> {
    Function<ParameterType, ReturnType> get();
}
