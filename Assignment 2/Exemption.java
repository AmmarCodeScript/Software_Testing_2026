package assigs2025.assig2;

public class Exemption {
    public double getExemptionValue(int nthchild){
       /*
       decides value to use according to no children
       up to three children, each gets 5000 exemption
       additional children get 5000 exemption each
       @Param children number of children for which to calculate the exemption
        */
        int value;

        if (nthchild <= 3)
            value = 5000;
        else
            value = 6000;

        return value;
    }
}