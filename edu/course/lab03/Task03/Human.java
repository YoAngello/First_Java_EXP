package edu.course.lab03.Task03;

import java.util.Objects;

public class Human implements Comparable<Human>{
    private final String firstName;
    private final String lastName;
    private final int age;

    public Human(String firstname, String lastName, int age){
        this.firstName = firstname;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    @Override
    public int compareTo(Human obj){
        int ageCompare = Integer.compare(this.age, obj.age);
        if (ageCompare != 0) return ageCompare;

        int lastNameCompare = this.lastName.compareTo(obj.lastName);
        if (lastNameCompare != 0) return lastNameCompare;

        return this.firstName.compareTo(obj.firstName);
    }

    // Необходимы для корректной работы HashSet и LinkedHashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
