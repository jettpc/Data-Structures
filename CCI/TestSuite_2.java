package CCI;

import org.junit.*;

public class TestSuite_2 {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("asddsf");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void test1() {
        System.out.println("Penis");
    }

    @Test
    public void test2() {
        System.out.println("OK");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @AfterClass
    public static void afterclass() {
        System.out.println("asdfasdfsd");
    }
}
