class Soil {
    private int[] particles;
    private int n;
    private UnionFind uf;


    Soil(int[] particles, int n) {
        this.particles = particles;
        this.n = n;
        uf = new WeightedQuickUnionWithPathCompression(n*n);
        performUnions();
    }

    private void performUnions() {
        // i*n will represent the row
        for(int i = 0; i < n; i++) {

            // j will represent the column
            for(int j = 0; j < n; j++) {

                // if the array[column + row] contains a 1, continue
                if(particles[i*n+j] == 1) {

                    // checking the node directly to the right.
                    if(j < n-1 && i*n+j+1 < n*n && particles[i*n+j+1] == 1) {
                        uf.union(i*n+j+1, i*n+j);
                    }

                    // checking the node directly below
                    if(i < n-1 && particles[(i+1)*n+j] == 1) {
                        uf.union(i*n+j, (i+1)*n+j);
                    }
                }
            }
        }
    }

    // checking for a path
    // i will represent the first row
    // j will represent the last row
    boolean doesDrain() {
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= n; j++) {
                if(uf.find(i, n*n-j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
