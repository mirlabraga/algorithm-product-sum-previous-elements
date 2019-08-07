# Algorithm

You have a range of consecutive numbers, from 1 to n (inclusive). e.g. [1,2,3,4,...,n].

We would like to calculate a sum of a function across the entire range, where the function returns the product of the *preceding* C elements.

If there are less than C previous elements, just use the available numbers. i.e. if you are processing the fourth number in the range, but C is greater than 3, then you will calculate the product using only the 3 available preceding numbers.

In this situation as you move further along in this range more preceding numbers become available.

A worked example follows: if n=5 and C=2, the correct products and final sum for each element of the range are: 0 + 1 + 2 + 6 + 12 = 21

* Initially calculate the value where n=100 and C=10, and let us know the answer
* Please additionally tell us the values where n=1000000 and C=200, but only include the first 10 digits of    the result in your answer.
* What if you needed to calculate n=10,000,000 and C=200 ?


## Development Requirements

- Java >= 8

## Solution

```
package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PreviousElements {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    double n;
    double c;

    scanner.useDelimiter(System.getProperty("line.separator"));
    System.out.println("Enter the N number:");
    n = scanner.nextDouble();
    scanner.nextLine();
    System.out.println("Enter the C number:");
    c = scanner.nextDouble();

    List<Double> list = new ArrayList<Double>();
    double i = 0;
    double previous = 0;

    while (i < n) {
      if (i <= c) {
        list.add(i);
      } else {
        list.add(i * previous);
      }
      previous = i;
      i++;
    }

    // If would like to show the list
    // System.out.println(Arrays.toString(list.toArray()));
    double sum = list.stream().mapToDouble(value -> value).sum();
    Long aroundSum = Math.round(sum);

    if (aroundSum.toString().length() > 10) {
   	 System.out.println("The sum value is: "+aroundSum.toString().substring(0, 10));
    } else {
     System.out.println("The sum value is: "+aroundSum);
    }

    scanner.close();
  }
}
```
