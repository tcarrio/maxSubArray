import java.util.concurrent.ThreadLocalRandom;

public class Subarrays {

    private static int[][] testArrays = new int[][]{ 
        randomArray(1000),
        randomArray(5000),
        randomArray(10000),
        randomArray(20000),
        randomArray(50000),
        randomArray(100000)
    };
    
    public static void main(String[] args){

        int sum = 0;

        System.out.println("Beginning max subarrays algorithm testing");

        System.out.println("");

        System.out.printf("Using maxSubFastest:\n");
        for(int[] testArray : testArrays){
            long startTime = System.nanoTime();
            sum = maxSubFastest(testArray);
            long totalTime = System.nanoTime() - startTime;
            System.out.printf("Size:%6d\tMax:%6d\tTime:%d\n", testArray.length, sum,totalTime);
        }

        System.out.println("");

        System.out.printf("Using maxSubFaster:\n");
        for(int[] testArray : testArrays){
            long startTime = System.nanoTime();
            sum = maxSubFaster(testArray);
            long totalTime = System.nanoTime() - startTime;
            System.out.printf("Size:%6d\tMax:%6d\tTime:%d\n", testArray.length, sum,totalTime);
        }        

        System.out.println("");
        
        System.out.printf("Using maxSubSlow:\n");
        for(int[] testArray : testArrays){
            long startTime = System.nanoTime();
            sum = maxSubSlow(testArray);
            long totalTime = System.nanoTime() - startTime;
            System.out.printf("Size:%6d\tMax:%6d\tTime:%d\n", testArray.length, sum,totalTime);
        }
    }

    public static int maxSubSlow(int[] tA){
        int tmax = 0;
        for(int j=0; j<tA.length; j++){
            for(int k=j;k<tA.length; k++){
                int tsum = 0;
                for(int i=j;i<k;i++){
                    tsum += tA[i];
                }
                if(tsum>tmax){
                    tmax = tsum;
                }
            }
        }
        return tmax;
    }

    public static int maxSubFaster(int[] tA){
        int[] S = new int[tA.length+1];
        S[0] = 0;
        for(int i=1;i<S.length;i++){
            S[i] = S[i-1] + tA[i-1];
        }
        int tmax = 0;
        int tsum = 0;
        for(int i=1;i<S.length;i++){
            for(int j=i;j<S.length;j++){
                tsum = S[j] - S[i-1];
                if(tsum > tmax){
                    tmax = tsum;
                }
            }
        }
        return tmax;
    }

    public static int maxSubFastest(int[] tA){
        int[] M = new int[tA.length+1];
        M[0] = 0;
        for(int i=1;i<M.length;i++){
            int tM = M[i-1] + tA[i-1];
            if(tM>0)
                M[i] = tM;
        }
        int tmax = 0;
        for(int i=0;i<M.length;i++){
            if(M[i] > tmax)
                tmax = M[i];
        }
        return tmax;
    }

    private static int[] randomLengthArray(){
        return randomArray(1,16);
    }

    private static int[] randomArray(int constant){
        return randomArray(constant,constant);
    }

    private static int[] randomArray(int start, int end){
        int array_length = ThreadLocalRandom.current().nextInt(start, end+1);
        int[] tempArray = new int[array_length];
        for(int i=0; i<array_length; i++){
            tempArray[i] = ThreadLocalRandom.current().nextInt(-25,26);
        }
        return tempArray;
    }
}