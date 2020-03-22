import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ModelWeightAlgorithm {
    private int modelNumber; //
    private Double[] weights; //itt tárolom, mert egy modellnek más lesz a súlya más környezetben
    private double expected = 0; //a várható érték az adott pillanatbeli modell-pontosságok alapján

    ModelWeightAlgorithm(int m){
        modelNumber = m;
        weights = new Double[m];
        for(int i = 0; i < modelNumber; i++){
            weights[i] = new Double(1.0/modelNumber);
        }
    }

    public void algorithm(Model[] models, double s) {
        double sum = 0;
        expected = 0;
        for(int i = 0; i < modelNumber; i++){
            weights[i] = weights[i] * Math.exp(-1*s*Math.log((1-models[i].getCorrect())/models[i].getCorrect()));
            sum += weights[i];
        }
        for(int i = 0; i< modelNumber; i++){
            weights[i]=weights[i]/sum;
            expected += weights[i]*models[i].getCorrect();
        }
    }

    public void printWeights(){
        NumberFormat formatter = new DecimalFormat("#0.000");
        for(int i = 0; i < modelNumber; i++){
            System.out.print(formatter.format(weights[i]) + " ");
        }
        System.out.print("expected: " + formatter.format(expected) +"\n");
    }
}
