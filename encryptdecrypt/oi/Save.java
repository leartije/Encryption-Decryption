package encryptdecrypt.oi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    private final String fileName;
    private final String msg;

    public Save(String fileName, String msg) {
        this.fileName = fileName;
        this.msg = msg;
    }

    public void save() {
        try (BufferedWriter save = new BufferedWriter(new FileWriter(fileName))) {
            save.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
