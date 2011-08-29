package google.example;

import com.framework.BehaviourDrivenTest;
import com.framework.WebTestContext;
import org.junit.After;
import org.junit.Before;

public class BaseGoogleSearchWebTest<TTestContext extends WebTestContext>  extends BehaviourDrivenTest<TTestContext>{
    @Override
    @Before
    public void baseSetUp() {
        context.reset();

    }

    @Override
    @After
    public void baseTearDown() {

    }
}
