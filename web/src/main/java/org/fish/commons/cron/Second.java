package org.fish.commons.cron;

import java.util.regex.Pattern;

/**
 * @author Sumit Jha
 */
public class Second implements Configuration {
    Pattern all = Pattern.compile("\\*");
    Pattern range = Pattern.compile("^[0-9]-[0-9]$|^[0-9]-[1-5][0-9]$|^[1-5][0-9]-[1-5][0-9]$");
    Pattern every = Pattern.compile("^[0-9]/[0-9]$|^[0-9]/[1-5][0-9]$|^[1-5][0-9]/[1-5][0-9]$");
    Pattern multiple = Pattern.compile("^[0-9](,[0-9])$|^[0-9](,[1-5][0-9])$|^[1-5][0-9](,[1-5][0-9])$");
    Pattern single = Pattern.compile("^[1-5][0-9]$|^[0-9]$");

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public int[] values() {
        return new int[0];
    }
}
