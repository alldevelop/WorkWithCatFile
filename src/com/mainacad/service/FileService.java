package com.mainacad.service;

import java.io.*;
import java.nio.file.Files;

public class FileService {
    public static final String MAIN_DIR = System.getProperty("user.dir");
    public static final String SEP = System.getProperty("file.separator");
    public static final String FILES_DIR = MAIN_DIR + SEP + "files";

    //work with text
    public static void writeTextToFile(String text, String fileName, boolean append) {
        checkTargetDir();

        // для того, чтобы мы могли использовать его в блое finally
        try (FileWriter fileWriter = new FileWriter(FILES_DIR + SEP + fileName)) {
            fileWriter.write(text);
            fileWriter.flush(); // осуществляет выталкивание текста в сам файл
        } catch (IOException e) {
            e.printStackTrace();
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

    public static String readTextFromFile(String fileName) {

        String out = "";

        try (FileReader fileReader = new FileReader(FILES_DIR + SEP + fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {

            String line;
            while ( (line = bufferedReader.readLine()) != null ) { //необходимо представить, что есть файл, в котором куча строк, здесь в  BufferedReader
                out += line + "\n";                          // загнали все эти строки и мы будем считывать строку при каждом считывании смещение курсора будет происходить на след строчку
            }                                                //пока не дойдем до null
        } catch (IOException e) { // в итоге мы сформировали два объекта, первый - это наш FileReader, он нам нужен для того, чтобы спозиционироваться на файл
            e.printStackTrace(); // и второй BufferedReader нам нужен для того, чтобы скачать из FileReadera как из пневмопочты


        }

        return out;
    }
    //work with bytes
    public static void writeBytesToFile(byte[] bytes, String fileName) {
        checkTargetDir();

        try (FileOutputStream fileOutputStream =
                     new FileOutputStream(FILES_DIR + SEP + fileName)) {
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte [] getBytesFromFile(String fileName) {
          File file = new File(FILES_DIR + SEP + fileName);

        try {
            return Files.readAllBytes(file.toPath());// преобразовать к абсолютному пути
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static void copyFile(String sourceName, String targetName) {
        byte[] bytes  = getBytesFromFile(sourceName);
        writeBytesToFile(bytes, targetName);
    }
}
