package junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class OrderedTestClass2 {

    @BeforeAll
    void beforeAll(){
        System.out.println("This is before All method");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("---- This is the before Each method");
    }

    @AfterAll
    void afterAll(){
        System.out.println("--This is the after All method");
    }

    @AfterEach
    void afterEach(){
        System.out.println("----This is the after Each method");
    }

    @Test
    @Order(2)
    void firstMethods(){
        System.out.println("This is the first test methods");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethods(){
        System.out.println("This is the second test methods");
    }

    @Test
    @Order(1)
    void ThirdTest(){
        System.out.println("This is the third test method");
    }
}
