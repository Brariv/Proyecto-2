import static org.junit.Assert.assertEquals;

import org.junit.Test;
import Model.ValorFuturo;

public class AppTest {
    
    @Test
    public void testValorPresenteNeto() {
        ValorFuturo valorFuturo = new ValorFuturo();
        assertEquals(true, valorFuturo.ValorPresenteNeto(34000, 473, 30));
    }
}
