import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) { this.x = x; this.y = y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Key {
    int x, y, slope;
    Key(int x, int y, int slope) {
        this.x = x;
        this.y = y;
        this.slope = slope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key k = (Key) o;
        return x == k.x && y == k.y && slope == k.slope;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, slope);
    }
}

public class GravityGlide {
    static Map<Point, List<Integer>> grid = new HashMap<>();
    static Map<Key, Point> nextPoint = new HashMap<>();

    static Point findBelow(int x, int y) {
        for (int yy = y - 1; yy >= 0; yy--) {
            Point p = new Point(x, yy);
            if (grid.containsKey(p))
                return p;
        }
        return new Point(x, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of slopes
        int[][] slope = new int[n][4];
        for (int i = 0; i < n; i++) {
            slope[i][0] = sc.nextInt();
            slope[i][1] = sc.nextInt();
            slope[i][2] = sc.nextInt();
            slope[i][3] = sc.nextInt();
        }

        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int energy = sc.nextInt();

        for (int s = 0; s < n; s++) {
            int x1 = slope[s][0], y1 = slope[s][1];
            int x2 = slope[s][2], y2 = slope[s][3];

            int dx = (x2 > x1) ? 1 : -1;
            int dy = (y2 > y1) ? 1 : -1;
            int length = Math.abs(x2 - x1);

            if (dy == -1) {
                for (int k = 0; k < length; k++) {
                    int x = x1 + dx * k;
                    int y = y1 - k;
                    Point p = new Point(x, y);
                    grid.computeIfAbsent(p, z -> new ArrayList<>()).add(s);
                    nextPoint.put(new Key(x, y, s), new Point(x + dx, y - 1));
                }
                grid.computeIfAbsent(new Point(x2, y2), z -> new ArrayList<>()).add(s);
            } else {
                for (int k = 0; k < length; k++) {
                    int x = x2 - dx * k;
                    int y = y2 - k;
                    Point p = new Point(x, y);
                    grid.computeIfAbsent(p, z -> new ArrayList<>()).add(s);
                    nextPoint.put(new Key(x, y, s), new Point(x - dx, y - 1));
                }
                grid.computeIfAbsent(new Point(x1, y1), z -> new ArrayList<>()).add(s);
            }
        }

        int x = startX, y = startY;

        if (!grid.containsKey(new Point(x, y))) {
            Point p = findBelow(x, y);
            x = p.x;
            y = p.y;
        }

        while (true) {
            if (y == 0) break;

            Point cur = new Point(x, y);
            if (!grid.containsKey(cur)) {
                Point p = findBelow(x, y);
                x = p.x;
                y = p.y;
                continue;
            }

            List<Integer> ids = grid.get(cur);

            if (ids.size() == 1) {
                int s = ids.get(0);
                Key k = new Key(x, y, s);

                if (!nextPoint.containsKey(k)) {
                    Point p = findBelow(x, y);
                    x = p.x;
                    y = p.y;
                    continue;
                }

                if (energy == 0) break;
                energy--;

                Point nxt = nextPoint.get(k);
                x = nxt.x;
                y = nxt.y;
            } else {
                long cost = 1L * x * y;
                List<Point> downs = new ArrayList<>();

                for (int s : ids) {
                    Key k = new Key(x, y, s);
                    if (nextPoint.containsKey(k))
                        downs.add(nextPoint.get(k));
                }

                if (energy <= cost) {
                    if (downs.isEmpty()) {
                        Point p = findBelow(x, y);
                        x = p.x;
                        y = p.y;
                        continue;
                    }
                    break;
                }

                energy -= cost;

                if (downs.isEmpty()) {
                    Point p = findBelow(x, y);
                    x = p.x;
                    y = p.y;
                    continue;
                }

                int bestX = 0, bestY = -1;
                for (Point d : downs) {
                    if (d.y > bestY) {
                        bestY = d.y;
                        bestX = d.x;
                    }
                }

                if (energy == 0) break;
                energy--;

                x = bestX;
                y = bestY;
            }
        }

        System.out.println(x + " " + y);
        sc.close();
    }
}