package au.pexa.hack.daeve.util;

import au.pexa.hack.daeve.model.UserNavigationData;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by arathnayake on 17/3/17.
 */
public class SuggestNextActionTest {

    SuggestNextAction suggestNextAction = new SuggestNextAction();

    private List<UserNavigationData> userNavigationDatas;

    @Before
    public void beforeEachTest() {
        userNavigationDatas = createListData();
    }

    @Test
    public void shouldGetUserGoals() {

        Map<String, Integer> suggestions = suggestNextAction.getUserGoals((ArrayList<UserNavigationData>) userNavigationDatas);

        for (Map.Entry<String, Integer> entry : suggestions.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }



    private List<UserNavigationData> createListData() {
        List lst = new ArrayList();
        for(int i=0 ; i < 10 ; i++)
        {
            lst.add(getUserNavigationData("settlement" + i));
            lst.add(getUserNavigationData("signing"));
            lst.add(getUserNavigationData("transfer"));
        }
        lst.add(getUserNavigationData("transfer"));
        return lst;
    }

    private UserNavigationData getUserNavigationData(String goal) {
        UserNavigationData userNavigationData = new UserNavigationData();
        userNavigationData.setSessionId("my-session-id");
        userNavigationData.setSubscriberType("Representative");
        userNavigationData.setUsername("user@user.com");
        userNavigationData.setUrlPattern("http//localhost:8080/test/data");
        userNavigationData.setGoal(goal);
        userNavigationData.setWorkspaceId("PEX12345");
        userNavigationData.setTimestamp(LocalDateTime.now());
        return userNavigationData;
    }


}