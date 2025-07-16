package enums;

public enum OPERATOR_TOKEN {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    MOD("%"),
    POW("^"),
    SQRT("sqrt"),
    LPAREN("("),
    RPAREN(")");

    private final String symbol;

    OPERATOR_TOKEN(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static boolean isOperator(String token) {
        for (OPERATOR_TOKEN op : values()) {
            if (op.symbol.equals(token)) {
                return true;
            }
        }
        return false;
    }

    public static String getRegexGroup() {
        StringBuilder regex = new StringBuilder();
        regex.append("[");
        for (OPERATOR_TOKEN op : values()) {
            String sym = op.symbol;
            if (sym.length() == 1 && !Character.isLetter(sym.charAt(0))) {
                regex.append("\\").append(sym);
            }
        }
        regex.append("]");
        return regex.toString();
    }
}
