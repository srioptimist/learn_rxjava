package nl.sri.observable.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;

public class MovieControllerTest {

    @Test
    public void test() {
        AtomicReference<String> s = new AtomicReference<>();
        MovieController.main(new String[]{});
        assertTrue(MovieStatistics.result.size() == 1);
        MovieStatistics.result.keySet().iterator().forEachRemaining(year -> s.set(MovieStatistics.result.get(year).get(0).getName()));
        assertEquals("Guardians of the Galaxy" , s.get());
        MovieStatistics.result.keySet().iterator().forEachRemaining(year -> s.set(MovieStatistics.result.get(year).get(1).getName()));
        assertEquals("Interstellar" , s.get());
    }
}
