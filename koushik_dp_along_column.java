import java.util.*;

class Main {
    static int[] findmax(int dp[][],int c,int r){
        int f=Math.max(dp[0][c],dp[1][c]);
        int s=Math.min(dp[0][c],dp[1][c]);
        for(int i=2;i<r;i++){
            if(dp[i][c]>f){
                s=f;
                f=dp[i][c];
            }
            else if(dp[i][c]>s){
                s=dp[i][c];
            }            
        }
        return new int[]{f,s};
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter rows: ");
        int row=sc.nextInt();
        
        System.out.print("Enter cols: ");
        int col=sc.nextInt();
        
        int arr[][]=new int[row][col];
        int dp[][]=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=sc.nextInt();
                if(j==0){
                    dp[i][j]=arr[i][j];
                }
            }
        }
        for(int i=1;i<col;i++){
            int max[]=findmax(dp,i-1,row);
            for(int j=0;j<row;j++){
                if(max[0]!=dp[j][i-1]){
                    dp[j][i]=max[0]+arr[j][i];
                }
                else{
                    dp[j][i]=max[1]+arr[j][i];
                }
            }   
        }
        int d[]=findmax(dp,col-1,row);
        System.out.println("Largest number: "+d[0]);
    }
}