package praktikum;

import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private float priceBun = 10f;
    private float priceCutlet = 11f;
    private float priceSauce = 12f;
    @Mock
    Bun bun;
    @Mock
    Ingredient cutlet;
    @Mock
    Ingredient cheeseSauce;
    @Mock
    Ingredient salad;
    Burger burger = new Burger();

    @Before
    public void setUp() {
        burger.ingredients.clear();
        burger.ingredients.add(cutlet);
        burger.ingredients.add(cheeseSauce);
        burger.setBuns(bun);
    }

    @Test
    @Description("Этот тест проверяет работу метода addIngredient")
    public void addIngredientTest() {
        burger.addIngredient(salad);
        assertTrue(burger.ingredients.contains(salad));
    }

    @Test
    @Description("Этот тест проверяет работу метода setBuns")
    public void setBunsTest() {
        assertEquals(bun, burger.bun);
    }

    @Test
    @Description("Этот тест проверяет работу метода removeIngredient")
    public void removeIngredientTest() {
        burger.removeIngredient(burger.ingredients.indexOf(cutlet));
        assertFalse(burger.ingredients.contains(cutlet));
    }

    @Test
    @Description("Этот тест проверяет работу метода removeIngredient")
    public void removeAllIngredientTest() {
        for (int i = burger.ingredients.size(); i > 0; i--) {
            burger.removeIngredient(i - 1);
        }
        assertTrue("List not empty", burger.ingredients.isEmpty());
    }

    @Test
    @Description("Этот тест проверяет работу метода moveIngredient")
    public void moveIngredientTest() {
        burger.moveIngredient(1, 0);
        assertEquals("the ingredient has not changed its place in the list", 0, burger.ingredients.indexOf(cheeseSauce));
    }

    @Test
    @Description("Этот тест проверяет работу метода getPrice")
    public void getPriceTest() {
        float priceBurger = priceBun * 2 + priceCutlet + priceSauce;
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(cutlet.getPrice()).thenReturn(priceCutlet);
        Mockito.when(cheeseSauce.getPrice()).thenReturn(priceSauce);
        assertEquals(priceBurger, burger.getPrice(), 0);
    }

    @Test
    @Description("Этот тест проверяет работу метода getReceipt")
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        burger.setBuns(bun);
        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cutlet.getName()).thenReturn("Beef cutlet");
        Mockito.when(cutlet.getPrice()).thenReturn(priceCutlet);
        burger.addIngredient(cutlet);
        Mockito.when(cheeseSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(cheeseSauce.getName()).thenReturn("Cheese sause");
        Mockito.when(cheeseSauce.getPrice()).thenReturn(priceSauce);
        burger.addIngredient(cheeseSauce);
        List<Ingredient> ingredients = burger.ingredients;
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        assertEquals(receipt.toString(), burger.getReceipt());
    }

    @After
    public void cleanDate() {
        burger.ingredients.clear();
    }
}