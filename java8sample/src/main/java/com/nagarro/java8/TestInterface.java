package com.nagarro.java8;

@FunctionalInterface
public interface TestInterface<T,V> {
	T testValue(V v);
}
