package edu.course.lab03;

import java.util.*;

public class Task02PrimesGenerator implements Iterable<Integer> {
    private final List<Integer> primesList = new ArrayList<>();

    public Task02PrimesGenerator(int n){
        int number = 2;
        while (primesList.size()< n){
            if (isPrime(number)) primesList.add(number);
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; (long) i * i <= number; i++)
            if (number % i == 0) return false;
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return primesList.iterator();
    }

    public Iterator<Integer> reverseIterator() {
        return new Iterator<>() {
            private int idx = primesList.size() - 1;
            @Override public boolean hasNext() { return idx >= 0; }
            @Override public Integer next()     { return primesList.get(idx--); }
        };
    }
}