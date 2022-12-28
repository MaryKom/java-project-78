package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public final MapSchema required() {
        this.required = true;
        Predicate<Object> predicateRequired = x -> x instanceof Map;
        super.addPredicate(predicateRequired);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Object> predicateSizeOf = x -> ((Map<?, ?>) x).size() == size;
        super.addPredicate(predicateSizeOf);
        return this;
    }

    @Override
    public boolean isInvalidData(Object obj) {
        return !(obj instanceof Map) || ((Map) obj).isEmpty();
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> predicateShape = x -> formValidation(schemas, (Map<?, ?>) x);
        super.addPredicate(predicateShape);
        return this;
    }

    private boolean formValidation(Map<String, BaseSchema> schemas, Map<?, ?> map) {
        for (Map.Entry<String, BaseSchema> entry: schemas.entrySet()) {
            String key = entry.getKey();
            if (!map.containsKey(key) || !entry.getValue().isValid(map.get(key))) {
                return false;
            }
        }
        return true;
    }
}
