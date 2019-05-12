package tweetanalyzer.control;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.DC_11;
import org.apache.jena.vocabulary.VCARD;
import tweetanalyzer.model.TweetObject;

public class TweetSerializer {
    private Model model;
    
    private static final String BASEURL = "http://www.tweetanalyzer.com/";
    
    
    public TweetSerializer() {
        model = ModelFactory.createDefaultModel();
        //tweet.addProperty(DCTerms.source, tweet);
    }
    
    public void feedModel(TweetObject to, String className) {
        Resource tweet = model.createResource(BASEURL + to.getId());
        Resource user = model.createResource(BASEURL + to.getId() + "/user/");
        Resource language = model.createResource(BASEURL + to.getId() + "/" + to.getLangId() + "/");
        
        
        tweet.addProperty(DCTerms.publisher, user);
        tweet.addProperty(DCTerms.language, language);
        
        SimpleDateFormat formatDate = new SimpleDateFormat();
        tweet.addLiteral(DCTerms.identifier, to.getId());
        tweet.addLiteral(DCTerms.dateSubmitted, formatDate.format(to.getCreatedAt()));
        tweet.addLiteral(DC_11.description, to.getText());
        
        user.addLiteral(DCTerms.creator, to.getUser());
        user.addLiteral(VCARD.Locality, to.getLocation());
        
        language.addLiteral(DCTerms.identifier, to.getLangId());
        language.addLiteral(DCTerms.language, to.getLanguage());
        
        Resource topic = model.createResource(BASEURL + "topic/");
        Resource topicName = model.createResource(BASEURL + topic + "/");
        
        tweet.addProperty(DCTerms.relation, topic);
        topic.addProperty(DCTerms.subject, topicName);
        
        topicName.addLiteral(VCARD.LABEL, className);
    }
    
    public void save(SaveSelectorEnum choice) throws FileNotFoundException {
        FileOutputStream file;
        switch(choice) {
            case RDFXML:
                file = new FileOutputStream("models/model.rdf");
                RDFDataMgr.write(file, model, Lang.RDFXML);
                break;
            case TURTLE:
                file = new FileOutputStream("models/model.ttl");
                RDFDataMgr.write(file, model, Lang.TURTLE);
                break;
            default:
                break;
        }
    }
}
