package com.neathorium.thorium.framework.core.records;

import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.java.extensions.classes.DecoratedList;

import java.util.function.BiFunction;
import java.util.function.Function;

public record GetElementByData<T, ElementType, ListType extends DecoratedList<ElementType>> (
    String NAMEOF,
    BiFunction<Data<ListType>, T, String> VALIDATOR,
    BiFunction<Data<ListType>, T, ElementType> GETTER,
    Function<GetByFilterFormatterData<T>, String> FORMATTER,
    Data<ElementType> DEFAULT_VALUE,
    String FILTER_NAME
){}