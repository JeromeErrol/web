package com.saltmarsh.springparse.domain;

public interface IParse<T, J> {
    J parse(T t);

    Class<T> getObjectClass();

    Class<J> getTargetClass();
}
