package com.jda;

import groovy.lang.GroovyShell;
import groovy.util.Eval;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScriptingTests {

    @Test
    public void testEvalNoParams() {
        String result = (String) Eval.me("'abc' - 'b'");
        assertEquals("ac", result);
    }

    @Test
    public void testEvalThreeParams() {
        String result = (String) Eval.xyz("a", "b", "d", "'abc' - x - y + z");
        assertEquals("cd", result);
    }

    public void testEvaluateString() {
        GroovyShell shell = new GroovyShell();

        Object result = shell.evaluate("3+4");
        assertEquals(7, result);
    }
}
