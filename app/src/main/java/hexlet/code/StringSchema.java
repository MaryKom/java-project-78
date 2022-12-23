package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private List<Predicate<Object>> conditions = new ArrayList<>();
    private boolean required = true;

    public StringSchema required() {
        this.required = true;
        Predicate<Object> predicateRequired = x -> x instanceof String && !x.equals("");
        conditions.add(predicateRequired);
        return this;
    }

    public StringSchema minLength(int number) {
        Predicate<Object> predicateMinLength = x -> x instanceof String && x.toString().length() >= number;
        conditions.add(predicateMinLength);
        return this;
    }

    public StringSchema contains(String str) {
        Predicate<Object> predicateContains = x -> x instanceof String && x.toString().contains(str);
        conditions.add(predicateContains);
        return this;
    }

    public boolean isValid(Object ob) {
        for (Predicate<Object> predicate: conditions) {
            if (!predicate.test(ob)) {
                return false;
            }
        }
        return true;
    }
}
