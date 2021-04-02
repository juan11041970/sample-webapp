package com.jda.cracking.interview

class CountArrayPairs {

    int[] numbers = [2, 4, 6 , 8]
//    int[] numbers = [5, 2]
//    def diff = 2
    def diff = 2

    static void main(String[] args) {
        CountArrayPairs countArrayPairs = new CountArrayPairs()
        countArrayPairs.count()
//        countArrayPairs.count2()
    }

    private void count() {
        Map<Integer, Integer> numsMap = new HashMap<>()
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i]
            numsMap.put(num, num)
        }

        //Count the pairs now in the array
        int count
        for (int i = 0; i < numbers.length; i++) {
            int currNum = numbers[i]
            int diff = currNum - diff
            int sum = currNum + diff

//            println "Current number is: ${currNum}"

            if (numsMap.get(diff) == diff) {
                //We have a match
                count++;
            }
            if (numsMap.get(sum) == sum) {
//                println "in sum check for sum ${sum}"
                count++
//            }
            }
        }
        System.out.println("The count is: " + count)
    }

//    void count2() {
//        int count
//        int diff = 2
//        for (int i = 0; i < numbers.length; i++) {
////            println i + "\n"
//            def currI = numbers[i]
//            for (int j = i +1; j < numbers.length; j++) {
//                //println "j: " + j + " " + numbers[j]
//                def currJ = numbers[j]
//                def sum = currI + currJ
//                if (sum == diff) {
//                    count++
//                }
//                def subtract = currI - currJ
//                if (subtract == diff) {
//                    count++
//                }
//            }
//        }
//
//        println "There are ${count} pairs"
//    }
}