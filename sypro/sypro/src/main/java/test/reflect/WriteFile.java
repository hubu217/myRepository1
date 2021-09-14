package test.reflect;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @ClassName: WriteFile
 * @Description: 写文件操作
 * @author adamjwh
 * @date 2018年5月28日
 *
 */
public class WriteFile {

    private static String pathname = "libs/out.txt";

    public static void write(StringBuffer sBuffer) throws Exception {
        File file = new File(pathname);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        bw.write(sBuffer.toString());
        bw.close();
    }

}