package encryptdecrypt.services;

public interface AlgorithmService {

    String encryption(String data, int key);

    String decryption(String data, int key);




}
