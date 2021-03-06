package com.jda

import org.junit.Test

class ScriptTests extends GroovyShellTestCase {

     static void main(String[] args) {

        ScriptTests scriptTests = new ScriptTests()
        int[] values = [1, 2, 5, 6, 9]
        def low = 0
        def high = values.size() - 1
        int numToFind = 5

        scriptTests.doBinarySearch(values, low, high, numToFind)
    }

    void doBinarySearch(int[] values, int low, int high, int numToFind) {

        boolean found = false

        while (low <= high) {

            int mid = (low + high) / 2

           def  currentVal = values[mid]
            if (currentVal == numToFind) {
                println "Found it at index: ${mid}"
                found = true
                break

            } else if (currentVal < numToFind) {
                low = mid + 1
                println "Set new low value to: ${low}"

            } else if (currentVal > numToFind) {
                high = mid - 1
                println "Set new high value to: ${high}"
            }
        }

        if (!found) {
            println "Number was not found"
        }

    }
}
