package regression;
import static java.lang.Math.*;
import java.util.Scanner;

public class Implementing {
    
    private double x[];
    private double y[];
    private int n;
    private double sumXY = 0, sumX = 0, sumY = 0, sumX2 = 0;
    private double promX = 0, promY = 0;
    private double bta1 = 0, bta0 = 0;
    private double regress = 0;
    private double indiv = 0;
    
    public Implementing(int n) {
        
        this.n = n;
        this.x = new double [n];
        this.y = new double [n];
        
    }

    public Implementing() {
    }
    
    public void inputData(int datos){

        this.n = datos;
        Scanner in = new Scanner(System.in);
        x = new double [n];
        y = new double [n];
                
        for(int i = 0; i < n; i++){
            System.out.println("Ingrese el valor para X: ");
            x[i] = in.nextDouble();
        }

        for(int i = 0; i < n; i++){
            System.out.println("Ingrese el valor para Y: ");
            y[i] = in.nextDouble();
        }
        
    }
    
    public void beta1(){
        
        for (int i = 0; i < n; i++) {
            sumX += x[i]; 
            sumY += y[i];
            sumX2 += x[i] * x[i];
            sumXY += x[i] * y[i];
        }
        
        promX = sumX / n;
        promY = sumY / n;
        bta1 = ((n * sumXY) - (sumX * sumY))/ ((n * sumX2) - Math.pow(sumX, 2));
        System.out.println("\nEl valor de Beta1 es: " + bta1); 
        
    }
    
    public void beta0(){
        
        bta0 = (promY - (bta1 * promX));
        System.out.println("\nEl valor de Beta0 es: " + bta0); 
        
    }
    
    public void regression(double individual){
        
        this.indiv = individual;
        regress = (bta0 + (bta1 * indiv));
        System.out.println("\nRegresión lineal es: " + regress); 
        
    }

}
