package JunitTests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(org.junit.runners.Suite.class)
@Suite.SuiteClasses({
        login.class,
        Demo1.class,
        Demo2.class
})
public class JunitTestSuite {
}
