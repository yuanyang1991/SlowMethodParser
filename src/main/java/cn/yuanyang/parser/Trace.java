package cn.yuanyang.parser;

import cn.yuanyang.parser.util.MethodUtils;

import java.util.LinkedList;
import java.util.Objects;

public class Trace implements Comparable<Trace> {

    public final long cost;
    public final String usage;
    public final String scene;
    public final String machine;
    public final String stackKey;
    public final LinkedList<MethodItem> stack;

    public Trace(long cost, String usage, String scene, String machine, LinkedList<MethodItem> stack, String stackKey) {
        this.cost = cost;
        this.usage = usage;
        this.scene = scene;
        this.machine = machine;
        this.stack = stack;
        this.stackKey = stackKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trace trace = (Trace) o;
        return Objects.equals(stackKey, trace.stackKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stackKey);
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

    @Override
    public int compareTo(Trace o) {
        long diff = cost - o.cost;
        if (diff > 0) {
            return 1;
        } else if (diff == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
