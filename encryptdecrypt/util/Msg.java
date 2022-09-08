package encryptdecrypt.util;

public class Msg {

    // cla
    public static final String MODE = "-mode";
    public static final String ALG = "-alg";
    public static final String KEY = "-key";
    public static final String IN = "-in";
    public static final String OUT = "-out";
    public static final String DATA = "-data";

    //errors
    public static final String NO_KEY = "error: provided key is not valid or missing. Assigning default value: 0";
    public static final String FILE_NOT_FOUND = "error: file '%s' is not found. Data is set to default%n";

    public static final String ALG_NOT_SUPPORTED = "error: '%s' algorithm is not supported%n";


    //defaults
    public static final String DEFAULT_MODE = "enc";
    public static final String DEFAULT_ALG = "shift";


    //other
    public static final String UNKNOWN = "unknown";
    public static final String ERROR = "error";

}
