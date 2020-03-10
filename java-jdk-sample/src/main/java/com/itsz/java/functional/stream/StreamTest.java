package com.itsz.java.functional.stream;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void collectionsTest() {
        Book book = new Book("1", "java", 23);
        Book book1 = new Book("2", "python", 34);
        Book book2 = new Book("4", "C#", 78);

        List<Book> books = Arrays.asList(book, book1, book2);

        List<String> bookNames = books.stream()
                .map(Book::getName)
                .collect(Collectors.toList());

        System.out.println(bookNames);

        Integer totalPage = books.stream().
                collect(Collectors.summingInt(Book::getPage));
        System.out.println(totalPage);
    }

    @Test
    public void testStreams1() {
        List<String> colors = Arrays.asList("green", "red", "yellow");
        colors.stream()
                .sorted(String::compareTo)
                .findFirst()
                .ifPresent(System.out::println);
    }

    @Test
    public void testStream2() {
        Arrays.asList("apple", "acco", "banana")
                .stream()
                .filter(str -> str.startsWith("a"))
                .forEach(System.out::println);
    }

    @Test
    public void testStream3() {
        List<String> fruits = Arrays.asList("apple", "apricot", "banana")
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(fruits);
    }

    @Test
    public void testIntStream2Stream() {
        List<Integer> list = IntStream.range(3, 5)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void testStream4() {
        Arrays.stream(new int[]{2, 5, 7})
                .map(a -> a * a)
                .average()
                .ifPresent(System.out::println);
    }

    @Test
    public void testStreams() {
        Stream.of(1, 4, 5)
                .map(a -> a * a)
                .mapToInt(a -> a.intValue())
                .average()
                .ifPresent(System.out::println);
    }
}
