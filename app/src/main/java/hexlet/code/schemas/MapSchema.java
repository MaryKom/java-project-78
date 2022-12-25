package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        Predicate<Object> predicateRequired = x -> x instanceof Map;
        super.addPredicate(predicateRequired);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Object> predicateSizeof = x -> x instanceof Map && ((Map<?, ?>) x).size() == size;
        super.addPredicate(predicateSizeof);
        return this;
    }
}
