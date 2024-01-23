package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    /**
     * Dictionary for collecting filters.
     */
    protected Map<String, Predicate> checks = new LinkedHashMap<>();
    protected boolean required = false;

    /**
     * The method is visible only to heirs.
     * Adding a validation rule.
     * @param checkName
     * @param condition
     */
    protected final void addCondition(String checkName, Predicate condition) {
        checks.put(checkName, condition);
    }

    /**
     * Checking for compliance with filters.
     * If the data passes through all filters, then the data is valid, if not, then it is not.
     * @param obj
     * @return boolean object
     */
    public final boolean isValid(Object obj) {
        if (!required) {
            Predicate validate = checks.get("required");
            if (!validate.test(obj)) {
                return true;
            }
        }

        for (Predicate validate : checks.values()) {
            if (!validate.test(obj)) {
                return false;
            }
        }

        return true;
    }
}

