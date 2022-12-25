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
        Predicate<Object> predicateSizeOf = x -> x instanceof Map && ((Map<?, ?>) x).size() == size;
        super.addPredicate(predicateSizeOf);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> predicateShape = x -> x instanceof Map && formValidation(schemas, (Map<?, ?>) x);
        super.addPredicate(predicateShape);
        return this;
    }

    private boolean formValidation(Map<String, BaseSchema> schemas, Map<?, ?> map) {
        for (Map.Entry<String, BaseSchema> entry: schemas.entrySet()) {
            String key = entry.getKey();
            if (map.containsKey(key) && !entry.getValue().isValid(map.get(key))) {
                return false;
            }
        }
        return true;
    }
}
