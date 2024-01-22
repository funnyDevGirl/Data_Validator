package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    /**
     * Creating StringSchema object to handle dictionaries.
     * @return a new StringSchema object
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Creating NumberSchema object to handle dictionaries.
     * @return a new NumberSchema object
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Creating MapSchema object to handle dictionaries.
     * @return a new MapSchema object
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
