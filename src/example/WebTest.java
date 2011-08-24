package example;

import com.framework.BehaviourDrivenTest;
import com.framework.TestContext;
import org.junit.After;
import org.junit.Before;

public class WebTest<TTestContext extends TestContext>  extends BehaviourDrivenTest<TTestContext>{
    @Override
    @Before
    public void baseSetUp() {
        Context.reset();
    }

    @Override
    @After
    public void baseTearDown() {

    }
}
