package com.nagarro.java8;

import java.util.Arrays;
import java.util.List;

public class StreamAPITest {

	public static void main(String[] args) {
		List<Person> personList = getPersonList();
		getPersonWithJava7(personList);
		System.out.println("*****************************************");
		getPersonWithJava8(personList);

	}

	private static void getPersonWithJava8(List<Person> personList) {
		personList.stream().filter(p -> p.getAge() > 20 && p.getSalary() > 10000)
				.forEach(p -> System.out.println(p.getName()));
		
	}

	private static void getPersonWithJava7(List<Person> personList) {
		for (Person person : personList) {
			if (person.getAge() > 20 && person.getSalary() > 10000) {
				System.out.println(person.getName());
			}
		} 

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
}
