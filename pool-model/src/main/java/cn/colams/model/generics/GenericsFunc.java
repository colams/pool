package cn.colams.model.generics;

public class GenericsFunc {



    // 泛型方法实现两个数相加
    public <T extends Number> double add(T t1, T t2) {
        double sum = 0.0;
        sum = t1.doubleValue() + t2.doubleValue();
        return sum;
    }

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        GenericsFunc addTest = new GenericsFunc();// 新建GenericAdd类

        int num1 = 3;
        int num2 = 4;
        System.out.println("整数和:" + addTest.add(num1, num2));// 整数相加
        float num3 = 3.0f;
        float num4 = 7.0f;
        System.out.println("浮点数和:" + addTest.add(num3, num4));// 浮点数相加

        double num5 = 99.0;
        double num6 = 1.0;
        System.out.println("双精度浮点数和:" + addTest.add(num5, num6));// 双精度浮点数相加

        long num7 = 300;
        long num8 = 700;
        System.out.println("长整数和:" + addTest.add(num7, num8));// 长整数相加
    }

}
