package com.company.designPatternsAndPrinciples.functionalInterfaces.animalExample;

public class Animal {

    private String species;// Вид
    private boolean canHop;// Прыгать
    private boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public boolean isCanHop() {
        return canHop;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    @Override
    public String toString() {
        return species;
    }
}
