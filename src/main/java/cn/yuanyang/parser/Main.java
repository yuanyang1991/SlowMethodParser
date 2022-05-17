package cn.yuanyang.parser;

public class Main {

    public static void main(String[] args) {
        try {
            new Parser().parse("folder path of logs",
                    "file path of method mapping");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
