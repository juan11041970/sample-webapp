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
}
