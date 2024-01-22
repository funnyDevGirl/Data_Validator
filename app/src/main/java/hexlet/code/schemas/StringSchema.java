package hexlet.code.schemas;

import java.util.Objects;

public class StringSchema extends BaseSchema {

    /**
     * Checking the initial state of the object is specified.
     */
    public StringSchema() {
        addCondition("type",
                value -> value instanceof String || value == null);
    }

    /**
     * Makes the data mandatory.
     * Adds a constraint to the schema that prevents null or the empty string from being used as a value.
     * @return StringSchema object
     */
    public StringSchema required() {
        addCondition("required",
                //value -> !value.toString().isEmpty());
                value -> !Objects.equals(value, "") && !Objects.isNull(value));
        return this;
    }

    /**
     * Adds a minimum length constraint for a string to the schema.
     * The string must be equal to or longer than the specified number.
     * @return StringSchema object
     */
    public StringSchema minLength(int length) {
        addCondition("minLength",
                value -> ((String) value).length() >= length);
        return this;
    }

    /**
     * Adds a row content constraint to the schema.
     * The string must contain a specific substring.
     * @return StringSchema object
     */
    public StringSchema contains(String subString) {
        addCondition("subString",
                value -> ((String) value).contains(subString));
        return this;
    }
}
