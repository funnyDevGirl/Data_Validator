package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {

    /**
     * Checking the initial state of the object is specified.
     */
    public NumberSchema() {
        addCondition("type",
                value -> value instanceof Integer || value == null);
    }

    /**
     * Adds a constraint to the schema that prevents null from being used as a value.
     * @return NumberSchema object
     */
    public NumberSchema required() {
        addCondition("required",
                Objects::nonNull);
        return this;
    }

    /**
     * Adds a restriction on the sign of a number.
     * The number must be positive.
     * @return NumberSchema object
     */
    public NumberSchema positive() {
        addCondition("positive",
                value -> value == null || value instanceof Integer  && (int) value > 0);
        return this;
    }

    /**
     * Adds a valid range that the number value must fall into including boundaries.
     * @param begin
     * @param end
     * @return NumberSchema object
     */
    public NumberSchema range(int begin, int end)  {
        addCondition("range",
                value -> ((int) value) >= begin && ((int) value) <= end);
        return this;
    }
}
