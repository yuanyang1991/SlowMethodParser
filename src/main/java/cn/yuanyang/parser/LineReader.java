package cn.yuanyang.parser;

import java.io.*;

public class LineReader {

    private final BufferedReader br;

    public LineReader(String filePath) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(filePath));
    }


    public String readLine() throws IOException {
        return br.readLine();
    }

    public void release() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
