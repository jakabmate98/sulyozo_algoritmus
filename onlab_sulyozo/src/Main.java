
import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static Model[] models;
    public static int modelNumber;
    public static int epoch;
    public static double s;

    public static void main(String[] args) {
        doTheMath();

    }

    public static void doTheMath(){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        modelNumber = input.nextInt();

        s = input.nextDouble();
        //s = input.nextInt()/100.0;
        epoch = input.nextInt();
        models = new Model[modelNumber];
        ModelWeightAlgorithm mwa = new ModelWeightAlgorithm(modelNumber);
        for (int k = 0; k< modelNumber;k++){
            models[k]= new Model();
        }
        System.out.println("\n");
        for(int i = 0; i < epoch; i++){
            for(int j = 0; j < modelNumber; j++){
                models[j].setCorrect(input.nextInt()/100.0);
            }
            mwa.algorithm(models, s);
            mwa.printWeights();
        }
    }




}