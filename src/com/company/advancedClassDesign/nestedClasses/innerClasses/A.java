package com.company.advancedClassDesign.nestedClasses.innerClasses;

public class A {
    private int x = 10;
    public class B {
        private int x = 20;
        public class C {
            private int x = 30;

            public void printAllX() {
                System.out.println(x);
                System.out.println(this.x);
                System.out.println(B.this.x);
                System.out.println(A.B.this.x);
                System.out.println(A.this.x);

            }

        }
    }
}
