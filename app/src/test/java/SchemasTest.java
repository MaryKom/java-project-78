import hexlet.code.StringSchema;
import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchemasTest {
    @Test
    public void testStringSchema() {
        final Validator v = new Validator();
        final StringSchema schema = v.string();
        final int length = 5;
        final String testString = "what does the fox say";

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();
        schema.minLength(length);
        assertTrue(schema.isValid(testString));
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid("test"));

        schema.contains("what");
        assertTrue(schema.isValid(testString));

        schema.contains("whatthe");
        assertFalse(schema.isValid(testString));

        assertFalse(schema.isValid(testString));
    }
}
