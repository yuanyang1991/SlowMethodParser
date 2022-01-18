package cn.yuanyang.parser;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
            parser.parse("D:\\anr_mat\\anr_log\\", "C:\\Users\\wps\\Downloads\\overseaRelease\\methodMapping.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
