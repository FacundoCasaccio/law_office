package com.solvd.lawoffice.documentation;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    private static final File DOCUMENT = new File("src\\main\\resources\\lawarticle.txt");
    private static final File READ_OUTPUT = new File("src\\main\\resources\\read_lawarticle.txt");
    //private static ArrayList<String> readOutputArray = new ArrayList<>();
    private static HashMap<String, Integer> output = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(Reader.class);

    public static void main(String[] args) {

        //Read document to string
        String documentString = null;
        try {
            documentString = FileUtils.readFileToString(DOCUMENT, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.warn(e);
        }

        //Convert string to array of strings
        String[] arrayOfWords = StringUtils.split(documentString);

        //Pattern of word in lowercase
        Pattern pattern = Pattern.compile("[^\\w]");

        for (int i = 0; i < arrayOfWords.length; i++) {
            //Read word
            String word = StringUtils.lowerCase(arrayOfWords[i]);

            //Match everything that is not a word
            Matcher matcher = pattern.matcher(word);

            if(!matcher.matches() && !output.containsKey(word)) {
                output.put(word,1);
            } else if (!matcher.matches() && output.containsKey(word)) {
                Integer value = output.get(word);
                output.put(word, ++value);
            }

            //Write result in txt file
            try {
                FileUtils.writeLines(READ_OUTPUT, Collections.singleton(output));
            } catch (IOException e) {
                LOGGER.warn(e);
            }
        }
        //Process done message
        LOGGER.info("Reading complete");
    }
}

