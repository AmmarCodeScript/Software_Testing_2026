package assig2;

public class App {

    public App() {
        System.out.println("Calculator2 initialized");
    }

    public double computeTax(double income, int[] childAgeList) {

        System.out.println("Computing tax....");

        double taxAmount;
        double taxExemption;
        double taxBracket;

        System.out.println("Income: " + income);

        if (income < 100000)
            taxBracket = 0.2;
        else
            taxBracket = 0.3;

        taxExemption = getTaxExemption(childAgeList);

        System.out.println("Exemption: " + taxExemption);

        taxAmount = income * taxBracket - taxExemption;

        System.out.println("To pay: " + taxAmount);

        // tax amount cannot be negative
        if (taxAmount < 0)
            taxAmount = 0.0;

        System.out.println("Final tax: " + taxAmount);

        return taxAmount;
    }

    private double getTaxExemption(int[] childAgeList) {

        double benefit = 0.0;
        int noMinorChildren = 0;

        for (int childAge : childAgeList) {

            if (childAge < 18) {
                noMinorChildren++;
                benefit += getExemptionValue(noMinorChildren);
            }
        }

        return benefit;
    }

    private double getExemptionValue(int nthchild) {

        if (nthchild <= 3)
            return 5000;
        else
            return 6000;
    }
}