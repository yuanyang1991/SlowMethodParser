package cn.yuanyang.parser;

import cn.yuanyang.parser.util.MethodUtils;
import cn.yuanyang.parser.util.TraceUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Trace> parse(String filePath, String mappingFilePath) throws IOException {
        MethodUtils.init(mappingFilePath);
        List<Trace> list = new ArrayList<>();
        LineReader reader = new LineReader(filePath);
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(TraceUtils.parseItem(line));
        }
        reader.release();
        return list;
    }

}
