# Integration Testing – Tax Calculation

## Overview

This assignment focuses on **integration testing** of two methods in the `App` class:

* `computeTax(double income, int[] childAgeList)`
* `getTaxExemption(int[] childAgeList)`

The goal is to verify that data flows correctly between these methods and produces the correct tax result.

---

## Implementation Summary

### Method Responsibilities

* **computeTax**

  * Determines tax rate based on income
  * Calls `getTaxExemption`
  * Ensures tax is not negative

* **getTaxExemption**

  * Iterates through children
  * Counts minor children (age < 18)
  * Calls `getExemptionValue(int nthChild)` for each child

* **getExemptionValue**

  * Implemented in `AppTest` (due to given structure)
  * Returns:

    * 5000 for first three children
    * 6000 for additional children

---

## Control Flow Graph (CFG)

Two CFGs were created:

* One for `computeTax` (branching on income and negative tax check)
* One for `getTaxExemption` (loop + condition for minor children)

---

## Coupling and Data Flow

Two types of coupling were tested:

* **Direct Call Coupling**

  * `childAgeList` passed from `computeTax` → `getTaxExemption`

* **Return Coupling**

  * `benefit` returned from `getTaxExemption` → used in `computeTax`

Definitions (defs) and uses were identified to ensure proper data flow coverage.

---

## Test Coverage

### All-Coupling-Defs Coverage

* Ensures all parameter definitions reach their uses across method calls

### All-Coupling-Uses Coverage

* Ensures all returned values are used in different execution paths

---

## Test Cases

| Test Path | Description       |
| --------- | ----------------- |
| TP1       | No children       |
| TP2       | Children above 18 |
| TP3       | Children under 18 |
| TP4       | Mixed ages        |
| TP5       | High income       |

Each test verifies correct integration behavior and ensures tax is calculated properly.

---

## Key Challenges

* `App` depends on `AppTest`, which is not ideal design
* Required ensuring `getExemptionValue` is accessible for integration
* Handling cumulative exemption logic correctly

---

## Conclusion

The integration between methods was successfully tested by:

* Covering all control flow paths
* Verifying data flow between methods
* Implementing JUnit tests for each scenario

The system correctly computes tax across all tested cases.
--------------------------
Method 1: computeTax
CFG :
Start
  ↓
income < 100000 ?
  ├─ yes → taxBracket = 0.2
  └─ no  → taxBracket = 0.3
       ↓
taxExemption = getTaxExemption(childAgeList)
       ↓
taxAmount = income * taxBracket - taxExemption
       ↓
taxAmount < 0 ?
  ├─ yes → taxAmount = 0
  └─ no  → (skip)
       ↓
return taxAmount
-------------------------------
Method 2: getTaxExemption
Start
  ↓
benefit = 0
noMinorChildren = 0
  ↓
for each childAge
  ↓
childAge < 18 ?
  ├─ yes:
  │     noMinorChildren++
  │     benefit += getExemptionValue(noMinorChildren)
  └─ no:
        skip
  ↓
(loop until done)
  ↓
return benefit
-------------------------------