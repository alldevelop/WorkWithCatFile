package com.mainacad;

import com.mainacad.service.FileService;

import java.util.logging.Logger;

public class ApplicationRunner {
    private static final Logger LOGGER =
            Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {

        FileService.copyFile("cat.jpg","cat_copy.jpg");
        /*  String text = "Some new text \n I wanted to be written\n";
        FileService.writeTextToFile(text,"test.txt", false);
        String inputText =
                FileService.readTextFromFile("test.txt");
        LOGGER.info("\n" + inputText);
        /*FileService.copyFile("cat.jpg", "cat_copy.jpg");*/
              /*  String text = "some new text \n I wanted to be written\n";

        String inputText =
                FileService.readTextFromFile("test txt");
        */
    }

}
