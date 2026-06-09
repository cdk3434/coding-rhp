import java.util.*;

class Main {
    static int[] findmax(int dp[][],int r,int c){
        int f=Math.max(dp[r][0],dp[r][1]);
        int s=Math.min(dp[r][0],dp[r][1]);
        for(int i=2;i<c;i++){
            if(dp[r][i]>f){
                s=f;
                f=dp[r][i];
            }
            else if(dp[r][i]>s){
                s=dp[r][i];
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
                if(i==0){
                    dp[i][j]=arr[i][j];
                }
            }
        }
        for(int i=1;i<row;i++){
            int max[]=findmax(dp,i-1,col);
            for(int j=0;j<col;j++){
                if(max[0]!=dp[i-1][j]){
                    dp[i][j]=max[0]+arr[i][j];
                }
                else{
                    dp[i][j]=max[1]+arr[i][j];
                }
            }   
        }
        int d[]=findmax(dp,row-1,col);
        System.out.println("Largest number: "+d[0]);
    }
}