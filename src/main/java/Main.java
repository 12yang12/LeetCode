import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
    // CTRL + shift + enter 代码补全
    // CTRL + ALT + L 代码格式化
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        System.out.println(nextInt);


        File file = new File("");
        new FileInputStream(file);
        new FileOutputStream(file);
        new FileReader(file);
        // new RandomAccessFile(file);

    }


}
