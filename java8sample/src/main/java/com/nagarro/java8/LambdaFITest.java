package com.nagarro.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaFITest {
	public static void main(String[] args) {
		List<Person> personList = getPersonList();
		List<Person> result;

		TestInterface<Boolean, Person> testInterface = new TestInterfaceImpl();
		result = getPersonWithJava7(personList, testInterface);
		System.out.println(" Java 7 basic way ");
		displayPersonList(result);
		
		result = getPersonWithJava7(personList, new TestInterface<Boolean, Person>() {
			@Override
			public Boolean testValue(Person p) {
				return p.getAge() > 20 && p.getSalary() > 10000;
			}
		});
		System.out.println(" Java 7 Anonymous class way ");
		displayPersonList(result);
		result = getPersonWithJava8(personList, p -> p.getAge() > 20 && p.getSalary() > 10000);
		System.out.println(" Java 8 Branch Dev1 Lambda expression way   ");
		displayPersonList(result);
	}

	private static List<Person> getPersonWithJava8(List<Person> personList,
			TestInterface<Boolean, Person> testInterface) {
		List<Person> result = new ArrayList<Person>();
		for (Person person : personList) {
			if (testInterface.testValue(person)) {
				result.add(person);
			}
		}
		return result;
	}

	private static List<Person> getPersonWithJava7(List<Person> personList,
			TestInterface<Boolean, Person> testInterface) {
		List<Person> result = new ArrayList<Person>();
		for (Person person : personList) {
			if (testInterface.testValue(person)) {
				result.add(person);
			}
		}
		return result;
	}

	private static List<Person> getPersonList() {
		Person p1 = new Person("A", 21, 10000);
		Person p2 = new Person("B", 20, 12000);
		Person p3 = new Person("C", 23, 18000);
		Person p4 = new Person("D", 26, 20000);
		Person p5 = new Person("E", 22, 9000);
		Person p6 = new Person("F", 25, 220000);
		List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5, p6);
		return personList;
	}

	private static void displayPersonList(List<Person> personList) {
		personList.forEach(p -> System.out.println(p.getName()));
	}
}
