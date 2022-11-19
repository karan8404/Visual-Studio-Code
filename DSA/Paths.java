class Paths {// find the number of paths to travel through an arrayfrom start to end.
    // VIDEO NUMBER #9

    static int pathsRecursive(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return pathsRecursive(m - 1, n) + pathsRecursive(m, n - 1);
    }

    public static void main(String args[]) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = i * 3 + j + 1;
            }
        }
        int m = 3;
        int n = 3;

        int count = pathsRecursive(m, n);
        System.out.println(count);
    }
}