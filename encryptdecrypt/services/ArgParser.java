package encryptdecrypt.services;

import encryptdecrypt.oi.Load;

import static encryptdecrypt.util.Msg.*;

public class ArgParser {

    private final String[] args;
    private String mode;
    private String data;
    private int key;
    private String out;
    private String in;
    private String alg;

    public ArgParser(String[] args) {
        this.args = args;
        this.alg = DEFAULT_ALG;
        this.mode = DEFAULT_MODE;
        this.key = 0;
        setParameters();
        setData();
    }

    private void setParameters() {

        for (int i = 0; i < args.length; i++) {

            String value = i + 1 < args.length ? args[i + 1] : null;

            if (MODE.equalsIgnoreCase(args[i])) {
                this.mode = value == null ? mode : value;
                continue;
            }
            if (ALG.equalsIgnoreCase(args[i])) {
                this.alg = value == null ? alg : value;
                continue;
            }
            if (KEY.equalsIgnoreCase(args[i])) {
                try {
                    if (value == null) {
                        this.key = 0;
                        continue;
                    }
                    this.key = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    System.out.println(NO_KEY);
                    this.key = 0;
                }
                continue;
            }
            if (DATA.equalsIgnoreCase(args[i])) {
                this.data = value;
                continue;
            }
            if (IN.equalsIgnoreCase(args[i])) {
                this.in = value;
                continue;
            }
            if (OUT.equalsIgnoreCase(args[i])) {
                this.out = value;
            }
        }
    }

    private void setData() {
        if (data != null && in != null) {
            return;
        }
        if (data == null && in != null) {
            Load load = new Load(in);
            String data = load.load();
            if (UNKNOWN.equals(data)) {
                System.out.printf(FILE_NOT_FOUND, getIn());
                this.data = "";
                return;
            }
            this.data = data;
            return;
        }
        if (data == null) {
            this.data = "";
        }
    }

    public String getMode() {
        return mode;
    }

    public String getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public String getOut() {
        return out;
    }

    public String getIn() {
        return in;
    }

    public String getAlg() {
        return alg;
    }
}
