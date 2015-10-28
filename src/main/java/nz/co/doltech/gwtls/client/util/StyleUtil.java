package nz.co.doltech.gwtls.client.util;

import com.google.gwt.dom.client.Style.Unit;

public class StyleUtil {

    public static Double getMeasurementValue(String value) {
        if(value == null) {
            return null;
        }
        return Double.parseDouble(value
            .replaceAll(Unit.CM.getType(), "")
            .replaceAll(Unit.EM.getType(), "")
            .replaceAll(Unit.EX.getType(), "")
            .replaceAll(Unit.IN.getType(), "")
            .replaceAll(Unit.MM.getType(), "")
            .replaceAll(Unit.PC.getType(), "")
            .replaceAll(Unit.PCT.getType(), "")
            .replaceAll(Unit.PT.getType(), "")
            .replaceAll(Unit.PX.getType(), ""));
    }

    public static Unit getMeasurementUnit(String value) {
        if(value == null) { return null; }
        try {
            return Unit.valueOf(value.replaceAll("^[\\d-]*\\s*", "").toUpperCase());
        }
        catch(IllegalArgumentException e) {
            // Silently catch invalid units
            return null;
        }
    }
}
