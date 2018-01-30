package com.ant.gallerytestapp.models;

/**
 * Created by mihailantipev on 29.01.18.
 */

public class Photo {
    private String path;
    private String fileName;
    private int size;
    private String hash;

    public Photo(String path, String fileName, int size, String hash) {
        this.path = path;
        this.fileName = fileName;
        this.size = size;
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "file://"+path;
    }
}
