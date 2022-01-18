package cn.yuanyang.parser.util;

import cn.yuanyang.parser.MethodMapping;
import cn.yuanyang.parser.MethodItem;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class MethodUtils {

    private static MethodMapping parser;

    public static void init(String filePath) {
        try {
            parser = new MethodMapping(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMethod(int methodId) {
        if (parser == null) {
            return null;
        }
        return parser.getMethodFromMethodId(methodId);
    }

    public static String stack2String(LinkedList<MethodItem> stack) {
        Iterator<MethodItem> listIterator = stack.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (listIterator.hasNext()) {
            MethodItem m = listIterator.next();
            stringBuilder.append(m.methodName).append(" ").append(m.durTime).append("<br>");
        }
        return stringBuilder.toString();
    }
}
