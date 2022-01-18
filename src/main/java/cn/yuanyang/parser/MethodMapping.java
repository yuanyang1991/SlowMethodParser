package cn.yuanyang.parser;

import cn.yuanyang.parser.util.TextUtils;

import java.io.IOException;
import java.util.HashMap;

public final class MethodMapping {

    private static final HashMap<Integer, String> map = new HashMap<>();

    public MethodMapping(String mapping) throws IOException {
        LineReader lineReader = new LineReader(mapping);
        String line;
        while ((line = lineReader.readLine()) != null) {
            String[] arr = line.split(",");
            if (arr.length == 3) {
                int methodId = TextUtils.text2Int(arr[0], Integer.MAX_VALUE);
                String method = arr[2];
                map.put(methodId, method);
            }
        }
        lineReader.release();
    }

    public String getMethodFromMethodId(int methodId) {
        return map.get(methodId);
    }


}
