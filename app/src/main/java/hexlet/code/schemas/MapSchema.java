package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {

    /**
     * Checking the initial state of the object is specified.
     */
    public MapSchema() {
        addCondition(
                "required",
                Map.class::isInstance
        );
    }

    /**
     * Adds a constraint to the schema that prevents null from being used as a value.
     * Map data type required.
     * @return MapSchema object
     */
    public MapSchema required() {
        required = true;
        return this;
    }

    /**
     * Adds a limit on the size of the dictionary.
     * The number of key-value pairs in the Map object must be equal to the specified number.
     * @param size
     * @return MapSchema object
     */
    public MapSchema sizeof(int size) {
        addCondition("size",
                value -> value.size() == size);
        return this;
    }

    /**
     *The shape() method is used to define the properties of a Map object
     * and create a schema to validate their values.
     * Each property of a Map object is assigned its own set of constraints (its own schema).
     * @param schemas
     * @return MapSchema object
     */
    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addCondition("shape",
                value -> value.entrySet().stream()
                        .allMatch((item) ->
                                (schemas.get(item.getKey()).isValid(item.getValue()))
                        )
        );
        return this;
    }
}
