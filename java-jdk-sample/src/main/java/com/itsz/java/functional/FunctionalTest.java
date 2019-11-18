package com.itsz.java.functional;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.*;

public class FunctionalTest {


    /**
     * 函数接口	抽象方法	功能	参数	返回类型	示例
     * Predicate	test(T t)	判断真假	T	boolean	9龙的身高大于185cm吗？
     * Consumer	accept(T t)	消费消息	T	void	输出一个值
     * Function	R apply(T t)	将T映射为R（转换功能）	T	R	获得student对象的名字
     * Supplier	T get()	生产消息	None	T	工厂方法
     * UnaryOperator	T apply(T t)	一元操作	T	T	逻辑非（!）
     * BinaryOperator	apply(T t, U u)	二元操作	(T，T)	(T)	求两个数的乘积（*）
     */

    @Test
    public void testFunctionalMethod() {
        Predicate<Integer> predicate = (x) -> x > 48;
        Assert.assertTrue(predicate.test(49));
        Assert.assertFalse(predicate.test(15));

        Consumer<String> consumer = System.out::println;
        consumer.accept("jeremygilbert");

    }


    @Test
    public void testConsumerStudent() {
        Consumer<Student> consumer = (student -> {
            System.out.println(student.getName());
        });

        Student student = new Student();
        student.setName("jeremy");
        student.setAge(20);

        consumer.accept(student);
    }

    @Test
    public void testFunctionMethod() {
        Function<Student, String> function = Student::getName;

        Student student = new Student();
        student.setName("jeremy");
        student.setAge(20);

        String name = function.apply(student);

        System.out.println(name);
    }

    @Test
    public void supplierFunction() {
        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.intValue());
        System.out.println(supplier.get());

    }

    @Test
    public void testBinaryOperator() {
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        System.out.println(binaryOperator.apply(4, 6));
    }

    @Test
    public void testUnaryOperator() {
        UnaryOperator<Boolean> unaryOperator = b -> !b;
        Assert.assertTrue(unaryOperator.apply(false));

    }

}



