package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addCondition("type",
                value -> value instanceof Integer || value == null);
    }

    //добавляется проверка на null:
    public NumberSchema required() {
        addCondition("required",
                Objects::nonNull);
        return this;
    }

    //добавляется проверка на положительность числа:
    //число положительно, если равно null или больше нуля,
    //(при условии, что ещё не применялся required())
    public NumberSchema positive() {
        addCondition("positive",
                value -> value == null || value instanceof Integer  && (int) value > 0);
        return this;
    }

    //добавляется проверка на вхождение в диапазон:
    public NumberSchema range(int begin, int end)  {
        addCondition("range",
                value -> ((int) value) >= begin && ((int) value) <= end);
        return this;
    }
}
