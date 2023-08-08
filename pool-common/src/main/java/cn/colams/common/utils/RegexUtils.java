package cn.colams.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static String getValueByRegex(String regex, String inputText) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);
        String value = "";
        if (matcher.find()) {
            value = matcher.group(1);
        }
        return value;
    }

}
