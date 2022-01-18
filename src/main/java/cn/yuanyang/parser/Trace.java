package cn.yuanyang.parser;

import cn.yuanyang.parser.util.MethodUtils;

import java.util.LinkedList;

public class Trace {

    public final long cost;
    public final String usage;
    public final String scene;
    public final String machine;
    public final LinkedList<MethodItem> stack;

    public Trace(long cost, String usage, String scene, String machine, LinkedList<MethodItem> stack) {
        this.cost = cost;
        this.usage = usage;
        this.scene = scene;
        this.machine = machine;
        this.stack = stack;
    }

    @Override
    public String toString() {
        return "Trace{" +
                "cost=" + cost +
                ", usage='" + usage + '\'' +
                ", scene='" + scene + '\'' +
                ", machine='" + machine + '\'' +
                ", stack=" + MethodUtils.stack2String(stack) +
                '}';
    }
}
