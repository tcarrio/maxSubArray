import java.util.concurrent.ThreadLocalRandom;

// Earlier test cases:
// new int[]{},
// new int[]{},
// new int[]{1, -8, 2, -4, 0, 8, 3, 4}, 
// new int[]{1, 7, -5, -1, 7},
// new int[]{5, 3, -2, -7, 9, -1, 1, 4, 6, 2},
// new int[]{-4, 12, -9, 2, 5, -21, 16, 4, -3, 6},
// new int[]{3, -6, 9, -12, 7, 4, 2, 5, -6, 7} ,
// new int[]{-1, -2, -3, -4, -5} ,
// randomArray(10,10),
// randomArray(100,100),
//
// Display test cases
// System.out.printf("Using these test arrays:\n");
// for(int l = 0; l < testArrays.length; l++){
//     System.out.printf("Using test array %d: [ ",l+1);
//     for( int i : testArrays[l]){
//         System.out.printf("%3d ",i);
//     }
//     System.out.printf("]\n");
// }

public class Subarrays {

    private static int[][] testArrays = new int[][]{ 
        randomArray(1000,1000),
        randomArray(5000,5000),
        randomArray(10000,10000),
        randomArray(20000,20000),
        randomArray(50000,50000),
        randomArray(100000,100000)
    };
    
    public static void main(String[] args){

        int sum = 0;

        System.out.println("Beginning max subarrays algorithm testing");

        System.out.println("");
        
        for(int[] testArray : testArrays){
            long startTime = System.nanoTime();
            sum = maxSubSlow(testArray);
            long totalTime = System.nanoTime() - startTime;
            System.out.printf("Using maxSubSlow\tMax:%6d\tTime:%d\n", sum,totalTime);      
        }

        System.out.println("");

        for(int[] testArray : testArrays){
            long startTime = System.nanoTime();
            sum = maxSubFaster(testArray);
            long totalTime = System.nanoTime() - startTime;
            System.out.printf("Using maxSubFaster\tMax:%6d\tTime:%d\n", sum,totalTime);      
        }

        System.out.println("");

        for(int[] testArray : testArrays){
            long startTime = System.nanoTime();
            sum = maxSubFastest(testArray);
            long totalTime = System.nanoTime() - startTime;
            System.out.printf("Using maxSubFastest\tMax:%6d\tTime:%d\n", sum,totalTime);      
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

    private static int[] randomArray(){
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