package au.pexa.hack.daeve.service;

import au.pexa.hack.daeve.model.UserNavigationData;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by cariyaratna on 17/3/17.
 */
public class UserActionSuggestionsServiceTest {

    private UserActionSuggestionsService userActionSuggestionsService = new UserActionSuggestionsService();

    @Test
    public void shouldSplitCorrectUrl(){
        String url = "http://localhost:8080/test/anotherPath?someParam=paramValue";
        String url2 = "/filterdashboard.html";

        String val = userActionSuggestionsService.getLastAccessedPage(url);

        String val2 = userActionSuggestionsService.getLastAccessedPage(url2);

        Assertions.assertThat(val).isEqualTo("anotherPath");
        Assertions.assertThat(val2).isEqualTo("filterdashboard.html");
    }

    @Test
    public void shouldSortResults() throws InterruptedException {

        UserNavigationData userNavigationData = new UserNavigationData();
        userNavigationData.setUsername("first");
        userNavigationData.setTimestamp(LocalDateTime.now());

        Thread.sleep(3);

        UserNavigationData userNavigationData1 = new UserNavigationData();
        userNavigationData1.setUsername("second");
        userNavigationData1.setTimestamp(LocalDateTime.now());

        Thread.sleep(3);

        UserNavigationData userNavigationData2 = new UserNavigationData();
        userNavigationData2.setUsername("third");
        userNavigationData2.setTimestamp(LocalDateTime.now());

        Thread.sleep(3);

        UserNavigationData userNavigationData3 = new UserNavigationData();
        userNavigationData3.setUsername("fourth");
        userNavigationData3.setTimestamp(LocalDateTime.now());

        Thread.sleep(3);


        List<UserNavigationData> values = userActionSuggestionsService.sortData(Arrays.asList(userNavigationData3, userNavigationData2, userNavigationData1, userNavigationData));
        Optional<UserNavigationData> last = values.stream().reduce((f, s) -> s);
        Assertions.assertThat(last.get().getUsername()).isEqualTo("fourth");


    }

    @Test
    public void shouldSplitCorrectSystem(){
        String url = "/system/anotherPath?someParam=paramValue";

        String val = userActionSuggestionsService.getLastAccessedSystem(url);

        Assertions.assertThat(val).isEqualTo("system");
    }
}
