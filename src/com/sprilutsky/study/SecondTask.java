package com.sprilutsky.study;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sergey on 16.11.16.
 */
public class SecondTask {

    private String firstFileName;
    private String secondFileName;
    private String thirdFileName;
    private String contentForFirstFile;
    private String contentForSecondFile;

    public SecondTask(String firstFileName, String secondFileName, String thirdFileName, String contentForFirstFile, String contentForSecondFile) {
        this.firstFileName = firstFileName;
        this.secondFileName = secondFileName;
        this.thirdFileName = thirdFileName;
        this.contentForFirstFile = contentForFirstFile;
        this.contentForSecondFile = contentForSecondFile;
    }

    public void run() {
        System.out.println("==========START SECOND TASK=========");

        createNewFiles(firstFileName);
        createNewFiles(secondFileName);
        createNewFiles(thirdFileName);

        printToFile(firstFileName, contentForFirstFile);
        printToFile(secondFileName, contentForSecondFile);

        writeToH(thirdFileName, getData(firstFileName, secondFileName));
        System.out.println("==========END FIRST TASK=========");
    }

    private void writeToH(String fileName, String content) {
        try {
            PrintWriter out = new PrintWriter(fileName);
            out.println(content);
            out.close();
            System.out.println("Content printed to " + fileName + ": " + content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String getData(String firstFileName, String secondFileName) {
        String dataFromF = readFile(firstFileName);
        String dataFromG = readFile(secondFileName);
        if (dataFromF != null) {
            System.out.println("Data from " + firstFileName + ": " + dataFromF);
        }

        if (dataFromG != null) {
            System.out.println("Data from " + secondFileName + ": " + dataFromG);
        }

        String[] firstFileArr = dataFromF.split(" ");
        String[] secondFileArr = dataFromG.split(" ");

        Set<String> thirdFileArr = new HashSet<>();

        String result = "";

        for (int i = 0; i < firstFileArr.length; i++) {
            String word = firstFileArr[i];
            if (word.length() != 1) {
                String firstChar = word.substring(0, 1);
                word = firstChar;
            }
            if (!thirdFileArr.contains(word)) {
                thirdFileArr.add(word);
            }
        }

        for (int i = 0; i < secondFileArr.length; i++) {
            String word = secondFileArr[i];
            if (word.length() != 1) {
                String firstChar = word.substring(0, 1);
                word = firstChar;
            }
            if (thirdFileArr.contains(word)) {
                result = result + word + " ";
            }
        }
        return result;
    }

    private void printToFile(String fileName, String content) {
        try {
            PrintWriter out = new PrintWriter(fileName);
            out.println(content);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String readFile(String fileName) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    private void createNewFiles(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
