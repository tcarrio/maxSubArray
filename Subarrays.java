import java.util.concurrent.ThreadLocalRandom;

public class Subarrays {

    private static int[][] testArrays = new int[][]{ 
        new int[]{1, -8, 2, -4, 0, 8, 3, 4}, 
        new int[]{1, 7, -5, -1, 7},
        new int[]{5, 3, -2, -7, 9, -1, 1, 4, 6, 2},
        new int[]{-4, 12, -9, 2, 5, -21, 16, 4, -3, 6},
        new int[]{3, -6, 9, -12, 7, 4, 2, 5, -6, 7} // ,
        // randomArray(10,10),
        // randomArray(100,100),
        // randomArray(1000,1000),
        // randomArray(10000,10000)
    };
    
    public static void main(String[] args){

        int sum = 0;

        System.out.println("Beginning max subarrays algorithm testing");

        System.out.printf("Using these test arrays:\n");
        for(int l = 0; l < testArrays.length; l++){
            System.out.printf("Using test array %d: [ ",l+1);
            for( int i : testArrays[l]){
                System.out.printf("%3d ",i);
            }
            System.out.printf("]\n");
        }        
        
        for(int[] testArray : testArrays){
            long startTime = System.nanoTime();
            sum = maxSubSlow(testArray);
            long totalTime = System.nanoTime() - startTime;
            System.out.printf("Using maxSubSlow\tMax:%d\tTime:%d\n", sum,totalTime);      
        }

        for(int[] testArray : testArrays){
            long startTime = System.nanoTime();
            sum = maxSubFaster(testArray);
            long totalTime = System.nanoTime() - startTime;
            System.out.printf("Using maxSubFaster\tMax:%d\tTime:%d\n", sum,totalTime);      
        }

        for(int[] testArray : testArrays){
            long startTime = System.nanoTime();
            sum = maxSubFastest(testArray);
            long totalTime = System.nanoTime() - startTime;
            System.out.printf("Using maxSubFastest\tMax:%d\tTime:%d\n", sum,totalTime);      
        }


    }

    public static int maxSubSlow(int[] tA){
        int tmax = 0;
        for(int i=0; i<tA.length; i++){
            int tsum = 0;
            for(int j=i;j<tA.length; j++){
                tsum += tA[j];
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
        for(int i=1;i<S.length;i++){
            int tsum = 0;
            for(int j=1;j<S.length;j++){
                tsum = S[i] - S[j-1];
                if(tsum > tmax){
                    tmax = tsum;
                }
            }
        }
        return tmax;
    }

    public static int maxSubFastest(int[] tA){
        return -1;
    }

    private static int[] randomArray(){
        return randomArray(1,16);
    }

    private static int[] randomArray(int start, int end){
        int array_length = ThreadLocalRandom.current().nextInt(start, end+1);
        int[] tempArray = new int[array_length];
        for(int i=0; i<array_length; i++){
            tempArray[i] = ThreadLocalRandom.current().nextInt(-10,17);
        }
        return tempArray;
    }
}