package assig2;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void TP1_noChildren() {
        App calc = new App();
        double result = calc.computeTax(50000, new int[] {});
        assertEquals(10000, result, 0.01);
    }

    @Test
    public void TP2_childrenAbove18() {
        App calc = new App();
        double result = calc.computeTax(50000, new int[] { 19, 22 });
        assertEquals(10000, result, 0.01);
    }

    @Test
    public void TP3_childrenUnder18() {
        App calc = new App();
        double result = calc.computeTax(50000, new int[] { 5, 10 });
        assertEquals(0, result, 0.01);
    }

    @Test
    public void TP4_mixedAges() {
        App calc = new App();
        double result = calc.computeTax(50000, new int[] { 5, 18, 17 });
        assertEquals(0, result, 0.01);
    }

    @Test
    public void TP5_highIncome() {
        App calc = new App();
        double result = calc.computeTax(120000, new int[] { 5, 10 });
        assertEquals(26000, result, 0.01);
    }
}