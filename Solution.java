import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
	public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
		int count = 0;
		int sum = 0;
		int maxCount = 0;
		int i=0,j=0;
		while(sum + a.get(i)<= maxSum && i<a.size()){
		    sum+= a.get(i);
		    i++;
		    count++;
		}
		maxCount = count;
		while(j < b.size() && (i>0 || sum+b.get(j)<= maxSum)){
		    sum+= b.get(j);
		    j++;
		    count++;
		    while(sum > maxSum && i>0){
		        i--;
		        sum-=a.get(i);
		        count--;
		    }
		    maxCount = Math.max(count,maxCount);
		}
	return maxCount;
	}
}
public class Solution {
    public static void main(String[] args) throws IOException {
    	 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int g = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, g).forEach(gItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int maxSum = Integer.parseInt(firstMultipleInput[2]);

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                int result = Result.twoStacks(maxSum, a, b);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
