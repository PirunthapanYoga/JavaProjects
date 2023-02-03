public class Test {
    public static void main(String args[]){
        int[] x =new int[]{5,10,8,7,6,2,1,9,4,3};

        int iteration =0;
        int min=100;
        int index = 0;

        for(int i=0;i<x.length;i++){
            for(int j=i;j<x.length;j++){
                if(x[j]<min){
                    min=x[j];
                    index=j;
                }
                iteration++;
            }

            x[index] = x[i];
            x[i] = min;
            min=100;

            for(int k=0;k<x.length;k++){
                System.out.print(x[k] + " ");
            }

            System.out.println("Iteration :" + iteration);
            System.out.println();
        }
    }

}
