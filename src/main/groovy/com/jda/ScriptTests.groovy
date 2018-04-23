package com.jda

import org.junit.Test

class ScriptTests extends GroovyShellTestCase {

    @Test
    void testChuckNorrisScript() {
        //GroovyShell shell = new GroovyShell()
        shell.evaluate(new File('/Users/juaalvarado/Library/Preferences/IntelliJIdea2018.1/scratches/scratch.groovy'))
    }

    @Test
    void testHelloWorld() {
        Binding binding = new Binding()

        def content = new StringWriter()
        binding.out = new PrintWriter(content)
        //GroovyShell shell = new GroovyShell(binding)
        withBinding([out: new PrintWriter(content), name: 'Dolly']) {

            shell.evaluate(new File('/Users/juaalvarado/Library/Preferences/IntelliJIdea2018.1/scratches/hello_world.groovy'))
            assert "Hello, World!" == content.toString().trim()
        }
    }

     static void main(String[] args) {

        ScriptTests scriptTests = new ScriptTests()
        int[] values = [2, 4, 6, 8, 10 ,12, 14 ]
        def low = 0
        def high = values.size() - 1
        int numToFind = 1

        scriptTests.doBinarySearch( values, low, high, numToFind)
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
