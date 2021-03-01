package cn.colams.javatest;

public class InitOrder {

    public static String staticString;

    static {
        System.out.println("static block 1");
        staticString = "staticString ";
    }

    public static void staticMethod() {
        System.out.println(" static method 1 : " + staticString);
    }

}
