
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;

import org.junit.Test;

public class AppTest {

    // DENNA MÅSTE FINNAS (används av App.java)
    public double getExemptionValue(int nthchild) {
        int value;

        if (nthchild <= 3)
            value = 5000;
        else
            value = 6000;

        return value;
    }

    @Test
    public void TP1_noChildren() {
        App calc = new App();
        double result = calc.computeTax(50000, new int[] {});
        assertTrue(result >= 0);
    }

    @Test
    public void TP2_childrenAbove18() {
        App calc = new App();
        double result = calc.computeTax(50000, new int[] { 19, 22 });
        assertTrue(result >= 0);
    }

    @Test
    public void TP3_childrenUnder18() {
        App calc = new App();
        double result = calc.computeTax(50000, new int[] { 5, 10 });
        assertTrue(result >= 0);
    }

    @Test
    public void TP4_mixedAges() {
        App calc = new App();
        double result = calc.computeTax(50000, new int[] { 5, 18, 17 });
        assertTrue(result >= 0);
    }

    @Test
    public void TP5_highIncome() {
        App calc = new App();
        double result = calc.computeTax(120000, new int[] { 5, 10 });
        assertTrue(result >= 0);
    }

}
