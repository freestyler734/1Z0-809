package com.company.advancedClassDesign.equalsHashCode;

public class Example {

    private int field1;
    private String name;

    public Example(int field1, String name) {
        this.field1 = field1;
        this.name = name;
    }

    public static void main(String[] args) {

    }

    @Override
    public int hashCode() {
        int primeNumber = 31;
        return field1 + primeNumber * name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) { // Можно использовать instanceof, но это эффективней
            return false;
        }
        Example exObject = (Example) obj;
        if (this.field1 != exObject.field1) {
            return false;
        }
        if (!this.name.equals(exObject.name)) {
            return false;
        }
        return true;
    }
}
