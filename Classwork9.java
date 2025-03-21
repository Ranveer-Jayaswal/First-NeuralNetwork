public class Classwork9 {
//My first neural network
//Estimate weight and bias
    public static void main(String[] args){
        double w = -10;
        double b = 20;
        double result[] = new double [2];
        double[] x_train = {0,1,2,3,4,5,6,7,8,9,10};
        double[] y_train = {1,3,5,7,9,11,13,15,17,19,21};
        //y=2x+1
        result = GradDescend(w,b,x_train,y_train);
        System.out.println("w_min= " + result[0]+", b_min= " + result[1]);
    }
    public static double Cost(double w, double b, double[] x_train, double[] y_train){
        double cost = 0;
        for(int i=0;i<x_train.length;i++){
            cost += Math.pow(w*x_train[i]+b-y_train[i],2);
        }
        return cost;
    }
    // public static double[] GradDescend(double w, double b, double[] x_train, double[] y_train){
    //     double[] result=new double[2];
    //     double slope_w;
    //     double dw = 0.00001;
    //     double Y_intb;
    //     double db = 0.00001;
    //     double w_estimate = w;
    //     double b_estimate = b;
    //     double tolerance = 1E-9;
    //     int iteration = 0;
    //     int Max_iteration = 10000;
    //     double dCost_w = 10;
    //     double dCost_b = 10;
    //     double cost ;
    //     while((Math.abs(dCost_w) > tolerance) && (iteration < Max_iteration)){
    //         dCost_w = Cost(w_estimate+dw, b_estimate, x_train, y_train) - Cost(w_estimate-dw, b_estimate, x_train, y_train);
    //         slope_w = dCost_w/(2*dw);
    //         w_estimate = w_estimate - slope_w*dw;

    //         dCost_b = Cost(b_estimate+db, w_estimate, x_train, y_train) - Cost(b_estimate-db, w_estimate, x_train, y_train);
    //         Y_intb = dCost_b/2;
    //         b_estimate = b_estimate - Y_intb*db;


    //         cost=Cost(w_estimate, b_estimate, x_train, y_train);
    //         System.out.println("iteration= " + iteration + ", cost= " + cost + ", w_estimate= " + w_estimate + ", b_estimate= " + b_estimate);

    //         iteration++;
    //     }

    //     result[0]=w_estimate;
    //     result[1]=b_estimate;

        
    //     return result;
        
    // }
    public static double[] GradDescend(double w, double b, double[] xtrain, double[] ytrain) {
        double[] result = new double[2];
        double learningRate = 0.01;
        double tolerance = 1E-9;
        int maxIterations = 1000000;
 
 
        for (int iteration = 0; iteration < maxIterations; iteration++) {
            double dw = 0;
            double db = 0;
           
            // Calculate gradients
            for (int i = 0; i < xtrain.length; i++) {
                double error = (w * xtrain[i] + b) - ytrain[i];
                dw += (2.0 / xtrain.length) * error * xtrain[i];
                db += (2.0 / xtrain.length) * error;

                System.out.println("iteration= " + iteration + ", w_estimate= " + w + ", b_estimate= " + b);

                iteration++;
            }
 
 
          
            w -= learningRate * dw;
            b -= learningRate * db;
 
 
            // Check for convergence
            if (Math.abs(dw) < tolerance && Math.abs(db) < tolerance) {
                break; // Exit if converged
            }
        }
 
 
        // Round results to 2 decimal places
        result[0] = w; // Estimated weight
        result[1] = b; // Estimated bias
        return result;
    }
 
}