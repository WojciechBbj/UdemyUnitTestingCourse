package introduction_to_unit_testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;

    @BeforeEach
    public void initializeOrder() {
        System.out.print("Inside @BeforeEach method");
        order = new Order();
    }

    @AfterEach
    public void clearUp() {
        System.out.println("Inside @AfterEach method");
        order.cancelOrder();
    }

    @Test
    public void testAssertArrayEquals() {

        //given
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};

        //then
        assertArrayEquals(ints1, ints2);
        clearUp();
    }


    @Test
    public void thatMealLeastShouldBeEmptyAfterCreationOfOrder() {

        //then
        assertThat(order.getMeals()).isEmpty();
        //assertThat(order.getMeals().size()).isEqualTo(0);
        //assertThat(order.getMeals()).hasSize(0);

        clearUp();
    }

    @Test
    public void thatAddingMealToOrderIncreaseOrderSize() {
        //given
        Meal meal = new Meal(15, "burger");
        Meal meal2 = new Meal(20, "pizza");

        //when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals()).isNotEmpty();
        assertThat(order.getMeals().size()).isEqualTo(2);
        assertThat(order.getMeals()).contains(meal);

        clearUp();
    }

    @Test
    public void thatRemovingMealFromOrderWillDecreaseOrderSize() {

        //given
        Meal meal1 = new Meal(25, "pizza");

        //when
        order.addMealToOrder(meal1);
        order.removeMealFromOrder(meal1);

        //then
        assertThat(order.getMeals().size()).isEqualTo(0);
        assertThat(order.getMeals()).hasSize(0);

        clearUp();
    }

    @Test
    public void thatMealsShouldBeInCorrectAfterAddingItToOrder() {
        //given
        Meal meal1 = new Meal(25, "pizza");
        Meal meal2 = new Meal(15, "burger");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals()).containsExactly(meal1, meal2);

        clearUp();
    }

    @Test
    public void thatTwoListsAreTheSame() {
        //given
        Meal meal1 = new Meal(25, "pizza");
        Meal meal2 = new Meal(15, "burger");
        Meal meal3 = new Meal(20, "kebab");

        List<Meal> meals1 = Arrays.asList(meal1, meal2, meal3);
        List<Meal> meals2 = Arrays.asList(meal1, meal2, meal3);

        Order order1 = new Order();

        //then

        assertThat(meals1).isEqualTo(meals2);

        clearUp();
    }

}