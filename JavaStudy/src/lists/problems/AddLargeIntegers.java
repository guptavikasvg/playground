package lists.problems;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Add large integers provided in lists
 */
public class AddLargeIntegers {

    static List<Integer> add(List<List<Integer>> numbers) {
        int maxNumDigits = getMaxNumDigits(numbers);

        List<Integer> sum = new ArrayList<>();
        int carry = 0;

        for (int k = 0; k < maxNumDigits; k++) {
            int sumOfKthDigit = addKthDigit(numbers, k);

            // put one digit in output list and store rest in carry
            sumOfKthDigit += carry;
            int outputDigit = sumOfKthDigit % 10;
            carry = sumOfKthDigit / 10;

            sum.add(outputDigit); // output list
        }

        sum.add(carry);

        return sum;
    }

    private static int getMaxNumDigits(List<List<Integer>> numbers) {
        int maxNumDigits = 0;
        for (List<Integer> number : numbers) {
            if (maxNumDigits < number.size()) {
                maxNumDigits = number.size();
            }
        }

        return maxNumDigits;
    }

    private static int addKthDigit(List<List<Integer>> numbers, int k) {
        int sum = 0;
        for (List<Integer> number : numbers) {
            if (k < number.size()) {
                int unitPlaceDigit = number.get(k);
                sum += unitPlaceDigit;
            }
        }

        return sum;
    }

    @Test
    public void test1() {
        List<Integer> list1 = Lists.newArrayList(9, 9);
        List<Integer> list2 = Lists.newArrayList(8, 8);
        List<List<Integer>> numbers = Lists.newArrayList(list1, list2);
        System.out.println(add(numbers));

        list1 = Lists.newArrayList(9, 9, 9, 9);
        list2 = Lists.newArrayList(9, 9, 9);
        numbers = Lists.newArrayList(list1, list2);
        System.out.println(add(numbers));

        list1 = Lists.newArrayList(1);
        list2 = Lists.newArrayList(1);
        numbers = Lists.newArrayList(list1, list2);
        System.out.println(add(numbers));

        list1 = Lists.newArrayList(1, 0);
        list2 = Lists.newArrayList(0, 2);
        List<Integer> list3 = Lists.newArrayList(3, 2);
        List<Integer> list4 = Lists.newArrayList(4, 1);
        numbers = Lists.newArrayList(list1, list2, list3, list4);
        System.out.println(add(numbers));
    }
}
