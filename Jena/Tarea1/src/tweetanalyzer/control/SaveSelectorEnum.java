package tweetanalyzer.control;

import java.util.Arrays;
import org.apache.thrift.server.THsHaServer;

public enum SaveSelectorEnum {
    RDFXML(1, "RDF/XML"), 
    TURTLE(2, "Turtle");
    
    private int id;
    private String format;

    private SaveSelectorEnum(int id, String format) {
        this.id = id;
        this.format = format;
    }
    
    public static SaveSelectorEnum getFromFormat(String e) {
        for (SaveSelectorEnum v : SaveSelectorEnum.values()) {
            if (v.format.equalsIgnoreCase(e)) {
                return v;
            }
        }
        return null;
    }
}
