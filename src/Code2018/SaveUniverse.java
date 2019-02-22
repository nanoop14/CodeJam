package Code2018;

import java.io.IOException;
import java.util.Scanner;

public class SaveUniverse {
    public static void main(String[] args) throws IOException {
        int T;
        Scanner sc = new Scanner(System.in);
        T=sc.nextInt();
        for(int i=0;i<T;i++){
            long D=sc.nextLong();
            String inputStr=sc.next();
            String out;
            int numswaps=getSwapCount(inputStr,D);
            if(numswaps==-1){
                out="IMPOSSIBLE";
            }
            else{
                out=String.valueOf(numswaps);
            }
            System.out.println("Case #" + i + ": " + out);

        }

    }

    private static int getSwapCount(String inputStr, long d) {

        int swaps=0;


        if(getBeamValue(inputStr)<=d)
            return 0;
        while(true){
            boolean swapPossible=false;
            for(int j=inputStr.length()-1;j>0;j--){


                if(inputStr.charAt(j)=='S' && inputStr.charAt(j-1)=='C'){
                    ++swaps;
                    StringBuilder sb=new StringBuilder(inputStr);
                    sb.setCharAt(j,'C');
                    sb.setCharAt(j-1,'S');
                    inputStr=sb.toString();
                    swapPossible=true;
                    break;
                }
            }
            if(!swapPossible){
                break;
            }
            if(getBeamValue(inputStr)<=d){
                break;
            }

        }
        if(getBeamValue(inputStr)<=d)
        return swaps;
        return -1;

    }

    private static long getBeamValue(String inputStr) {
        long strength=1;
        long totalStrength=0;
        for(char ch:inputStr.toCharArray()){
            if(ch=='C'){
                strength=strength*2;
            }
            else if(ch=='S'){
                totalStrength=totalStrength+strength;
            }
        }
        return totalStrength;
    }
}
