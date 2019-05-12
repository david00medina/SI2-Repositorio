package inferencerdfs.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.ReasonerVocabulary;

public class ReasonerInference {
    private Reasoner reasoner;
    private InfModel inferredGraph;
    
    private Model scheme;
    private Model data;
    
    private List<String> inferredClasses;
    private List<String> constraintErrors;
    
    public ReasonerInference() {
        LogCtl.setCmdLogging();
        
        inferredClasses = new ArrayList<>();
        constraintErrors = new ArrayList<>();
    }
    
    public void feedModel(ModelLoaderSelector mls, String path) {
        if (path != null) {
            switch (mls) {
                case SCHEME:
                    scheme = RDFDataMgr.loadModel(path);
                    break;
                case DATA:
                    data = RDFDataMgr.loadModel(path);
                    break;
                default:
                    break;
            }
        }
    }
    
    public void makeInferences() {
        reasoner = ReasonerRegistry.getRDFSReasoner();
        reasoner.setParameter(ReasonerVocabulary.PROPsetRDFSLevel, ReasonerVocabulary.RDFS_SIMPLE);
        
        if (scheme != null && data != null) {
            reasoner = reasoner.bindSchema(scheme);
            inferredGraph = ModelFactory.createInfModel(reasoner,data);
        } else 
            return;
        
        
        buildInferredClasses();
        buildConstraintErrors();
    }
    
    public List<String> getInferredClasses() {
        return inferredClasses;
    }

    private void buildInferredClasses() {
        inferredClasses.clear();
        StmtIterator it = inferredGraph.listStatements((Resource) null, RDF.type, (RDFNode)null);
        while (it.hasNext()) {
            Statement declaration = it.next();
            inferredClasses.add(declaration.toString());
        }
    }
    
    public List<String> getContraintErrors() {
        return constraintErrors;
    }

    private void buildConstraintErrors() {
        constraintErrors.clear();
        ValidityReport validation = inferredGraph.validate();
        if (!validation.isValid()) {
            System.out.println("GRAFO INCORRECTO");
            Iterator it  = validation.getReports();
            while(it.hasNext()) {
                Object record = it.next();
                constraintErrors.add(record.toString());
            }
        }
    }
}
