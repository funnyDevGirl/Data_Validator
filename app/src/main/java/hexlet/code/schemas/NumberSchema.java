package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {

    /**
     * Checking the initial state of the object is specified.
     */
    public NumberSchema() {
        addCondition("type",
                //вот так у меня было:
                //value -> value instanceof Integer || value == null);
                value -> value instanceof Integer);
    }

    /**
     * Adds a constraint to the schema that prevents null from being used as a value.
     * @return NumberSchema object
     */
    public NumberSchema required() {
        addCondition("required",
                //Objects::nonNull);
                value -> value instanceof Number && ((int) value) != 0);
        return this;
    }

    /**
     * Adds a restriction on the sign of a number.
     * The number must be positive.
     * @return NumberSchema object
     */
    public NumberSchema positive() {
        addCondition("positive",
                //вот так у меня было:
                //value -> value == null || value instanceof Integer  && (int) value > 0);
                value -> (int) value > 0);
        return this;
    }

    /**
     * Adds a valid range that the number value must fall into including boundaries.
     * @param min
     * @param max
     * @return NumberSchema object
     */
    public NumberSchema range(int min, int max)  {
        addCondition("range",
                value -> ((int) value) >= min && ((int) value) <= max);
        return this;
    }
}
