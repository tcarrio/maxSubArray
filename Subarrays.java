public class Subarrays {

    private static int[] A = new int[]{1, -8, 2, -4, 0, 8, 3, 4};
    private static int[] B = new int[]{1, 7, -5, -1, 7};
    public static void main(String[] args){

        int sum = 0;

        System.out.println("Beginning max subarrays algorithm testing");
        
        System.out.printf("Using test array A: [ ");
        for( int i : A){
            System.out.printf("%3d ",i);
        }
        System.out.printf("]\n");

        sum = maxSubSlow(A);
        System.out.printf("Using MaxsubSlow: %d\n", sum);      
        sum = maxSubSlow(B);
        System.out.printf("Using MaxsubSlow: %d\n", sum);      
       
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

    public static int maxSubSlow2(int[] tA){
        return -1;
    }
}