package optional;

import org.apache.poi.ss.formula.functions.FactDouble;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @ClassNmae OptionalTest
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/23 8:08
 * @Version 1.0
 */
public class OptionalTest {
    public static void main(String[] args) {
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);
        assertEquals(user2.getEmail(), result.getEmail());
    }

//在引用接收的一方被动的接收，为了解决这种被动的方式
//    提供了Optional的处理 java.util.OPtional  1jdk.8



}
