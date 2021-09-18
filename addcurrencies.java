import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class addcurrencies {

    public void additem() throws Exception {
        File file = new File("D:\\Hackathon HW\\src\\currencies.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            combobox.cbox1.addItem(st);
            combobox.cbox2.addItem(st);
        }

    }
}
