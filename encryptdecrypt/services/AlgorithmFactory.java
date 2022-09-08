package encryptdecrypt.services;

import encryptdecrypt.util.Commands;

public class AlgorithmFactory {

    public AlgorithmService getAlgorithm(String alg) {
        return switch (Commands.getCommandByName(alg)) {
            case UNICODE -> new UnicodeAlgImpl();
            case SHIFT -> new ShiftAlgImpl();
            default -> null;
        };
    }

}
