package cn.yuanyang.parser;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
            List<Trace> list = parser.parse("D:\\anr_mat\\anr_log\\2022_01_18_034649.txt", "C:\\Users\\wps\\Downloads\\overseaRelease\\methodMapping.txt");
            System.out.println(list.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
