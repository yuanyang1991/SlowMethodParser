package cn.yuanyang.parser;

import cn.yuanyang.parser.util.TraceUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class TraceParserTask implements Callable<Set<Trace>> {

    private final File traceFile;

    public TraceParserTask(File traceFile) {
        this.traceFile = traceFile;
    }

    @Override
    public Set<Trace> call() throws Exception {
        if (!traceFile.exists() || traceFile.length() == 0 || !traceFile.isFile()) {
            Log.i(traceFile.getAbsolutePath() +" is not a valid file");
            return null;
        }
        Set<Trace> list = new HashSet<>();
        LineReader reader = new LineReader(traceFile.getAbsolutePath());
        String line;
        while ((line = reader.readLine()) != null) {
            Trace trace = TraceUtils.parseItem(line);
            if (trace != null) {
                list.add(trace);
            }
        }
        reader.release();
        return list;
    }
}
