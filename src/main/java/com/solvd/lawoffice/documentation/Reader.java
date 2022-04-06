package com.solvd.lawoffice.documentation;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    private static final File DOCUMENT = new File("src\\main\\resources\\lawarticle.txt");
    private static final File READ_OUTPUT = new File("src\\main\\resources\\read_lawarticle.txt");
    private static ArrayList<String> readOutputArray = new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger(Reader.class);

    public static void main(String[] args) {


        try {
            //Read document to string
            String documentString = FileUtils.readFileToString(DOCUMENT, StandardCharsets.UTF_8);

            //Convert string to array of strings
            String[] arrayOfWords = StringUtils.split(documentString);

            for (int i = 0; i < arrayOfWords.length; i++) {
                //Read word
                String word = arrayOfWords[i];

                //Count ocurrences of word
                int ocurrences = StringUtils.countMatches(documentString, word);

                int j = 0;

                do {
                    //Add if there are no words in array
                    if (readOutputArray.isEmpty()) {
                        readOutputArray.add(arrayOfWords[i] + " - " + ocurrences);
                    } else {

                        //Pattern of word in lowercase
                        Pattern pattern = Pattern.compile(StringUtils.lowerCase(word));
                        //Matcher for the word in output array all in lowercase
                        Matcher matcher = pattern.matcher(StringUtils.lowerCase(StringUtils.substringBefore(readOutputArray.get(j), " - ")));
                        if (matcher.matches()) {
                            //get occurrences, parse to int and add to ocurrences
                            ocurrences += Integer.parseInt(StringUtils.substringAfterLast(readOutputArray.get(j), " - "));
                            //Overwrite with new ocurrences count
                            readOutputArray.set(j,arrayOfWords[i] + " - " + ocurrences);
                        } else {
                            //If it is not in the array, add it
                            readOutputArray.add(arrayOfWords[i] + " - " + ocurrences);
                        }

                    }
                    j++;
                } while (j < readOutputArray.size());
            }

            //Write result in txt file
            FileUtils.writeLines(READ_OUTPUT, readOutputArray);

        } catch (IOException e) {
            LOGGER.warn(e);
        }

        //Process done message
        LOGGER.info("Reading complete");

    }
}
