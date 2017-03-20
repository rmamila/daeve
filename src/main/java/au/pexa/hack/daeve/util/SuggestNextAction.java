package au.pexa.hack.daeve.util;

import au.pexa.hack.daeve.model.UserNavigationData;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by arathnayake on 17/3/17.
 */
@Component
public class SuggestNextAction {

    public Map<String, Integer> getUserGoals(List<UserNavigationData> userActionHistory) {

        Map<String, Integer> actionSet = new HashMap<>();

        Iterator i = userActionHistory.iterator();
        while (i.hasNext())
        {
            UserNavigationData userAction = (UserNavigationData) i.next();
            System.out.println(userAction);

            if (actionSet.containsKey(userAction.getGoal())){
                actionSet.put(userAction.getGoal(), actionSet.get(userAction.getGoal()) + 1);
            } else {
                actionSet.put(userAction.getGoal(), 1);
            }
        }

//        Map<String, Integer> result = userActionHistory.stream().collect(
//                Collectors.groupingBy(
//                        UserNavigationData::getGoal, Collectors.counting()
//                )
//        );


        return sortByValue(actionSet);
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}
