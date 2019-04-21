import java.util.*;
import java.io.*;

class BuildingPalindrome{
    public static boolean canBuildPalindrome(String word, int len){
        int[] char_array = new int[256];
        Arrays.fill(char_array, 0);
        for (int i = 0; i < len; i++){
            char_array[(int) word.charAt(i)]++;
        }
        int oddCount = 0; 
        for (int i = 0; i < 256; i++){ 
            if ((char_array[i] & 1) == 1) 
                oddCount++; 

            // Return false if oddCount is greater than 1
            if (oddCount > 1) 
                return false; 
        } 
      
        // Return true if oddCount is 0 or 1
        return true;
    }
    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);
        int test_cases = scan.nextInt();
        scan.nextLine();
        int run = 1;
        // Loop Based on number of test cases.
        for (int i = 0; i < test_cases; i++){

            // System.out.println(14);
            int ret = 0;
            String blocks_and_cases = scan.nextLine();

            String[] temp = blocks_and_cases.split(" ");

            // Get number of cases for each string
            String cases = temp[1];
            
            // Get the string associated with the block.
            String input = scan.nextLine();

            // Run a loop for each case
            for (int j = 0; j < Integer.parseInt(cases); j++){
                // Get the block location start/end and run a loop to check those blocks.
                String[] currentTestCase = scan.nextLine().split(" ");
                int start = Integer.parseInt(currentTestCase[0]);
                int end = Integer.parseInt(currentTestCase[1]);
                
                ret += (canBuildPalindrome(input.substring(start - 1, end), end - start + 1)) ? 1 : 0;

            }
            System.out.println("Case #" + run + ": = " + ret);
            run++;
            
        }
        scan.close();
    }
}