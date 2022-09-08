package encryptdecrypt.services;

public class UnicodeAlgImpl implements AlgorithmService {

    @Override
    public String encryption(String data, int key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            int current = data.charAt(i);
            sb.append((char) (current + key));
        }
        return sb.toString();
    }

    @Override
    public String decryption(String data, int key) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            int current = data.charAt(i);
            sb.append((char) (current - key));
        }
        return sb.toString();

    }
}
