package regression;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.Scanner;

class SimpleLinearJade extends Agent{
   @Override
    protected void setup() {
        
        int datos = 0;
        double individual = 0;
        Scanner sc = new Scanner(System.in);
        
        Implementing valor = new Implementing();
        
        System.out.println("Ingrese el num de datos para X y Y: \n");
        datos = sc.nextInt();
        valor.inputData(datos);        
        
        valor.beta1();
        valor.beta0();
        
        System.out.println("\nIngrese el valor individual(X): ");
        individual = sc.nextDouble();
        valor.regression(individual);
        
        addBehaviour(new MyOneShotBehaviour());
    }
    
    private class MyOneShotBehaviour extends OneShotBehaviour {
        
        @Override
        public void action() {
            System.out.println("Agent activated");
        }
        
        @Override
        public int onEnd() {
            System.out.println("Agent killed");
            myAgent.doDelete();
            return super.onEnd();
        }
        
    } 
}
