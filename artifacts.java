import java.util.*;
import java.io.*;

public class artifacts {
    public static void main(String[] args) {
        /*
        Simulate artifacts as they are generated.
        Upon generating an artifact, find all the existing artifacts it intersects
        replace all of them including the one that was generated based on their average position and sum of areas.
         */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            ArrayList<artifact> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                double x = scan.nextInt();
                double y = scan.nextInt();
                double r = scan.nextInt();
                artifact added = new artifact(x, y, r);
                // Artifact was generated
                list.add(added);
                while (true) {
                    // Maintain the sum of positions and total area such that we can formulate a new artifact
                    // with the appropriate characteristics when all intersections are found
                    artifact rn = list.get(list.size()-1);
                    double sumx = rn.x, sumy = rn.y, sumArea = rn.r * rn.r * Math.PI;
                    double count = 1;

                    // Stores the artifacts that were intersected with, these will all be replaced by a single artifact
                    HashSet<artifact> removeThese = new HashSet<>();
                    for (artifact in : list) {
                        if (in.equals(added)) continue;
                        // Current artifact intersects the generated artifact
                        // Add its values to the sum of positions and area, and to the list ensuring its removal
                        if (in.overLap(added)) {
                            sumx += in.x;
                            sumy += in.y;
                            sumArea += in.r * in.r * Math.PI;
                            count++;
                            removeThese.add(in);
                            removeThese.add(added);
                        }
                    }
                    // No intersections were found.
                    if (removeThese.size() == 0) break;

                    // At least one intersection was found, all artifacts that intersected are replaced by one
                    added = new artifact(sumx / count, sumy / count, Math.sqrt(sumArea / Math.PI));
                    list.add(added);
                    for (artifact in : removeThese) {
                        list.remove(in);
                    }
                }
            }
            System.out.println(list.size());
        }
    }

    static class artifact {
        double x, y, r;

        public artifact(double x, double y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        // Function checks if the current artifact intersects with a given artifact
        boolean overLap(artifact in) {
            double dist = Math.sqrt((in.x - x) * (in.x - x) + (in.y - y) * (in.y - y));
            double sumR = r + in.r;
            return (sumR + 1e-5) >= dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            artifact artifact = (artifact) o;
            return Double.compare(artifact.x, x) == 0 &&
                    Double.compare(artifact.y, y) == 0 &&
                    Double.compare(artifact.r, r) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, r);
        }
    }
}
