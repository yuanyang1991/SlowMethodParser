package cn.yuanyang.parser;

import cn.yuanyang.parser.util.MethodUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ResultWriter {

    private static final String HTML_HEAD = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <title>Matrix_Trace</title>\n" +
            "    <style>\n" +
            "    table, td, th {\n" +
            "        border: 1px solid black;\n" +
            "    }\n" +
            "    table {\n" +
            "       \n" +
            "        border-collapse: collapse;\n" +
            "    }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>";

    public static void write(File f, Set<Trace> traceSet) throws IOException {
        List<Trace> traceList = new ArrayList<>(traceSet);
        Collections.sort(traceList);
        Collections.reverse(traceList);
        Map<String, List<Trace>> map = list2Map(traceList);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f), StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder(HTML_HEAD);
        stringBuilder.append("<table border=\"1\" cellpadding=\"10\">\n");
        int index = 1;
        for (Map.Entry<String, List<Trace>> entry : map.entrySet()) {
            List<Trace> traces = entry.getValue();
            for (Trace trace : traces) {
                stringBuilder.append("<tr>\n");
                stringBuilder.append("<td>").append(index).append("</td>\n");
                stringBuilder.append("<td>").append(trace.scene).append("</td>\n");
                stringBuilder.append("<td>").append(MethodUtils.stack2String(trace.stack)).append("</td>\n");
                stringBuilder.append("</tr>\n");
                index++;
            }
        }
        stringBuilder.append("</table>\n");
        printWriter.write(stringBuilder.toString());
        printWriter.flush();
        printWriter.close();
    }

    private static Map<String, List<Trace>> list2Map(List<Trace> traceList) {
        Map<String, List<Trace>> sceneTraceList = new HashMap<>();
        for (Trace trace : traceList) {
            List<Trace> list = sceneTraceList.get(trace.scene);
            if (list == null) {
                list = new ArrayList<>();
                list.add(trace);
                sceneTraceList.put(trace.scene, list);
            } else {
                list.add(trace);
            }
        }
        return sceneTraceList;
    }
}
