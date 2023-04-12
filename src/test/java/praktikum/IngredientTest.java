package praktikum;

import jdk.jfr.Description;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String nameIngredient = "Котлета";
    private final float priceIngredient = 12;

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, nameIngredient, priceIngredient);

    @Test
    @Description("Этот тест проверяет работу метода getPrice")
    public void getPriceTest() {
        assertEquals(priceIngredient, ingredient.getPrice(), 0);
    }

    @Test
    @Description("Этот тест проверяет работу метода getName")
    public void getNameTest() {
        assertEquals(nameIngredient, ingredient.getName());
    }

    @Test
    @Description("Этот тест проверяет работу метода getType")
    public void getTypeTest() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}