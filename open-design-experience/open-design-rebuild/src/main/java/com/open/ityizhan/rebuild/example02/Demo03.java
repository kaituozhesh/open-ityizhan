package com.open.ityizhan.rebuild.example02;

/**
 * @Description:
 * @ClassName: Demo03
 * @Auther: lin
 * @Date: 2024/8/5 13:42
 * @Version: 1.0
 */
public class Demo03 {


    class version01 {
        int discount(int inputVal, int quantity, int yearToDate) {
            if (inputVal > 50) inputVal -= 2;
            if (quantity > 100) inputVal -= 1;
            if (yearToDate > 10000) inputVal -= 4;
            return inputVal;
        }
    }

    class version02 {
        int discount(int inputVal, int quantity, int yearToDate) {
            int result = inputVal;
            if (inputVal > 50) result -= 2;
            if (quantity > 100) result -= 1;
            if (yearToDate > 10000) result -= 4;
            return result;
        }
    }

    class version03 {
        int discount(final int inputVal, final int quantity, final int yearToDate) {
            int result = inputVal;
            if (inputVal > 50) result -= 2;
            if (quantity > 100) result -= 1;
            if (yearToDate > 10000) result -= 4;
            return result;
        }
    }

    static class A {
        String name;

        public A(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        A a = new A("a");
        aa(a);
        System.out.println(a);
    }

    public static void aa(A a) {
        a = new A("b");
        System.out.println(a);
    }

}
