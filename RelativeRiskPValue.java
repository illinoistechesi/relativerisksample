public class RelativeRiskPValue {
    
    public static void main(String[] args){
        try{
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);
            double d = Double.parseDouble(args[3]);
            double t = a + b + c + d;
            double chiBase = Math.abs((a*d) - (b*c)) - (0.5*t);
            double chiNum = t * Math.pow(chiBase, 2);
            double chiDen = (a+b) * (c+d) * (a+c) * (b+d);
            double chiSqr = chiNum / chiDen;
            double fish1 = fishersExact(a, b, c, d);
            System.out.println("FISHER'S EXACT TEST OF STATISTICAL SIGNIFICANCE FOR RELATIVE RISK:");
            System.out.println("Input: " + a + ", " + b + ", " + c + ", " + d);
            System.out.println("One-Tailed p-value: " + fish1);
        }
        catch(Exception err){
            if(args.length != 4){
                System.out.println("Must provide exactly 4 numbers to program.");
            }
            else{
                System.out.println("Could not complete program, error: " + err);
            }
        }
    }
    
    public static double fishersExact(double a, double b, double c, double d){
        double n = a + b + c + d;
        double num = factorial(a+b) * factorial(c+d) * factorial(a+c) * factorial(b+d);
        double den = factorial(a) * factorial(b) * factorial(c) * factorial(d) * factorial(n);
        double p = num / den;
        return p;
    }
    
    public static double factorial(double n){
        double res = 1;
        while(n > 0){
            res *= n;
            n--;
        }
        return res;
    }


}