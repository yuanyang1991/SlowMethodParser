package cn.yuanyang.parser;

import cn.yuanyang.parser.util.MethodUtils;
import cn.yuanyang.parser.util.TraceParserThreadPool;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

public class Parser {

    public void parse(String filePath, String mappingFilePath) throws Exception {
        File f = new File(filePath);
        if (!f.exists()) {
            return;
        }
        MethodUtils.init(mappingFilePath);
        Set<Trace> traces = null;
        if (f.isFile()) {
            traces = new TraceParserTask(f).call();
        } else if (f.isDirectory()) {
            traces = new HashSet<>();
            File[] files = f.listFiles();
            if (files == null || files.length == 0) {
                return;
            }
            List<Future<Set<Trace>>> futures = new ArrayList<>();
            for (File file : files) {
                if (file.exists() && file.length() > 0) {
                    futures.add(TraceParserThreadPool.PARSER_THREAD_POOL.submit(new TraceParserTask(file)));
                }
            }
            for (Future<Set<Trace>> future : futures) {
                Set<Trace> result = future.get();
                if (result != null) {
                    traces.addAll(result);
                }
            }
        }
        System.out.println("total:" + (traces == null ? 0 : traces.size()));
        File resultFile = new File(filePath, "result.html");
        if (!resultFile.exists()) {
            resultFile.createNewFile();
        }
        ResultWriter.write(resultFile, traces);
    }


}
