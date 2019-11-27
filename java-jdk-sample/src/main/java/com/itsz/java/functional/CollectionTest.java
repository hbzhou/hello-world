package com.itsz.java.functional;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionTest {

    private Stream<Student> stream = Stream.of(new Student("jeremy", 12), new Student("John", 16));

    @Test
    public void testCollect() {

        List<Student> students = Stream.of(new Student("jeremy", 12), new Student("John", 12)).collect(Collectors.toList());
        System.out.println(students);

    }

    @Test
    public void test2Set() {
        Set<Student> set = Stream.of(new Student("jason", 12), new Student("Majic", 1)).collect(Collectors.toSet());
        for (Student student : set) {
            System.out.println(student);
        }
    }

    @Test
    public void test2Map() {
        Map<String, Student> map = Stream.of(new Student("jason", 12), new Student("Majic", 1)).collect(Collectors.toMap(Student::getName, student -> student));
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }

    @Test
    public void testFilter() {
        List<Student> students = Stream.of(new Student("jason", 13), new Student("Magic", 234)).filter(student -> student.getAge() > 15).collect(Collectors.toList());
        System.out.println(students);
    }

    @Test
    public void testMap() {
        List<String> names = stream.map(Student::getName).collect(Collectors.toList());
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void testFlagMap() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Jason", 2));
        students.add(new Student("Acco", 4));
        students.add(new Student("jeremy", 23));

        List<Student> students1 = new ArrayList<>();
        students.add(new Student("Demon", 2));
        students.add(new Student("Simon", 4));
        students.add(new Student("Connie", 23));

        List<Student> list = Stream.of(students, students1).flatMap(studentList -> studentList.stream()).collect(Collectors.toList());

        for (Student student : list) {
            System.out.println(student);
        }

    }

    @Test
    public void testMax(){
        Optional<Student> max = stream.max(Comparator.comparing(Student::getAge));

        if (max.isPresent()){
            System.out.println(max.get());
        }

    }

    @Test
    public void testMin(){
        Optional<Student> min = stream.min(Comparator.comparing(Student::getAge));
        if (min.isPresent()){
            System.out.println(min.get());
        }
    }


    @Test
    public void testCount(){
        long count = stream.filter(student -> student.getAge() > 0).count();
        System.out.println(count);
    }

    @Test
    public void testReduce(){
        Optional<Student> studentNew = stream.reduce((student, student2) -> {
            student.setAge(student.getAge() + student2.getAge());
            return  student;
        });

        System.out.println(studentNew);

        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
    }

    @Test
    public void testMaxBy(){
        Student student = stream.collect(Collectors.maxBy(Comparator.comparing(Student::getAge))).orElseGet(Student::new);
        System.out.println(student);
    }

    @Test
    public void testAverage(){
        double averageAge = stream.collect(Collectors.averagingInt(Student::getAge));
        System.out.println(averageAge);
    }


    @Test
    public void testPartition (){
        Map<Boolean, List<Student>> map = stream.collect(Collectors.partitioningBy(student -> student.getAge() > 15));
        map.forEach( (b,value)->{
            System.out.println(b);
            for (Student student : value) {
                System.out.println(student);
            }
        });

    }

    @Test
    public void testGroupBy(){
        Map<String, List<Student>> map = stream.collect(Collectors.groupingBy(Student::getName));
        map.forEach((key, value )->{
            System.out.println(key);
            System.out.println(value);
        });
    }

    @Test
    public void testJoining (){
        String collect = stream.map(Student::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }

    @Test
    public void testDistinct(){
        int[] arr = {10,12,14,5,10,30, 50};

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        int[] newArr = Arrays.stream(arr).distinct().toArray();
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }

    }


    @Test
    public void testArrayDistinct(){
        int[] arr = {10,12,14,5,10,30, 50};
        int[] newArr = Arrays.stream(arr).distinct().toArray();
        System.out.println("new array after distinct: ");
        Arrays.stream(newArr).forEach(System.out::println);
        System.out.println("==========================");
        int max = Arrays.stream(newArr).max().getAsInt();
        int min  = Arrays.stream(newArr).min().getAsInt();

        System.out.println("max:"+max);
        System.out.println("min:"+min);
    }


    @Test
    public void testArrayCombine(){
        int[] arr = {10,12,14,5,10,30,50,0};
        int [] arrNew = new int[4];

        System.arraycopy(arr,0, arrNew, 0, arrNew.length);

        for (int i = 0; i < arrNew.length; i++) {
            System.out.println(arrNew[i]);
        }


    }




}
