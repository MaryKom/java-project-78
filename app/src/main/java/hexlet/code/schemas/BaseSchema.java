package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private List<Predicate<Object>> conditions = new ArrayList<>();
    protected boolean required;

    public final void addPredicate(Predicate<Object> predicate) {
        conditions.add(predicate);
    }

    public final boolean isValid(Object ob) {
        if (!required && isInvalidData(ob)) {
            return true;
        }
        for (Predicate<Object> predicate: conditions) {
            if (!predicate.test(ob)) {
                return false;
            }
        }
        return true;
    }

    abstract boolean isInvalidData(Object value);
}
