package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsTest {
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    //assumeTrue
        // Đảm bảo điều kiện phải đúng trước khi thực thi test method.
    void intValues(int theparams){
        Assumptions.assumeTrue(theparams > 4);
        System.out.println("theparams = " + theparams);
    }

    //assumeFalse
    //Đảm bảo điều kiện phải trả về false trước khi thực thi test method.
    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,mavel", "bucky,barnes"})
    void csvSource_StringString(String param1, String param2){
        assumeFalse(param1.equals("steve"), " The assumption falied for the " +
                 "following param2: " + param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    //assumeThat
    //Sử dụng assumeThat để kết hợp assume và assert cách nhanh chóng.
    @ParameterizedTest
    @CsvSource(value = {"steve,32,true", "captain,21,fale", "bucky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        assumingThat(param2 > 20, () -> System.out.println("This code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
}
