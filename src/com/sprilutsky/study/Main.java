package com.sprilutsky.study;

public class Main {

    public static void main(String[] args) {
        FirstTask firstTask = new FirstTask(10, 10, 1000);
        firstTask.run();

        SecondTask secondTask = new SecondTask("f.txt", "g.txt", "h.txt", "a d c test first", "b e second third alpha");
        secondTask.run();

        ThirdTask thirdTask = new ThirdTask();
        thirdTask.run();
    }
}
