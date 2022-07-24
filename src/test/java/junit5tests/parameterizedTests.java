package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class parameterizedTests {

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int theparams){
        System.out.println("theparams = " + theparams); //soutp + enter
    }

    @ParameterizedTest
//    @NullSource
//    @EmptySource
    @NullAndEmptySource
    @ValueSource(strings = {"firstString", "secondString", "ThirstString"})
    void stringValues(String theparams){
        System.out.println("theparams = " + theparams);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,mavel", "bucky,barnes"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,32,true", "captain,21,fale", "bucky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"captain america,'steve,rogers'", "winter solider,bucky,barnes''"})
    void csvSource_StringWithComa(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSourceStringWithDiffDelimiter(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv",
            "src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, double price,
                                                   int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", " +
                "qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }
        //Neu de binh thuong (ngan cach nhau boi dau "," thi doan code o tren dung
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist.csv",
            numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name, double price,
                                                   int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", " +
                "qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1){
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsSteam")
    void methodSource_StringStream(String param1){
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDouble(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
    void methodSource_StringdobleStream(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<String> sourceString(){
        //processing done here
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    Stream<String> sourceStringAsSteam(){
        //processing
        return Stream.of("beetroot", "apple", "pear");
    }

    List<Arguments> sourceList_StringDouble(){
        //processing
        return Arrays.asList(arguments("tomato", 2.0),
                arguments("carrot", 4.5),
                arguments("cabbage", 7.8));
    }


}
