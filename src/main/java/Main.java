import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
       // System.out.println(addBinary("11","1"));
        System.out.println(isIsomorphic("egg","add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        String k = s.chars().distinct().toString();
        int[] l = t.chars().distinct().toArray();
        return true;
    }

    public static String addBinary(String a, String b) {
        int result = Integer.parseInt(a,2)+Integer.parseInt(b,2);
        return Integer.toBinaryString(result);
    }

    public static boolean isHappy(int n) {
        String str = ""+n;
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j = 0; j<str.length();j++) {
                sum+=Math.pow(Character.getNumericValue(str.charAt(j)),2);
            }
            if (sum==1) {
                return true;
            }
            str = "" + sum;
        }
        return false;
    }

    public static boolean isPalindrome(String s) {
        StringBuilder str1 = new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]",""));
        return str1.toString().equals(str1.reverse().toString());
    }

    public static int missingNumber(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] m = IntStream.range(0,Arrays.stream(nums).max().orElse(0)+2).toArray();
        return m[Arrays.mismatch(nums,m)];
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows<1) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int i=1;i<numRows;i++){
            result.add(new ArrayList<>());
            for (int j=0;j<=i;j++) {
                if (result.get(i).size()==0||result.get(i).size()==i){
                    result.get(i).add(1);
                } else {
                    result.get(i).add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
                }
            }
        }
        return result;
    }
}
