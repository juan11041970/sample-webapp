package com.jda

class SmartPhone {
    @Delegate Camera camera = new Camera()
    @Delegate Phone phone = new Phone()
}
