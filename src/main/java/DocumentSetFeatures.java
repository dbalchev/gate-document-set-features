import gate.Document;
import gate.FeatureMap;
import gate.creole.AbstractLanguageAnalyser;
import gate.creole.ExecutionException;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;
import gate.creole.metadata.RunTime;

@CreoleResource(name = "Document Feature Setter",
        comment = "Sets features on each document.")
public class DocumentSetFeatures extends AbstractLanguageAnalyser {

    private FeatureMap newFeatures;

    public FeatureMap getNewFeatures() {
        return newFeatures;
    }

    @RunTime
    @CreoleParameter(comment = "The features that have to be set.")
    public void setNewFeatures(FeatureMap newFeatures) {
        this.newFeatures = newFeatures;
    }

    @Override
    public void execute() throws ExecutionException {
        Document document = getDocument();
        FeatureMap documentFeatures = document.getFeatures();
        documentFeatures.putAll(newFeatures);
    }

}
