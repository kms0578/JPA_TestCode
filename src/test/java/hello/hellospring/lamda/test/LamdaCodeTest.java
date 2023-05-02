package hello.hellospring.lamda.test;

import com.jayway.jsonpath.internal.function.text.Length;
import org.junit.jupiter.api.Test;
import org.thymeleaf.util.DateUtils;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LamdaCodeTest {

    public static final int	ERROR_PROTOCOL_NOT_SUPPORTED	= -1000;
    public static final int	ERROR_VERSION_NOT_SUPPORTED		= -1001;
    public static final int	ERROR_INCORRECT_LENGTH			= -1002;
    public static final int	ERROR_INVALID_KEY_NUMBER		= -1003;
    public static final int	ERROR_MAC_MISMATCH				= -1004;
    public static final int	ERROR_INVALID_FIELD_DATA		= -1101;
    public static final int	ERROR_INCORRECT_FIELD_DATA		= -1201;
    public static final int	ERROR_UNKNOWN_PROTOCOL_ERROR	= -1999;

    public static final int	ERROR_USER_NOT_EXIST			= -2000;
    public static final int	ERROR_INCORRECT_PASSWORD		= -2001;
    public static final int ERROR_USER_BLOCKED				= -2002;
    public static final int ERROR_HOST_NOT_ALLOWED			= -2003;
    public static final int	ERROR_INVALID_STORE_ID			= -2004;
    public static final int	ERROR_STORE_ID_NOT_ALLOWED		= -2005;
    public static final int	ERROR_UNKNOWN_AUTH_ERROR		= -2999;

    public static final int ERROR_INSUFFICIENT_BALANCE		= -3000;
    public static final int	ERROR_INVALID_AMOUNT_UNIT		= -3001;
    public static final int	ERROR_ONCE_LIMIT_EXCEEDED		= -3002;
    public static final int	ERROR_DAY_LIMIT_EXCEEDED		= -3003;
    public static final int	ERROR_MONTH_LIMIT_EXCEEDED		= -3004;
    public static final int ERROR_ALREADY_APPROVED			= -3005;
    public static final int	ERROR_ALREADY_CANCELLED			= -3006;
    public static final int	ERROR_TRANSACTION_NOT_FOUND		= -3007;
    public static final int	ERROR_TOO_FAST_TRANSACTION		= -3008;
    public static final int	ERROR_TRANSACTION_TIMEDOUT		= -3009;
    public static final int	ERROR_SETTLED_TRANSACTION		= -3024;
    public static final int	ERROR_UNKNOWN_TRANSACTION_ERROR	= -3999;

    public static final int	ERROR_SERVICE_STOPPED			= -9000;
    public static final int	ERROR_UNKNOWN_ERROR				= -9999;

    public static final int	FIELD_INDEX_TYPE					= 0;
    public static final int	FIELD_INDEX_AMOUNT					= 1;
    public static final int	FIELD_INDEX_TERM_TYPE				= 2;
    public static final int	FIELD_INDEX_TERM_ID					= 3;
    public static final int	FIELD_INDEX_STORE_ID				= 4;
    public static final int	FIELD_INDEX_AUTH_TYPE				= 5;
    public static final int	FIELD_INDEX_AUTH_ID					= 6;
    public static final int	FIELD_INDEX_AUTH_PASSWORD			= 7;
    public static final int	FIELD_INDEX_ORDER_NO				= 8;
    public static final int	FIELD_INDEX_ORDER_DATE				= 9;
    public static final int	FIELD_INDEX_COMMODITY_TYPE			= 10;
    public static final int	FIELD_INDEX_COMMODITY_ID			= 11;
    public static final int	FIELD_INDEX_COMMODITY_NAME			= 12;
    public static final int	FIELD_INDEX_ORIGINAL_APPROVAL_NO	= 13;
    public static final int	FIELD_INDEX_STORE_DATA				= 14;
    public static final int	FIELD_INDEX_MEMO					= 15;

    private final List<String> list = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    @Test
    void test() {
        String result = list.stream()
                .filter(x -> x.length() > 1)
                .map(String::toUpperCase)
                .map(w -> w.substring(0, 1))
                .collect(Collectors.joining(" "));

        System.out.println(result);

        assertThat(result).isEqualTo("T H A N K");
    }

    @Test
    void sort() {
        String[] nameArr = {"h", "g", "f", "e", "d"};
        List<String> nameList = Arrays.asList(nameArr);

        Stream<String> nameStream = nameList.stream();
        Stream<String> arrayStream = Arrays.stream(nameArr);

        nameStream.sorted().forEach(System.out::println);
        arrayStream.sorted().forEach(System.out::println);
    }

    // 함수형 인터페이스 테스트
    @FunctionalInterface
    interface  sortInteger {
        int max(int a, int b);
    }

    @Test
    void compare() {
        sortInteger sortInteger = (int a, int b) -> a > b ? a : b;
        System.out.println(sortInteger.max(3, 5));
    }

    @Test
    void steamList() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> listStream = list.stream();
    }

    @Test
    void joining() {
        List<String> list = Arrays.asList("a", "b", "c", "da", "ad");

        String stream =
                list.stream()
                .filter(data -> data.contains("a"))
                .collect(Collectors.joining(" "));

        System.out.println(stream);

        list.stream()
                .filter(data -> data.contains("a"))
                .forEach(System.out::println);
    }

    @Test
    void subString() {
        String code = "SSER1";

        System.out.println(code.charAt(2));

        if("F".equals(code.substring(2, 3))) {
            System.out.println("1");
        } else{
            System.out.println("2");
        }

    }


    @Test
    public void codeTest() {
        int resultCode = -100;
        for (int i = resultCode; i > -111; i--) {
            System.out.println("i : " + i);

            switch (i) {
                case -1: case -101:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            + resultCode - (resultCode % 100)
                            - FIELD_INDEX_AUTH_ID);
                    break;
                case -2: case -102:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            - (resultCode % 100)
                            - FIELD_INDEX_COMMODITY_TYPE
                    );
                    break;
                case -3: case -103:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            - (resultCode % 100)
                            - FIELD_INDEX_AMOUNT
                    );
                    break;
                case -4: case -104:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            + resultCode - (resultCode % 100)
                            - FIELD_INDEX_STORE_ID
                    );
                case -5: case -105:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            - (resultCode % 100)
                            - FIELD_INDEX_ORDER_NO
                    );
                    break;
                case -6: case -106:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            - (resultCode % 100)
                            - FIELD_INDEX_ORDER_DATE
                    );
                    break;
                case -7: case -107:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            - (resultCode % 100)
                            - FIELD_INDEX_COMMODITY_ID
                    );
                    break;
                case -8: case -108:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            - (resultCode % 100)
                            - FIELD_INDEX_COMMODITY_NAME
                    );
                    break;
                case -9: case -109:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            - (resultCode % 100)
                            - FIELD_INDEX_TERM_TYPE
                    );
                    break;
                case -10: case -110:
                    System.out.println(ERROR_INVALID_FIELD_DATA
                            - (resultCode % 100)
                            - FIELD_INDEX_AUTH_ID
                    );
                    break;
            }
        }
    }
}
