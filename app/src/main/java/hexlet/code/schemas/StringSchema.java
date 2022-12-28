package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    public final StringSchema required() {
        this.required = true;
        Predicate<Object> predicateRequired = x -> x instanceof String && !x.equals("");
        super.addPredicate(predicateRequired);
        return this;
    }

    public final StringSchema minLength(int number) {
        Predicate<Object> predicateMinLength = x -> x.toString().length() >= number;
        super.addPredicate(predicateMinLength);
        return this;
    }

    public final StringSchema contains(String str) {
        Predicate<Object> predicateContains = x -> x.toString().contains(str);
        super.addPredicate(predicateContains);
        return this;
    }

    @Override
    public boolean isInvalidData(Object obj) {
        return !(obj instanceof String) || ((String) obj).isEmpty();
    }
}
