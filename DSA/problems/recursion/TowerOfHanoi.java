package recursion;

public class TowerOfHanoi {
    public static void solve(int n, char fromRod, char auxRod, char toRod) {
        if (n == 1) {
            System.out.printf("Move rod %d from %c to %c.\n", n, fromRod, toRod);
            return;
        } else {
            solve(n - 1, fromRod, toRod, auxRod);
            System.out.printf("Move rod %d from %c to %c.\n", n, fromRod, toRod);
            solve(n - 1, auxRod, fromRod, toRod);
        }
    }

    public static void main(String[] args) {
        int disks = 3;

        solve(disks, 'A', 'B', 'C');
    }
}
