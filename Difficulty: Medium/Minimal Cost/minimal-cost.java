//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    public int minimizeCost(int k, int arr[]) {
        int dp[]=new int[arr.length+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<arr.length;i++)
        {
            int mmSteps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++)
            {
                if(i-j >=0)
                {
                    int jump=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                    mmSteps=Math.min(mmSteps,jump);
                }
            }
            dp[i]=mmSteps;
        }
        
        return dp[arr.length-1];
    }
    // private int findingMinCost(int[] arr,int k,int ind,int[] dp)
    // {
    //     if(ind<=0) return 0;
    //     if(dp[ind]!=-1) return dp[ind];
    //     int mSteps=Integer.MAX_VALUE;
    //     for(int i=1;i<=k;i++)
    //     {
    //         if(ind-i >= 0)
    //         {
    //             int jump=findingMinCost(arr,k,ind-i,dp)+Math.abs(arr[ind]-arr[ind-i]);
    //             mSteps=Math.min(mSteps,jump);
    //         }
    //     }
    //     return dp[ind]=mSteps;
    // }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends