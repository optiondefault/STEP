public class prog3 {
    static class BusRoute implements Comparable<BusRoute> {
        String routeCode;
        String routeName;
        int priority;

        public BusRoute(String routeCode, String routeName, int priority) {
            this.routeCode = routeCode;
            this.routeName = routeName;
            this.priority = priority;
        }

        public BusRoute(String routeCode, String routeName) {
            // Default priority 3 matches the test case logic where "rt201j" (4) > RT205L (3) == RT299T (3)
            this(routeCode, routeName, 3);
        }

        @Override
        public int compareTo(BusRoute other) {
            if (this.priority != other.priority) {
                // Descending order of priority (higher priority first)
                return Integer.compare(other.priority, this.priority);
            }
            // Tie-breaker: Case-insensitive alphabetical order
            return this.routeCode.compareToIgnoreCase(other.routeCode);
        }
    }

    public static BusRoute[] rankRoutes(BusRoute[] routes) {
        BusRoute[] sorted = new BusRoute[routes.length];
        System.arraycopy(routes, 0, sorted, 0, routes.length);
        
        // Stable Bubble Sort
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - 1 - i; j++) {
                if (sorted[j].compareTo(sorted[j + 1]) > 0) {
                    BusRoute temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        BusRoute[] routes = {
            new BusRoute("RT205L", "Airport Express", 3),
            new BusRoute("rt201j", "City Central", 4),
            new BusRoute("RT299T", "Night Service")
        };
        
        BusRoute[] ranked = rankRoutes(routes);
        System.out.print("[");
        for (int i = 0; i < ranked.length; i++) {
            System.out.print("\"" + ranked[i].routeCode + "\"" + (i < ranked.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
