package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest  {
    Database database = new Database();
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void availableBunsTest() {
       database.buns.add(bun);
        assertFalse(database.availableBuns().isEmpty());
    }

    @Test
    public void availableIngredientsTest() {
        database.ingredients.add(ingredient);
        assertFalse(database.availableIngredients().isEmpty());
    }
}