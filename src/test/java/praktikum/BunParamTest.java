package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String nameBun;
    private final float priceBun;

    public BunParamTest(String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters(name = "Name bun = {0}")
    public static Object[][] data() {
        return new Object[][]{
                {"Standard bun", Float.MAX_VALUE},
                {"Sesame bun", Float.MIN_VALUE},
                {"QWEФыв", 12},
                {"@!#$%^", 0}
        };
    }

    @Test
    public void getNameBunTest() {
        Bun bun = new Bun(nameBun, priceBun);
        Assert.assertEquals("Name bun incorrect", nameBun, bun.getName());
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(nameBun, priceBun);
        Assert.assertEquals("Price bun incorrect", priceBun, bun.getPrice(), 0);
    }
}
