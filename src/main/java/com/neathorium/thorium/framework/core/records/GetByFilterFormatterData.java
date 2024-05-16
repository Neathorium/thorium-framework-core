package com.neathorium.thorium.framework.core.records;

public record GetByFilterFormatterData<T>(T FILTER, String FILTER_NAME, boolean STATUS, int LIST_SIZE, String MESSAGE) {}