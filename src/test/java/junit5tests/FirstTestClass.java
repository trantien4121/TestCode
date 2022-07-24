package junit5tests;

import org.junit.jupiter.api.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class FirstTestClass {

    //BeforeAll được dùng để chỉ định một test method chạy đầu tiên trong một test class.
    // Lưu ý @BeforeAll phải được đặt trên static method, nếu không chương trình sẽ không biên dịch được.
    // @BeforeAll thường được dùng để chuẩn bị các data dùng chung cho các test method khác.
    @BeforeAll
    void beforeAll(){
        System.out.println("This is before All method");
    }

    //BeforeEach chỉ định 1 method sẽ luôn được thực thi trước mỗi test method thực thi.
    @BeforeEach
    void beforeEach(){
        System.out.println("---- This is the before Each method");
    }

    //Chỉ định method sẽ được thực thi khi tất cả các test method trong class thực thi xong.
    // @AfterAll phải được đặt trên static method.
    @AfterAll
    void afterAll(){
        System.out.println("--This is the after All method");
    }

    //AfterEach
    //Chỉ định 1 method luôn thực thi sau khi 1 test method thực thi xong
    @AfterEach
    void afterEach(){
        System.out.println("----This is the after Each method");
    }

    @Test
    void firstMethods(){
        System.out.println("This is the first test methods");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    void secondMethods(){
        System.out.println("This is the second test methods");
    }
}
