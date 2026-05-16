Task 2 – Mutation Testing using PIT
Target Classes
The mutation testing was performed on the following target class:

assig2.App (corresponding to TaxCalculator2)

The logic for tax exemption (Exemption) is implemented within the same class.

Mutation Score
Mutation testing was executed using PIT. The results are:

Generated Mutants: 14
Killed Mutants: 7
Survived Mutants: 6
Mutation Score: 50%

Additionally:

Line Coverage: 92% (24/26 lines)
Test Strength: 54%

A screenshot of the PIT report has been included in the assignment report.

Applied Mutators
The following mutators were applied:

PRIMITIVE_RETURNS
VOID_METHOD_CALLS
CONSTRUCTOR_CALLS


Tests That Did Not Kill Mutants
The following test cases did not kill all mutants:


TP1_noChildren
Input: income = 50000, children = {}
Expected output: 10000


TP2_childrenAbove18
Input: income = 50000, children = {19, 22}
Expected output: 10000


TP3_childrenUnder18
Input: income = 50000, children = {5, 10}
Expected output: 0


TP4_mixedAges
Input: income = 50000, children = {5, 18, 17}
Expected output: 0


TP5_highIncome
Input: income = 120000, children = {5, 10}
Expected output: 26000



Analysis
The mutation score of 50% indicates that the test suite is only moderately effective.
Most surviving mutants were produced by the VOID_METHOD_CALLS mutator. This means that removing certain method calls did not cause tests to fail.
This indicates that the tests focus primarily on verifying final output rather than internal computations. As a result, some faults are not detected even when important logic is removed.

Conclusion
Mutation testing shows that:

The test suite achieves high line coverage (92%)
However, mutation coverage is moderate (50%)
Several faults remain undetected

To improve the mutation score, additional tests should be added that verify internal logic and intermediate calculations, not only final outputs.