# babai-algorithm
Babai's Nearest Plane Algorithm implementation in Java for a discrete mathematics project on lattice-based cryptography.
# Babai's Nearest Plane Algorithm in Java

This project implements Babai's Nearest Plane Algorithm in Java. The algorithm approximates the closest lattice vector to a given target vector, making it a useful tool for studying lattice-based cryptography.

## Project Context
This code is part of a discrete mathematics project focused on lattice-based cryptography. Lattice-based cryptography is a promising area in post-quantum cryptography due to its resistance to quantum computer attacks.

## How to Run
1. Compile the code using any Java IDE or from the terminal:
   ```bash
   javac BabaiApproximation.java
2. Run the program:
   java BabaiApproximation
3. Provide the required inputs for the lattice basis and target vector.
   Example inputs:
   Enter the number of rows (m) and columns (n) for lattice basis (separated by space): 2 2
   Enter the lattice basis rows:
   1 0
   0 1
   Enter the target vector:
   2.7 3.8
   Example output:
   Closest Lattice Vector: 3.00 4.00

