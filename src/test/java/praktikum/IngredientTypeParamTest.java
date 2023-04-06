package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {
    private final String type;

    public IngredientTypeParamTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "Name ingredient type = {0}")
    public static Object[][] data() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void values() {
        assertThat(IngredientType.valueOf(type), is(notNullValue()));
    }
}