import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    @Test
    public void calcBMITest() {
        BodyMassIndex test = new BodyMassIndex(72,155);
        double height = 0;
        double weight = 0;
        assertEquals((703.0*155/(72*72)), test.calcBMI(72,155));
    }

    @Test
    void categoryBMITest() {
        BodyMassIndex test = new BodyMassIndex(72,155);
        double height = 0;
        double weight = 0;
        assertEquals("Underweight", test.categoryBMI(72,130));
        assertEquals("Normal weight", test.categoryBMI(72,155));
        assertEquals("Overweight", test.categoryBMI(72,200));
        assertEquals("Obesity", test.categoryBMI(72,250));
    }
}