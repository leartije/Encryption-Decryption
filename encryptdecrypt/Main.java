package encryptdecrypt;

import encryptdecrypt.services.ArgParser;
import encryptdecrypt.ui.EncDecAlg;

public class Main {

    public static void main(String[] args) {

        new EncDecAlg(new ArgParser(args)).start();

    }
}
