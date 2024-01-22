package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        addCondition("type",
                value -> value instanceof Map || value == null);
    }

    //
    public MapSchema required() {
        addCondition("required",
                Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCondition("size",
                value -> ((Map) value).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCondition("shape",
                value ->
                    schemas.entrySet().stream().allMatch(item -> {
                        Object obj = ((Map) value).get(item.getKey());
                        return item.getValue().isValid(obj);
                    })
        );
        return this;
    }
}
