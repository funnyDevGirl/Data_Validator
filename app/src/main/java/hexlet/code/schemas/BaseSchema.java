package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {

    //словарь для накопления фильтров:
    private final Map<String, Predicate<Object>> conditions;

    //метод виден только наследникам.
    //инициализируется новый объект схемы:
    protected BaseSchema() {
        this.conditions = new HashMap<>();
    }

    //метод виден только наследникам.
    //добавление проверки:
    protected void addCondition(String checkName, Predicate<Object> condition) {
        conditions.put(checkName, condition);
    }

    //проверка на соответствие фильтрам:
    //если данные проходят через все фильтры - значит данные валидны, если нет - значит нет
    public boolean isValid(Object obj) {
        return conditions.values().stream().allMatch(condition -> condition.test(obj));
    }
}
