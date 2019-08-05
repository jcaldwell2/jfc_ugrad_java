import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private static void readFile(String fileName) {
        try {
            File file = new File(fileName);


            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            File file = new File(fileName);
            System.out.println(file.getAbsolutePath());
            System.out.println(file.canRead());
            System.out.println(file.exists());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        readFile("C:\\Users\\James\\Desktop\\Radford\\Itec 220\\ReadFile\\InformationSystems.dat");
    }
}