package Code2018;

import java.io.IOException;
import java.util.Scanner;

class TroubleSort{
    public static void main(String[] args) throws IOException {
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        String out;
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] array=new int[N];
            for(int j=0;j<N;j++){
                array[i]=sc.nextInt();
            }

            int k=getIndexforTroubleSort(array);
            if(k==-1){
                out="OK";
            }
            else{
                out=String.valueOf(k);
            }
            System.out.println("Case #" + i + ": " + out);

        }
    }

    private static int getIndexforTroubleSort(int[] array) {
        boolean done=false;
        while(!done){
            done=true;
            for(int i=0;i<array.length-2;i++){
                if(array[i]>array[i+2]){
                    done=false;
                    int temp=array[i];
                    array[i]=array[i+2];
                    array[i+2]=temp;
                }
            }
        }
        for(int i=1;i<array.length;i++){
            if(array[i]<array[i-1]){
                return i-1;
            }
        }
        return -1;
    }
}
