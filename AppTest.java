import static org.junit.Assert.assertEquals;

import org.junit.Test;
import Model.ValorFuturo;

public class AppTest {
    
    @Test
    public void testValorPresenteNeto() {
        ValorFuturo valorFuturo = new ValorFuturo();
        assertEquals(true, valorFuturo.ValorPresenteNeto(34000, 473, 30));
        assertEquals(false, valorFuturo.ValorPresenteNeto(86810, 473, 30));
        assertEquals(true, valorFuturo.ValorPresenteNeto(86810, 2700, 1340));
    }
}
