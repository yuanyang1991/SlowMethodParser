package cn.yuanyang.parser.util;

import cn.yuanyang.parser.Constants;
import cn.yuanyang.parser.MethodItem;
import cn.yuanyang.parser.Trace;
import org.json.JSONObject;

import java.util.LinkedList;

public class TraceUtils {

    public static Trace parseItem(String line) {
        String content = TextUtils.getContent(line);
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        JSONObject jsonObject = new JSONObject(content);
        String machine = jsonObject.optString(Constants.KEY_MACHINE);
        long cost = jsonObject.optLong(Constants.KEY_TIME_COST);
        String cpuUsage = jsonObject.optString(Constants.KEY_CPU_USAGE);
        String scene = jsonObject.optString(Constants.KEY_SCENE);
        String stackStr = jsonObject.optString(Constants.KEY_STACK);
        String stackKey = jsonObject.optString(Constants.KEY_STACK_KEY);
        return new Trace(cost, cpuUsage, scene, machine, string2Stack(stackStr), stackKey);
    }

    private static LinkedList<MethodItem> string2Stack(String stackStr) {
        String[] arr = stackStr.split("\\n");
        LinkedList<MethodItem> stack = new LinkedList<>();
        for (String stackItem : arr) {
            stack.push(MethodItem.of(stackItem));
        }
        return stack;
    }
}
