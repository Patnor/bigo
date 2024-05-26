package com.normile.bigo;

public class BigOExamples {

    // Big O from Algorithms and Data Structures class =========================

    /**
     * Fragment 1
     * O(n) - Linear Time
     * 
     * @param n - the number of iterations
     */
    public void fragment1(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum++;
        System.out.println(sum);

    }

    /**
     * Fragment 2
     * O(n^2) - Quadratic Time
     * 
     * @param n - the number of iterations
     */
    public void fragment2(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sum++;
        System.out.println(sum);
    }

    /**
     * Fragment 3
     * O(n^3) - Cubic Time
     * The outer loop runs n times and the inner loop runs n^2 times
     * so the time complexity is O(n^3)
     * 
     * @param n - the number of iterations
     */
    public void fragment3(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n * n; j++)
                sum++;
        System.out.println(sum);
    }

    /**
     * Fragment 4
     * O(n^2) - Quadratic Time
     * The outer loop runs n times and the inner loop runs n/2 times
     * so the time complexity is O(n^2/2) which will = O(n^2)
     * 
     * @param n - the number of iterations
     */
    public void fragment4(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);
    }

    /**
     * Fragment 5
     * The time complexity of the provided code is O(n^5).
     * 
     * Here's why:
     * 
     * The outer loop runs 'n' times. Inside the outer loop, there's a second loop
     * that runs 'i^2' times, where 'i' is the current iteration of the outer loop.
     * This means that the second loop runs '1^2 + 2^2 + 3^2 + ... + n^2' times in
     * total.
     * The sum of squares of the first 'n' natural numbers is (n*(n+1)*(2n+1))/6,
     * which is O(n^3) in terms of time complexity.
     * 
     * Inside the second loop, there's a third loop that runs 'j' times, where 'j'
     * is the current iteration of the second loop. Since 'j' can be up to 'i^2',
     * the third loop can run up to 'n^2' times.
     * 
     * So, the total number of iterations is 'n' (for the outer loop) times 'n^3'
     * (for the second loop) times 'n^2' (for the third loop), which equals 'n^5'.
     * Hence, the time complexity is O(n^5).
     * 
     * 
     * @param n - the number of iterations
     */
    public void fragment5(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) // O(n)
            for (int j = 0; j < i * i; j++) // O(n^2)
                for (int k = 0; k < j; k++) // O(n)
                    sum++;
        System.out.println(sum);
    }

    public void fragment5a(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) // O(n)
            for (int j = 0; j < n * n; j++) // O(n^2)
                for (int k = 0; k < n * n; k++) // O(n^2)
                    sum++;
        System.out.println(sum);
    }

    /**
     * Fragment 6
     * O(n^4)
     * The time complexity of the provided code is O(n^4).
     * 
     * 
     * To determine the time complexity of the provided code, we need to analyze the
     * nested loops and how they interact, particularly focusing on whether the `if`
     * statement affects the overall complexity.
     * 
     * ```java
     * public void fragment6(int n) {
     * int sum = 0;
     * for (int i = 1; i < n; i++) // O(n)
     * for (int j = 1; j < i * i; j++) // O(i^2)
     * if (j % i == 0)
     * for (int k = 0; k < j; k++) // O(j)
     * sum++;
     * System.out.println(sum);
     * }
     * ```
     * 
     * ### Analyzing the Loops
     * 
     * 1. **Outer Loop**: `for (int i = 1; i < n; i++)`
     * - This loop runs `n-1` times, which is \( O(n) \).
     * 
     * 2. **Middle Loop**: `for (int j = 1; j < i * i; j++)`
     * - This loop runs from `1` to `i*i - 1`. Hence, it runs \( i^2 - 1 \) times,
     * which is \( O(i^2) \).
     * 
     * 3. **If Statement**: `if (j % i == 0)`
     * - The condition `j % i == 0` checks whether `j` is a multiple of `i`. This
     * check itself is \( O(1) \), but it affects how often the inner loop executes.
     * 
     * 4. **Inner Loop**: `for (int k = 0; k < j; k++)`
     * - This loop runs from `0` to `j-1`, thus running `j` times. The number of
     * executions depends on the value of `j`.
     * 
     * ### Considering the If Statement
     * 
     * The `if` statement ensures that the inner loop only runs when `j` is a
     * multiple of `i`. For a given `i`, the multiples of `i` within the range `1`
     * to `i*i-1` are:
     * 
     * \[ i, 2i, 3i, \ldots, (i-1)i \]
     * 
     * There are `i-1` such multiples. For each multiple \( ki \) (where \( k \)
     * ranges from `1` to `i-1`), the inner loop runs \( ki \) times.
     * 
     * ### Summing the Inner Loop Executions
     * 
     * We need to sum the number of inner loop executions over all valid `j` values
     * for each `i`:
     * 
     * \[ \sum_{k=1}^{i-1} ki \]
     * 
     * This sum is an arithmetic series, which can be computed as:
     * 
     * \[ \sum_{k=1}^{i-1} ki = i \left( \sum_{k=1}^{i-1} k \right) = i \left(
     * \frac{(i-1)i}{2} \right) = \frac{i^3 - i^2}{2} \]
     * 
     * ### Total Complexity
     * 
     * Now, we sum this over all values of `i` from `1` to `n-1`:
     * 
     * \[ \sum_{i=1}^{n-1} \frac{i^3 - i^2}{2} = \frac{1}{2} \left( \sum_{i=1}^{n-1}
     * i^3 - \sum_{i=1}^{n-1} i^2 \right) \]
     * 
     * We use the formulas for the sum of cubes and squares:
     * 
     * \[ \sum_{i=1}^{n-1} i^3 = \left( \frac{(n-1)n}{2} \right)^2 \approx
     * \frac{n^4}{4} \]
     * \[ \sum_{i=1}^{n-1} i^2 \approx \frac{n^3}{3} \]
     * 
     * So, the total sum is approximately:
     * 
     * \[ \frac{1}{2} \left( \frac{n^4}{4} - \frac{n^3}{3} \right) \]
     * 
     * For large `n`, the \( n^4 \) term dominates, giving us:
     * 
     * \[ \frac{n^4}{8} \]
     * 
     * Thus, the overall time complexity is \( O(n^4) \).
     * 
     * ### Conclusion
     * 
     * The `if` statement does affect the number of times the innermost loop runs,
     * but after considering its impact, we find that the overall time complexity of
     * the code is \( O(n^4) \).
     * 
     * @param n
     */
    public void fragment6(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) // O(n)
            for (int j = 1; j < i * i; j++) // O(n^2)
                if (j % i == 0)
                    for (int k = 0; k < j; k++) // O(n^2)
                        sum++;
        System.out.println(sum);
    }

    public void fragment6a(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) // O(n)
            for (int j = 1; j < n * n; j++) // O(n^2)
                if (j % i == 0)
                    for (int k = 0; k < n * n; k++) // O(n^2)
                        sum++;
        System.out.println(sum);
    }

    // from the book "Cracking the Coding Interview" by Gayle Laakmann McDowell
    // =================

    /**
     * Example 1
     * O(n) - Linear Time - the fact that we iterate through the array twice
     * does not change the fact that the time complexity is O(n)
     * 
     * @param array - the array of integers
     */
    public void foo(int[] array) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        System.out.println(sum + ", " + product);
    }

    /**
     * Example 2
     * O(n^2) - Quadratic Time
     * 
     * @param array
     */
    public void printPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }

    /**
     * Example 3
     * O(n^2) - Quadratic Time
     * the outer loop runs n times and the inner loop runs n/2 times
     * so the time complexity is O(n^2/2) which will = O(n^2)
     * 
     * @param array
     */
    public void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }

    /**
     * Example 4
     * O(ab)
     * It is not correct to say that the time complexity is O(n^2) because the
     * two arrays are different sizes.
     * 
     * @param arrayA
     * @param arrayB
     */
    public void printUnorderedPairs2(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] < arrayB[j]) {
                    System.out.println(arrayA[i] + ", " + arrayB[j]);
                }
            }
        }
    }

    /**
     * Example 10
     * O(sqrt(n))
     * 
     * @param n - the number of iterations
     * @return true if n is prime, false otherwise
     */
    public boolean isPrime(int n) {
        for (int x = 2; x * x <= n; x++) { // O(sqrt(n))
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Example 11
     * O(n)
     * 
     * @param n
     * @return the factorial of n
     */
    public int factorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Example 12
     * Counts all permutations of a string
     * O(n^2 * n!)
     * 
     * @param str - the string to permute
     */
    public void permutation(String str) {
        permutation(str, "");
    }

    private void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    // Bari examples
    // =================================================================

    /**
     * Example 1
     * O(n) - Linear Time
     * 
     * @param n
     */
    public void example1(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum++;
        }
        System.out.println(sum);
    }

    /**
     * Example 4
     * The time complexity of the provided code is O(sqrt(n)).
     * 
     * Here's why:
     * 
     * The outer loop runs until 'p' exceeds 'n'. In each iteration of the outer
     * loop, 'p' is increased by 'i^2' (because 'p' is increased by 'i' for 'i'
     * times due
     * to the inner loop).
     * 
     * So, the outer loop runs until the sum of squares of the first 'i' natural
     * numbers exceeds 'n'. The sum of squares of the first 'i' natural numbers is
     * approximately 'i^3/3', so the loop runs until 'i^3/3 > n', which means
     * 'i > (3n)^(1/3)'.
     * 
     * However, because 'i' is squared in each iteration, the actual number of
     * iterations
     * is closer to the square root of 'n', so the time complexity is O(sqrt(n)).
     * 
     * The inner loop runs 'i' times, but this does not affect the overall time
     * complexity because it is dominated by the outer loop.
     * 
     * 
     * @param n - the number of iterations
     */
    public void example4(int n) {
        int p = 0;
        for (int i = 1; p <= n; i++) {
            for (int j = 1; j <= i; j++) {
                p = p + i;
            }
        }

    }

}
