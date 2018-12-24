package com.company.advancedClassDesign.enums;

// Перечисления не могут быть участниками наследования.
// Константы - это экземпляры класса наследника(под какоптом анонимные классы) enum(в данном случае Season).
// Cам enum(в данном случае Season) - наследник класса Enum(под капотом).
// Под капотом, анонимные классы констант создаются в статическом блоке инициализации.
// Т.о. enum - своеобразная реализация фабрики.
// Поля и методы констант - как у обычных классов.
public enum Season {
    SUMMER("Low") {
        @Override
        public void printSmth() {
            System.out.println(this + " smth");
        }
    },
    FALL() { // можно указыать фигурные скобки, даже если нет конструкторов

        // Переопределяем родительский метод
        @Override
        public void getInfo() {
            System.out.println("Fall season period");
            super.getInfo();
        }

        @Override
        public void printSmth() {
            System.out.println(this + " smth");
        }
    },
    WINTER {
        @Override
        public void printSmth() {
            System.out.println(this + " smth");
        }

        int i=0;

        // метод не будет доступен у константы,
        // так как константы должны иметь те же и поля, что родитель (сам enum Season).
        // К тому же константы экземпляры того же класса что и перечисление
        public void printSpecial(){
            System.out.println(this+": special");
        }
    },
    SPRING {
        @Override
        public void printSmth() {
            System.out.println(this + " smth");
        }
    }; // ; после констант можно опускать, ТОЛЬКО если после констант нет больше кода(методы, конструкторы)

    // модификатор доступа м.б. любой
    private String visitorsStatus;

    private int avgTemperature;

    // конструктор м.б. только private () (потому что enum - своеобразная реализация фабрики)
    // private можно опускать, тогда при компиляции, он добавится автоматически
    private Season(){

    }

    private Season(String visitorsStatus) {
        this.visitorsStatus = visitorsStatus;
    }

    // модификатор доступа м.б. любой
    public void printVisitorsStatus() {
        System.out.println(this + " visitorsStatus: " + visitorsStatus);
    }

    public void printAvgTemperature(){
        System.out.println(this + " avgTemperature: " + avgTemperature);
    }

    public void setAvgTemperature(int avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    // Объявляем общий метод, который переопределим в некоторых из них
    public void getInfo() {
        System.out.println("Season period");
    }

    // Объявляем абстрактный метод, который ВСЕ константы должны реализовать
    public abstract void printSmth();
}
