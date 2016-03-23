package com.parsley;

public interface Parser<T, J> {
    J parse(T t);

    Class<T> getObjectClass();

    Class<J> getTargetClass();
}
