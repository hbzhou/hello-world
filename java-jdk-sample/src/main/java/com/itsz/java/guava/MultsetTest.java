package com.itsz.java.guava;

import com.google.common.base.Function;
import com.google.common.collect.*;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MultsetTest {

    @Test
    public void testMulSet() {
        String[] doc = new String[]{
                "java", "python", "javascript", "python", "java"
        };

        Multiset<String> multiset = HashMultiset.create();
        for (String word : doc) {
            multiset.add(word);
        }
        System.out.println(multiset.count("java"));
    }

    @Test
    public void testMultiMap() {
        Multimap<String, Integer> multimap = HashMultimap.create();
        multimap.put("jeremy", 1);
        multimap.put("jeremy", 2);
        multimap.put("jeremy", 4);

        Collection<Integer> numbers = multimap.get("jeremy");
        System.out.println(numbers);
    }

    @Test
    public void testBiMap() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("jeremy", "gilbert");

        System.out.println(biMap.get("jeremy"));
        System.out.println(biMap.inverse().get("gilbert"));

        biMap.forcePut("jeremy", "Salvator");
        System.out.println(biMap.get("jeremy"));
    }

    @Test
    public void testLists() {
        List<String> names = Lists.newArrayList("jeremy", "john");
        Lists.transform(names, new Function<String, String>() {

            @Nullable
            @Override
            public String apply(@Nullable String s) {
                return s.toUpperCase();
            }
        });
    }

    @Test
    public void testSets() {
        Set<String> numberSet = ImmutableSet.of("one", "two", "three", "four", "five");
        Set<String> numberSet2 = ImmutableSet.of("one", "two", "three", "eight");

        Sets.SetView<String> union = Sets.union(numberSet, numberSet2);
        union.stream().forEach(System.out::println);
        System.out.println("========================");

        Sets.SetView<String> difference = Sets.difference(numberSet, numberSet2);
        difference.stream().forEach(System.out::println);
        System.out.println("========================");

        Sets.SetView<String> intersection = Sets.intersection(numberSet, numberSet2);
        intersection.stream().forEach(System.out::println);
        System.out.println("========================");

    }


}
