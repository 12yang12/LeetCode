package backtracking;

import java.util.*;

public class LC332 {

    private Deque<String> result;
    private Map<String, Map<String, Integer>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        result = new LinkedList<>();
        result.add("JFK");

        for (List<String> ticket : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(ticket.get(0))) {
                temp = map.get(ticket.get(0));
                temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                // 升序Map
                temp = new TreeMap<>();
                temp.put(ticket.get(1), 1);
            }
            map.put(ticket.get(0), temp);
        }

        backtracking(tickets.size());

        return new ArrayList<>(result);
    }

    private boolean backtracking(int ticketNum) {
        if (result.size() == ticketNum + 1) {
            return true;
        }

        String last = result.getLast();
        // 防止出现null
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> entry : map.get(last).entrySet()) {
                int count = entry.getValue();
                if (count > 0) {
                    result.add(entry.getKey());
                    entry.setValue(count - 1);
                    if (backtracking(ticketNum)) {
                        return true;
                    }
                    result.removeLast();
                    entry.setValue(count);
                }
            }
        }

        return false;
    }
}
