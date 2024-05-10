package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.HashMap;
import java.util.Map;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;


class ValidatorTest {

    @Test
    public void testStringValidator() {

        Validator v = new Validator();

        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();

        schema.required();
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();

        schema.minLength(7);
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isFalse();

        assertThat(
            schema.contains("what").isValid("what does the fox say")
        ).isTrue();

        assertThat(
            schema.contains("whatthe").isValid("what does the fox say")
        ).isFalse();
    }

    @Test
    public void testNumberValidator() {

        Validator v = new Validator();

        NumberSchema schema = v.number();

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        assertThat(schema.positive().isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(-10)).isFalse();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(10)).isTrue();

        schema.range(5, 10);
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();

        schema.range(6, 9);
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid(10)).isFalse();
    }

    @Test
    public void testMapValidator() {

        Validator v = new Validator();

        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(new HashMap<>())).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();

        schema.sizeof(2);
        assertThat(schema.isValid(new HashMap<>())).isFalse();
        Map<String, String> actual1 = new HashMap<>();
        actual1.put("key1", "value1");
        assertThat(schema.isValid(actual1)).isFalse();
        actual1.put("key2", "value2");
        assertThat(schema.isValid(actual1)).isTrue();
    }

    @Test
    public void testMapShape() {

        Validator v = new Validator();

        var schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("surName", v.string());
        schemas.put("lastName", v.string().required().minLength(2));
        assertEquals(schema, schema.shape(schemas));

        Map<String, String> person1 = new HashMap<>();
        person1.put("firstName", "Li");
        person1.put("surName", "");
        person1.put("lastName", "Bu");
        assertTrue(schema.isValid(person1));


        schemas.put("firstName", v.string().required());
        schemas.remove("surName");
        schemas.put("lastName", v.string().required());
        schema.shape(schemas);

        Map<String, String> person2 = new HashMap<>();
        person2.put("firstName", "Alina");
        person2.put("lastName", null);
        assertFalse(schema.isValid(person2));

        Map<String, String> person3 = new HashMap<>();
        person3.put("firstName", "Alex");
        person3.put("lastName", "");
        assertFalse(schema.isValid(person3));
    }
}
