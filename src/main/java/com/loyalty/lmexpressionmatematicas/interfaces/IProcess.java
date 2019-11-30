package com.loyalty.lmexpressionmatematicas.interfaces;
@FunctionalInterface
public interface IProcess<T, U> {
    @SuppressWarnings("unchecked")
    T process(U... params);
}