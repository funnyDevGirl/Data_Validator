package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    /**
     * Dictionary for collecting filters.
     */
    protected Map<String, Predicate<T>> conditions = new LinkedHashMap<>();
    protected boolean required = false;

    /**
     * The method is visible only to heirs.
     * Adding a validation rule.
     * @param checkName
     * @param condition
     */
    protected final void addCondition(String checkName, Predicate<T> condition) {
        conditions.put(checkName, condition);
    }

    /**
     * Checking for compliance with filters.
     * If the data passes through all filters, then the data is valid, if not, then it is not.
     * @param obj
     * @return boolean object
     */
    public final boolean isValid(T obj) {
        //если не вызывался required(), то мы проверяем соответствие
        if (!required) {
            Predicate<T> validate = conditions.get("required");
            if (!validate.test(obj)) {
                return true;
            }
        }
        //будет true, если obj соответствует всем предикатам validate,
        //если хоть один НЕ соотв-ет, то false
        for (Predicate<T> validate : conditions.values()) {
            if (!validate.test(obj)) {
                return false;
            }
        }
        return true;
    }
}
