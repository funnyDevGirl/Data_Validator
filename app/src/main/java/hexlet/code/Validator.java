package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    //создаю новый объект StringSchema для обработки строк:
    public StringSchema string() {
        return new StringSchema();
    }

    //создаю новый объект NumberSchema для обработки числел:
    public NumberSchema number() {
        return new NumberSchema();
    }

    //создаю новый объект MapSchema для обработки словарей:
//    public MapSchema map() {
//        return new MapSchema();
//    }
}
