package cn.yuanyang.parser;

import cn.yuanyang.parser.util.MethodUtils;
import cn.yuanyang.parser.util.TextUtils;

public class MethodItem {

    public String methodName;
    public int durTime;
    public int depth;
    public int count = 1;

    private MethodItem() {

    }

    public static MethodItem of(String str) {
        String[] arr = str.split(",");
        if (arr.length < 4) {
            throw new RuntimeException(str + "is not a method");
        }
        MethodItem item = new MethodItem();
        item.depth = TextUtils.text2Int(arr[0], 0);
        item.methodName = MethodUtils.getMethod(TextUtils.text2Int(arr[1], 0));
        item.count = TextUtils.text2Int(arr[2], 0);
        item.durTime = TextUtils.text2Int(arr[3], 0);
        return item;
    }
}
