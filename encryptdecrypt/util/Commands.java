package encryptdecrypt.util;

public enum Commands {

    ENC("enc"),
    DEC("dec"),
    SHIFT("shift"),
    UNICODE("unicode"),
    UNKNOWN("unknown");

    final String name;

    Commands(String name) {
        this.name = name;
    }

    public static Commands getCommandOrDefault(String string) {
        try {
            return Commands.valueOf(string);
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }

    public static Commands getCommandByName(String name) {
        for (Commands c : values()) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return UNKNOWN;
    }

    public String getName() {
        return name;
    }
}
