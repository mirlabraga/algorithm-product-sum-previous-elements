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
