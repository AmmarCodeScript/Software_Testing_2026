package assigs2025.assig2;

public class TaxCalculator2 {

    Exemption ex;

    TaxCalculator2(){
        System.out.println("Calculator2 initialized");
        ex = new Exemption();
    }

    public double computeTax(double income, int[] childAgeList){

        System.out.println("Computing tax....");
        double taxAmount;
        double taxExemption;
        double taxBracket;

        System.out.println("Income: " + income);

        if (income < 100000)
            taxBracket = 0.2;
        else
            taxBracket = 0.3;

        taxExemption = this.getTaxExemption(childAgeList);

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
        // calculates child benefit
        double benefit = 0.0;
        int noMinorChildren = 0;

        for (int childAge: childAgeList) {
            // tax exemption is given only for minor children

            if (childAge < 18) {
                noMinorChildren++;
                benefit += this.ex.getExemptionValue(noMinorChildren);
            }
        }
        return benefit;
    }

}
