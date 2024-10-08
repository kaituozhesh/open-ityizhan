package com.open.ityizhan.byteCode;

/**
 * @Description:
 * @ClassName: Test
 * @Auther: lin
 * @Date: 2024/10/8 14:43
 * @Version: 1.0
 */
public class Test {

    public int a = 3;
    static Integer si = 6;
    String s = "Hello World!";

    public static void main(String[] args) {
        Test test = new Test();
        test.a = 8;
        si = 9;
    }

    private void test() {
        this.a = a;
    }
}
