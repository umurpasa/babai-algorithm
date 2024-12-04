import java.util.Scanner;

public class BabaiApproximation {

    public static double[][] gramSchmidt(double[][] latticeBase) {
        int m = latticeBase.length;
        int n = latticeBase[0].length;
        double[][] orthogonalBasis = new double[m][n];
        double[][] mu = new double[m][m];

        for (int i = 0; i < m; i++) {
            System.arraycopy(latticeBase[i], 0, orthogonalBasis[i], 0, n);
            for (int j = 0; j < i; j++) {
                double dotProduct = dotProduct(latticeBase[i], orthogonalBasis[j]);
                double normSquared = dotProduct(orthogonalBasis[j], orthogonalBasis[j]);
                mu[i][j] = dotProduct / normSquared;

                for (int k = 0; k < n; k++) {
                    orthogonalBasis[i][k] -= mu[i][j] * orthogonalBasis[j][k];
                }
            }
        }
        return orthogonalBasis;
    }

    public static double[] solveForClosestVector(double[][] orthogonalBasis, double[] target) {
        int n = orthogonalBasis.length;
        double[] v = new double[n];
        for (int i = 0; i < n; i++) {
            v[i] = dotProduct(target, orthogonalBasis[i]) / dotProduct(orthogonalBasis[i], orthogonalBasis[i]);
        }
        return v;
    }

    public static int[] roundVector(double[] vector) {
        int[] rounded = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            rounded[i] = (int) Math.round(vector[i]);
        }
        return rounded;
    }

    public static double[] reconstructClosestVector(double[][] latticeBase, int[] rounded) {
        int m = latticeBase.length;
        int n = latticeBase[0].length;
        double[] closestVector = new double[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                closestVector[j] += rounded[i] * latticeBase[i][j];
            }
        }
        return closestVector;
    }

    public static double dotProduct(double[] a, double[] b) {
        double result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows (m) and columns (n) for lattice basis (separated by space): ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        double[][] latticeBase = new double[m][n];
        System.out.println("Enter the lattice basis rows:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                latticeBase[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Enter the target vector:");
        double[] target = new double[n];
        for (int i = 0; i < n; i++) {
            target[i] = scanner.nextDouble();
        }

        // Step 1: Gram-Schmidt orthogonalization
        double[][] orthogonalBasis = gramSchmidt(latticeBase);

        // Step 2: Solve for the closest vector in the lattice
        double[] v = solveForClosestVector(orthogonalBasis, target);

        // Step 3: Round the coordinates
        int[] rounded = roundVector(v);

        // Step 4: Reconstruct the closest lattice vector
        double[] closestVector = reconstructClosestVector(latticeBase, rounded);

        System.out.print("Closest Lattice Vector: ");
        for (double value : closestVector) {
            System.out.printf("%.2f ", value);
        }
    }
}
