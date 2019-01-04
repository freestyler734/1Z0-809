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
        // Для ссылочных типов проверяем на null
        return field1 + primeNumber * (name != null ? name.hashCode() : 0);
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
        // Для ссылочных типов проверяем на null
        if (this.name != null ? (!this.name.equals(exObject.name)) : exObject.name == null) {
            return false;
        }
        return true;
    }


//          СГЕНЕРИРОВАННЫЙ ВАРИАНТ
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Example example = (Example) o;
//
//        if (field1 != example.field1) return false;
//        return name != null ? name.equals(example.name) : example.name == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = field1;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }
}
