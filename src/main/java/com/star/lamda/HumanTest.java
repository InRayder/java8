package com.star.lamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HumanTest {

	public static int compareByNameThenAge(Human lhs, Human rhs) {
		if (lhs.getName().equals(rhs.getName())) {
			return lhs.getAge() - rhs.getAge();
		} else {
			return lhs.getName().compareTo(rhs.getName());
		}
	}

	@Test
	public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("Sarah", 10));
		humans.add(new Human("Jack", 12));
		Collections.sort(humans, new Comparator<Human>() {
			@Override
			public int compare(Human o1, Human o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		Assert.assertEquals(humans.get(0).getName(), "Jack");
	}

	@Test
	public void whenSortingEntitiesByName_thenCorrectlySorted() {
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("Sarah", 10));
		humans.add(new Human("Jack", 12));
		humans.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		Assert.assertEquals(humans.get(0).getName(), "Jack");
	}

	@Test
	public void givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("Sarah", 10));
		humans.add(new Human("Jack", 12));
		humans.sort(HumanTest::compareByNameThenAge);
		Assert.assertEquals(humans.get(0).getName(), "Jack");
	}

	@Test
	public void whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("Sarah", 10));
		humans.add(new Human("Jack", 12));
		Comparator<Human> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		humans.sort(comparator.reversed());
		Assert.assertEquals(humans.get(0).getName(), "Sarah");
	}
}
