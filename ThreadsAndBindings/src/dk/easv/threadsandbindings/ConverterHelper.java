package dk.easv.threadsandbindings;

import javafx.util.StringConverter;

/**
 * Utility class that helps us convert to+from the String/Number
 */
public class ConverterHelper extends StringConverter<Number> {

    /**
     * Convert from Number num to String
     * @param num the object of type {@code T} to convert
     * @return
     */
    @Override
    public String toString(Number num) {
        return num.toString();
    }

    /**
     *
     * @param string the {@code String} to convert
     * @return
     */
    @Override
    public Number fromString(String string) {
        try {
            Double d = Double.parseDouble(string);
            return d;
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}