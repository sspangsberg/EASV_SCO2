package jfeonixexamples;

import javafx.util.StringConverter;

//Utility class that helps us convert to+from the String/Number
public class ConverterHelper extends StringConverter<Number> {

    @Override
    public String toString(Number num) {
        return num.toString();
    }

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
