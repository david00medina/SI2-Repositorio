package control.sparql;

import control.sparql.enums.SPARQLFormatEnum;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QueryParseException;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

public class SPARQLQuery {
    
    private static final String RDF = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n";
    private static final String DCTERMS = "PREFIX dcterms: <http://purl.org/dc/terms/>\n";
    private static final String SKOS = "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>\n";
    private static final String BIBO = "PREFIX bibo: <http://purl.org/ontology/bibo/>\n";
    private static final String RDA = "PREFIX rda: <http://RDVocab.info/Elements>\n";
    private static final String RDFS = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n";
    
    private static String out;
    
    public static String executeLocalQuery(String path, String query, SPARQLFormatEnum sfe) {
        query = RDF + DCTERMS + SKOS + BIBO + RDA + RDFS + query;
        
        try {
            Model data = RDFDataMgr.loadModel(path);
            QueryExecution qExecution = QueryExecutionFactory.create(query, data);
            ResultSet result = qExecution.execSelect();
            out = formatOutput(result, sfe);
            qExecution.close();
        } catch (QueryParseException e) {
            out = buildErrorMessage(e);
        }
        
        return out;
    }
    
    public static String executeRemoteQuery(String url, String query, SPARQLFormatEnum sfe) {
        query = RDF + DCTERMS + SKOS + BIBO + RDA + RDFS + query;
        
        try {
            Query q = QueryFactory.create(query);
            QueryExecution qExecution = QueryExecutionFactory.sparqlService(url, q);
            ((QueryEngineHTTP) qExecution).addParam("timeout","100000");
            ResultSet result = qExecution.execSelect();
            out = formatOutput(result, sfe);
            qExecution.close();
        } catch (QueryParseException e) {
            out = buildErrorMessage(e);
        }
        
        return out;
    }
    
    private static String formatOutput(ResultSet result, SPARQLFormatEnum sfe) {
        switch (sfe) {
            case SRX:
                return ResultSetFormatter.asXMLString(result);
            case TXT:
                return ResultSetFormatter.asText(result);
            default:
                break;
        }
                
        return null;
    }
    
    public static void saveToFile(String path) {
        try {
            
            File f = new File(path);
            FileOutputStream fos = new FileOutputStream(f);
            
            if (f.exists()) f.createNewFile();
            
            byte[] content = out.getBytes();
            
            fos.write(content);
            fos.flush();
            fos.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private static String buildErrorMessage(QueryParseException e) {
        String out = "";
        out += "[!] Error en sisntaxis de la consulta\n";
        out += "Tipo: " + e.getMessage() + "\n";
        out += "Linea: " + e.getLine() + "\n";
        out += "Columna: " + e.getColumn() + "\n";
        return out;
    }
}
