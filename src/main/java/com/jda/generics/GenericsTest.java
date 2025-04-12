package com.jda.generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericsTest {

    public <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }
}
