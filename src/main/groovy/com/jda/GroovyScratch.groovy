package com.jda

class GroovyScratch {

    static void main(String[] args) {
        def strings = ['this','is','a','list','of','strings']
        Collections.sort(strings, {s1,s2 -> s2.size() - s1.size()} as Comparator)
        assert strings*.size() == [7, 4, 4, 2, 2, 1]

        print(strings)

        Collections.sort(strings);
        print("\n")
        print(strings)
        print("\n")
    }
}
