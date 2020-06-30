package introduction_to_unit_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void thatReturnDiscountedPrice() {
        //given
        Meal meal = new Meal(37);


        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertEquals(30, discountedPrice);
    }

    @Test
    void thatReferencesToTheSameObjectsShouldBeEqual() {
        //given

        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        //then
        assertSame(meal1, meal2);

    }

    @Test
    void thatReferencesToDifferentSameObjectsShouldNotBeEqual() {
        //given

        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);

        //then
        assertNotSame(meal1, meal2);

    }

    @Test
    void thatTwoMealsShouldBeEqualWhenNameAndPriceAreSame() {
        //given
        Meal meal1 = new Meal(20, "Pankake");
        Meal meal2 = new Meal(20, "Pankake");

        //then
        assertEquals(meal1, meal2, "Checking if two meals are equal");
    }
}