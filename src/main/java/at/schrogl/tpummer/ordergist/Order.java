package at.schrogl.tpummer.ordergist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Description https://gist.github.com/tpummer/dbdc0e7ea09368dc36a47650cad963ab
 */
public class Order {

  public static String order(String words) {
    if (words == null || words.isEmpty())
      return "";

    return Arrays.stream(words.split(" "))
        .sorted(new OrderComparator())
        .collect(Collectors.joining(" "));
  }

  private static class OrderComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
      return getInt(s1).compareTo(getInt(s2));
    }

    private Integer getInt(String s) {
      for (char c : s.toCharArray()) {
        if (c >= 48 && c <= 57) {
          return (int) c;
        }
      }
      return 0;
    }
  }
}
