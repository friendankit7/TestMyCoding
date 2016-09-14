package com.nagarro.java8;

public class TestInterfaceImpl implements TestInterface<Boolean, Person>{

	@Override
	public Boolean testValue(Person p) {
		return  ( p.getAge()> 20 && p.getSalary()>10000);
	}

}
