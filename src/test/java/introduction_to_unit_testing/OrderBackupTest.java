package introduction_to_unit_testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setUp() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void appendTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("New order: ");
    }

    @AfterEach
    void appendAtTheEndOfTheLine() throws IOException {
        orderBackup.getWriter().append(" backed up");
    }

    @Test
    public void thatBackupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(25, "pizza");
        Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backOrder(order);

        //then
        System.out.println("Order: " + order.toString() + " backed up.");

    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closedFile();
    }

}