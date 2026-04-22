import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/*
 ============================================================================
 Task 1 – Integration tests for:
   - computeTax(double income, int[] childAgeList)
   - getTaxExemption(int[] childAgeList)
 ============================================================================
*/

public class Task_1 {

    /*
     * ========================================================================
     * P1: No children
     * Covers:
     * - Direct call with empty list
     * - Return coupling: exemption = 0
     * ========================================================================
     */
    @Test
    void test_P1_noChildren() {
        TaxCalculator2 calc = new TaxCalculator2();

        double income = 100000;
        int[] children = {};

        double result = calc.computeTax(income, children);

        assertEquals(30000.0, result);
    }

    /*
     * ========================================================================
     * P2: Only adult children
     * Covers:
     * - childAgeList passed but no minor children
     * - exemption remains 0
     * ========================================================================
     */
    @Test
    void test_P2_onlyAdultChildren() {
        TaxCalculator2 calc = new TaxCalculator2();

        double income = 100000;
        int[] children = { 19, 22 };

        double result = calc.computeTax(income, children);

        assertEquals(30000.0, result);
    }

    /*
     * ========================================================================
     * P3: One minor child
     * Covers:
     * - return coupling with exemption = 5000
     * ========================================================================
     */
    @Test
    void test_P3_oneMinorChild() {
        TaxCalculator2 calc = new TaxCalculator2();

        double income = 100000;
        int[] children = { 10 };

        double result = calc.computeTax(income, children);

        assertEquals(25000.0, result);
    }

    /*
     * ========================================================================
     * P4: Multiple minor children (3)
     * Covers:
     * - multiple uses of call parameter inside loop
     * - accumulation of exemption
     * ========================================================================
     */
    @Test
    void test_P4_multipleMinorChildren() {
        TaxCalculator2 calc = new TaxCalculator2();

        double income = 100000;
        int[] children = { 6, 9, 15 };

        double result = calc.computeTax(income, children);

        assertEquals(15000.0, result);
    }
}