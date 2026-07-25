package org.Aditya.graph.euclerianPath;

import java.util.*;

public class L332 {

    Map<String, PriorityQueue<String>> mp;

    private void dfs(String node, List<String> route){

        while(mp.get(node)!=null && !mp.get(node).isEmpty()){

            dfs(mp.get(node).poll(), route);

        }


        route.add(0, node);
    }


    public List<String> findItinerary(List<List<String>> tickets) {

        int n = tickets.size();

        mp = new HashMap<>();

        for(int i=0;i<n;i++){

            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);

            mp.computeIfAbsent(from, k-> new PriorityQueue<>()).add(to);

        }

        List<String> route = new ArrayList<>();
        dfs("JFK", route);
        return route;

    }
}
