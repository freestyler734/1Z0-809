package com.company.designPatternsAndPrinciples.functionalInterfaces.animalExample;

import java.util.function.Predicate;

public class FindMatchingAnimals {

    private static void print(Animal a, Predicate<Animal> trait) {
        if (trait.test(a)) {
            System.out.println(a);
        }
    }

    private static void myPrint(Animal animal, CheckTrait trait) {
        if (trait.test(animal)) {
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        myPrint(new Animal("fish", false, true), a -> a.isCanHop());
        myPrint(new Animal("kangaroo", true, true), (Animal a) -> {return a.isCanHop();});
        System.out.println("===========================================");

        print(new Animal("fish", false, true), a -> a.isCanHop());
        print(new Animal("kangaroo", true, true), (Animal a) -> {return a.isCanHop();});
    }
}
