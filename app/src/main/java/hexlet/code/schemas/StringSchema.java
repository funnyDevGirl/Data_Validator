package hexlet.code.schemas;

import java.util.Objects;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        addCondition("type",
                value -> value instanceof String || value == null);
    }

    //добавляется проверка на null:
    public StringSchema required() {
        addCondition("required",
                //value -> !value.toString().isEmpty());
                value -> !Objects.equals(value, "") && !Objects.isNull(value));
        return this;
    }

    //добавляется проверка на min длину:
    public StringSchema minLength(int length) {
        addCondition("minLength",
                value -> ((String) value).length() >= length);
        return this;
    }

    //добавляется проверка наличие подстроки в строке:
    public StringSchema contains(String subString) {
        addCondition("subString",
                value -> ((String) value).contains(subString));
        return this;
    }


}
