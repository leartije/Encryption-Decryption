package encryptdecrypt.services;

public class ShiftAlgImpl implements AlgorithmService {

    @Override
    public String encryption(String data, int key) {

        StringBuilder sb = new StringBuilder();
        int g = key % 26;

        for (int i = 0; i < data.length(); i++) {
            int  current = data.charAt(i);
            int shift;

            if (Character.isUpperCase(current)) {
                shift =  current + g <= 90 ? current + g : 64 + (g - (90 - current));
                sb.append((char) shift);
                continue;
            }
            if (Character.isLowerCase(current)) {
                shift = current + g <= 122 ? current + g : 96 + (g - (122 - current));
                sb.append((char) shift);
                continue;
            }
            sb.append((char) current);
        }

        return sb.toString();
    }

    @Override
    public String decryption(String data, int key) {
        StringBuilder sb = new StringBuilder();
        int g = key % 26;

        for (int i = 0; i < data.length(); i++) {
            int  current = data.charAt(i);
            int shift;

            if (Character.isUpperCase(current)) {
                shift = current - g >= 65 ? current - g : 91 - (g - (current - 65));
                sb.append((char) shift);
                continue;
            }
            if (Character.isLowerCase(current)) {
                shift = current - g >= 97 ? current - g : 123 - (g - (current - 97));
                sb.append((char) shift);
                continue;
            }
            sb.append((char) current);
        }
        return sb.toString();
    }
}
