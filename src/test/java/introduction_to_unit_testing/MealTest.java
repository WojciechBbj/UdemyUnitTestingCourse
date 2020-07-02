package introduction_to_unit_testing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void thatReturnDiscountedPrice() {
        //given
        Meal meal = new Meal(37);


        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertThat(discountedPrice).isEqualTo(30);
    }

    @Test
    void thatReferencesToTheSameObjectsShouldBeEqual() {
        //given

        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        //then
        assertThat(meal1).isSameAs(meal2);
    }

    @Test
    void thatReferencesToDifferentSameObjectsShouldNotBeEqual() {
        //given

        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);

        //then
        assertThat(meal1).isNotSameAs(meal2);

    }

    @Test
    void thatTwoMealsShouldBeEqualWhenNameAndPriceAreSame() {
        //given
        Meal meal1 = new Meal(20, "Pankake");
        Meal meal2 = new Meal(20, "Pankake");

        //then
        assertEquals(meal1, meal2, "Checking if two meals are equal");
        assertThat(meal1).isEqualTo(meal2);
    }

    @Test
    void thatExceptionShouldBeThrowingIfDiscountIsHigherThenThePrice() {
        //given
        Meal meal = new Meal(25, "pizza");

        //when and then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(40));

    }
}