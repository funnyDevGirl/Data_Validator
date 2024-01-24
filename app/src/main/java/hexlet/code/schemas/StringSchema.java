package hexlet.code.schemas;


public class StringSchema extends BaseSchema {

    /**
     * Checking the initial state of the object is specified.
     */
    public StringSchema() {
        addCondition(
            "required",
            value -> value instanceof String && !((String) value).isEmpty()
        );
        ;
    }

    /**
     * Makes the data mandatory.
     * Adds a constraint to the schema that prevents null or the empty string from being used as a value.
     * @return StringSchema object
     */
    public StringSchema required() {
        required = true;
        return this;
    }


    /**
     * Adds a minimum length constraint for a string to the schema.
     * The string must be equal to or longer than the specified number.
     * @param length
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
     * @param subString
     * @return StringSchema object
     */
    public StringSchema contains(String subString) {
        addCondition("subString",
                value -> ((String) value).contains(subString));
        return this;
    }
}
