import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

/**
 * @author Edward Yue Shung Wong
 */
public class FooTest {

    @Test
    public void shouldDoSomething() {
        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("ben", 10);
        ageMap.put("bob", 11);
        ageMap.put("alice", 5);

        BinaryOperator<Integer> binaryAddLambda
                = (x, y) -> x + y;

        Collection<Integer> ages = ageMap.values();

        Integer totalAge = ages.stream()
                .reduce(0, binaryAddLambda);
    }

}
