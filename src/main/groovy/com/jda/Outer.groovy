package com.jda

class Outer {

    private String privateStr = 'private string'

    def startThread() {
        println "Starting thread"
        new Thread(new Inner()).start()
    }

    class Inner implements Runnable {
        void run() {
            println "${privateStr}"
        }
    }

    static void main(String[] args) {
        Outer out = new Outer()
        out.startThread()
    }
}
