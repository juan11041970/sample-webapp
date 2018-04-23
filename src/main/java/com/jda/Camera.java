package com.jda;

import java.util.Arrays;

public class Camera {

    private String cameraType;

    public static void main(String[] args) {

        Camera cam = new Camera();
        String type = "Cannon";

        System.out.println("main: Camera type is: " + type);
        cam.setCameraType(type);

        System.out.println("main: Camera type is: " + type);
        System.out.println("main: Camera type is: " + cam.getCameraType());

    }

    public String takePicture() {
        return "taking picture";
    }

    public String getCameraType() {
        return cameraType;
    }

    public void setCameraType(String type) {
        System.out.println("In setter camera type is: " + type);
        type = "Olympus";
        this.cameraType = type;

        System.out.println("After setting type is: "  + this.cameraType);
    }
}
