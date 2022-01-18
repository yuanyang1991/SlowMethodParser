package cn.yuanyang.parser.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TraceParserThreadPool {

    public static final ExecutorService PARSER_THREAD_POOL = Executors.newCachedThreadPool();
}
