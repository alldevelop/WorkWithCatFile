package com.mainacad.service;

import java.io.*;
import java.nio.file.Files;

public class FileService {
    public static final String MAIN_DIR = System.getProperty("user.dir");
    public static final String SEP = System.getProperty("file.separator");
    public static final String FILES_DIR = MAIN_DIR + SEP + "files";

    //work with text
    public static void writeTextToFile(String text, String fileName) {
        checkTargetDir();

        FileWriter fileWriter = null; // для того, чтобы мы могли использовать его в блое finally
        try {
            fileWriter = new FileWriter(FILES_DIR + SEP + fileName);
            fileWriter.write(text);
            fileWriter.flush(); // осуществляет выталкивание текста в сам файл
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close(); //таким образом мы закрываем подключение к нашему файлу
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //FileWriter механизм позиционирования на файл с целью его дальнейшего наполнения
        // FileWriter нужно обработать (try catch);


}

    private static void checkTargetDir() { //помогает управлять путями к файлу и обработкой файлов
        File file = new File(FILES_DIR); // позиционирование на нашу директорию
        if (!file.exists()) { // если не существуешь - создайся
            file.mkdir();
        }
    }

    public static String writeTextToFile(String fileName) {

        String out = "";
        return out;
    }
}

