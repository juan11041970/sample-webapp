package com.jda.cracking.interview

class CountArrayPairs {

    int[] numbers = [5, 3, 9, 7, 21, 23, 0, 2]
    def diff = 2

    static void main(String[] args) {

        CountArrayPairs countArrayPairs = new CountArrayPairs()
        countArrayPairs.count()
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

            println "Current number is: ${currNum}"

            if (numsMap.get(diff) == diff) {
                //We have a match
                count++;
            }
            if (numsMap.get(sum) == sum) {
                println "in sum check for sum ${sum}"
                count++
//            }
            }
        }
        System.out.println("The count is: " + count)
    }
}