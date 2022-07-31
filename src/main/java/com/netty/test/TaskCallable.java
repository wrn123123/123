package com.netty.test;

public interface TaskCallable<T> {
    T callable(T t);
}
