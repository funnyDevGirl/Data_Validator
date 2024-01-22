package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {

    /**
     * Dictionary for collecting filters.
     */
    private final Map<String, Predicate<Object>> conditions;

    /**
     * The method is visible only to heirs.
     * Initializing a new schema object.
     */
    protected BaseSchema() {
        this.conditions = new HashMap<>();
    }

    /**
     * The method is visible only to heirs.
     * Adding a validation rule.
     */
    protected void addCondition(String checkName, Predicate<Object> condition) {
        conditions.put(checkName, condition);
    }

    /**
     * Checking for compliance with filters.
     * If the data passes through all filters, then the data is valid, if not, then it is not.
     * @return boolean object
     */
    public boolean isValid(Object obj) {
        return conditions.values().stream().allMatch(condition -> condition.test(obj));
    }
}
