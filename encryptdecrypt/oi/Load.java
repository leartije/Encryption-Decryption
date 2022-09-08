package encryptdecrypt.oi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Load {

    private final String fileName;

    public Load(String fileName) {
        this.fileName = fileName;
    }

    public String load() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader load = new BufferedReader(new FileReader(fileName))) {

            String msg;
            while ((msg = load.readLine()) != null) {
                sb.append(msg);
            }

        } catch (IOException e) {
            return "unknown";
        }

        return sb.toString();
    }
}
