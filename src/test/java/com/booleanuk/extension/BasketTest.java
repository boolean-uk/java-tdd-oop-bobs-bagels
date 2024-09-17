package com.booleanuk.extension;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BasketTest {

    @Test
    public void createBasketTest() {
        Basket basket = new Basket(5);

        assertEquals(5, basket.getCapacity());
        assertEquals(0, basket.getCurrentAmountOfProducts());
        assertTrue(basket.getProductsCount().isEmpty());
    }

    @Nested
    public class AddTest {

        private static Basket BASKET;
        private static String PLAIN_BAGEL;
        private static String EVERYTHING_BAGEL;
        private static String EGG_FILLING;

        @BeforeAll
        public static void createBasket() {
            BASKET = new Basket(5);
            PLAIN_BAGEL = "BGLP";
            EVERYTHING_BAGEL = "BGLE";
            EGG_FILLING = "FILE";
        }

        @AfterEach
        public void clearBasket() {
            BASKET.clearBasket();
        }

        @Test
        public void addToBasketEnoughSpaceTest() {

            assertTrue(BASKET.add(PLAIN_BAGEL, 1));
            assertEquals(1, BASKET.getCurrentAmountOfProducts());

            assertTrue(BASKET.add(PLAIN_BAGEL, 1));
            assertEquals(2, BASKET.getCurrentAmountOfProducts());
            assertEquals(2, BASKET.getProductsCount().get(PLAIN_BAGEL));



            assertTrue(BASKET.add(EGG_FILLING, 3));
            assertEquals(5, BASKET.getCurrentAmountOfProducts());

            assertEquals(2, BASKET.getProductsCount().size());
            assertEquals(2, BASKET.getProductsCount().get(PLAIN_BAGEL));
            assertEquals(3, BASKET.getProductsCount().get(EGG_FILLING));
        }

        @Test
        public void addToBasketNotEnoughSpace() {
            assertFalse(BASKET.add(EVERYTHING_BAGEL, 8));
            assertEquals(0, BASKET.getCurrentAmountOfProducts());
            assertTrue(BASKET.getProductsCount().isEmpty());
        }

        @Test
        public void addToBasketAmountLessOrEqualZero() {
            assertFalse(BASKET.add(PLAIN_BAGEL, 0));
            assertFalse(BASKET.add(EGG_FILLING, -2));

            assertEquals(0, BASKET.getCurrentAmountOfProducts());
            assertTrue(BASKET.getProductsCount().isEmpty());
        }
    }

    @Nested
    public class RemoveTest {
        private static Basket BASKET;
        private static String PLAIN_BAGEL;
        private static String EVERYTHING_BAGEL;
        private static String SESAME_BAGEL;


        @BeforeAll
        public static void createBasket() {
            BASKET = new Basket(10);
            PLAIN_BAGEL = "BGLP";
            EVERYTHING_BAGEL = "BGLE";
            SESAME_BAGEL = "BGLS";
        }

        @BeforeEach
        public void addProducts() {
            BASKET.add(PLAIN_BAGEL, 6);
            BASKET.add(EVERYTHING_BAGEL, 2);
            BASKET.add(SESAME_BAGEL, 2);
        }

        @AfterEach
        public void clearBasket() {
            BASKET.clearBasket();
        }

        @Test
        public void removeProductFromBasketTest() {
            assertTrue(BASKET.remove(PLAIN_BAGEL, 4));

            assertEquals(2, BASKET.getProductsCount().get(PLAIN_BAGEL));
            assertEquals(6, BASKET.getCurrentAmountOfProducts());
            assertEquals(3, BASKET.getProductsCount().size());

            assertTrue(BASKET.remove(PLAIN_BAGEL, 2));
            assertFalse(BASKET.getProductsCount().containsKey(PLAIN_BAGEL));
            assertEquals(4, BASKET.getCurrentAmountOfProducts());
            assertEquals(2, BASKET.getProductsCount().size());
        }

        @Test
        public void removeTooManyProductsFromBasketTest() {
            assertFalse(BASKET.remove(EVERYTHING_BAGEL, 4));

            assertEquals(2, BASKET.getProductsCount().get(EVERYTHING_BAGEL));
            assertEquals(10, BASKET.getCurrentAmountOfProducts());
            assertEquals(3, BASKET.getProductsCount().size());
        }

        @Test
        public void removeNonPositiveNumberOfProductsTest() {
            assertFalse(BASKET.remove(EVERYTHING_BAGEL, 0));
            assertFalse(BASKET.remove(EVERYTHING_BAGEL, -4));

            assertEquals(2, BASKET.getProductsCount().get(EVERYTHING_BAGEL));
            assertEquals(10, BASKET.getCurrentAmountOfProducts());
            assertEquals(3, BASKET.getProductsCount().size());
        }

        @Test
        public void removeProductThatIsNotStoredInInventoryTest() {
            assertFalse(BASKET.remove("Plastic", 4));

            assertEquals(2, BASKET.getProductsCount().get(EVERYTHING_BAGEL));
            assertEquals(6, BASKET.getProductsCount().get(PLAIN_BAGEL));
            assertEquals(2, BASKET.getProductsCount().get(SESAME_BAGEL));
            assertEquals(10, BASKET.getCurrentAmountOfProducts());
            assertEquals(3, BASKET.getProductsCount().size());
        }
    }

    @Nested
    public class ChangeCapacity {

        private static Basket BASKET;

        @BeforeAll
        public static void createBasket() {
            BASKET = new Basket(10);
            String PLAIN_BAGEL = "BGLP";
            String EVERYTHING_BAGEL = "BGLE";
            String SESAME_BAGEL = "BGLS";
            BASKET.add(PLAIN_BAGEL, 6);
            BASKET.add(EVERYTHING_BAGEL, 2);
            BASKET.add(SESAME_BAGEL, 2);
        }

        @Test
        public void changeCapacityToNumberGreaterThanCurrentAmountOfProductsTest() {
            assertTrue(BASKET.changeCapacity(15));
        }

        @Test
        public void changeCapacityToNumberLessThanCurrentAmountOfProductsTest() {
            assertFalse(BASKET.changeCapacity(8));
        }

        @Test
        public void changeCapacityToNonPositiveNumberTest() {
            assertFalse(BASKET.changeCapacity(0));
            assertFalse(BASKET.changeCapacity(-4));
        }
    }
}
