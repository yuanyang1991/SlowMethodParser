package cn.yuanyang.parser.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

    private static final String PATTERN = "tag\\[(\\D+)]type\\[(\\d+)];key\\[(.+)];content\\[(.+)]";

    public static String getContent(String trace) {
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(trace);
        if (m.find()) {
            return m.group(m.groupCount());
        } else {
            return null;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static int text2Int(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
