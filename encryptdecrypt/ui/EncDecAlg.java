package encryptdecrypt.ui;

import encryptdecrypt.oi.Save;
import encryptdecrypt.services.AlgorithmFactory;
import encryptdecrypt.services.AlgorithmService;
import encryptdecrypt.services.ArgParser;
import encryptdecrypt.util.Commands;
import encryptdecrypt.util.Msg;

public class EncDecAlg {

    private final AlgorithmFactory algorithmFactory;
    private final ArgParser argParser;

    public EncDecAlg(ArgParser argParser) {
        this.argParser = argParser;
        this.algorithmFactory = new AlgorithmFactory();
    }

    public void start() {
        String alg = argParser.getAlg();

        if (!alg.equals(Commands.SHIFT.getName()) && !alg.equals(Commands.UNICODE.getName())){
            System.out.printf(Msg.ALG_NOT_SUPPORTED, argParser.getAlg());
            return;
        }

        AlgorithmService algorithm = algorithmFactory.getAlgorithm(alg);

        String response = switch (Commands.getCommandByName(argParser.getMode())) {
            case ENC -> algorithm.encryption(argParser.getData(), argParser.getKey());
            case DEC -> algorithm.decryption(argParser.getData(), argParser.getKey());
            default -> Msg.ERROR;
        };

        if (argParser.getOut() == null) {
            System.out.println(response);
            return;
        }

        Save save = new Save(argParser.getOut(), response);
        save.save();
    }

}
