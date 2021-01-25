package cn.msw.springbootthymeleafstart;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author 毛送文
 * @Date 2021/1/25 8:59
 * @Version 1.0
 */
@DisplayName("Junit5_毛送文")
@SpringBootTest
public class Junit5Test {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    void testTimeOut() throws InterruptedException {
        Thread.sleep(600);
    }
    @DisplayName("测试DisplayName注解")
    @Test
    void testDisplayName(){
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @Test
    @DisplayName("测试简单断言")
    void testSimpleAssert(){
        int cal = cal(2, 3);
        assertEquals(5,cal,"业务逻辑计算失败");
        Object obj1=new Object();
        Object obj2=new Object();
        assertSame(obj1,obj2,"两个对象不一样");
    }

    @Test
    @DisplayName("array assert")
    void testArrayAssert(){
        assertArrayEquals(new int[]{1,2},new int[]{1,1},"两个对象不一样");
    }

    @Test
    @DisplayName("combination assert")
    void testCombinationAssert(){
        assertAll("test",
                ()-> assertTrue(true && false),
                ()-> assertEquals(1,1));
    }

    int cal(int i,int j){
        return i+j;
    }

    @DisplayName("测试方法2")
    @Test
    @Disabled
    void test2(){
        System.out.println(2);
    }
    @Test
    @RepeatedTest(5)
    void test3(){
        System.out.println("毛送文");
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试开始了...");
    }

    @Test
    @DisplayName("异常断言")
    void testException(){
        assertThrows(ArithmeticException.class,()->{int a=10/2;},"业务逻辑居然正常运行！");
    }

    @DisplayName("快速失败!")
    @Test
    void testFail(){
        if(1==2){
            fail("测试失败！");
        }
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了...");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试方法结束了...");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试方法开始了...");
    }
}
