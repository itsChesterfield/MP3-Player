package net.sharksystem.app.componentbasedappskeleton;

import org.junit.Assert;
import org.junit.Test;

import net.sharksystem.app.componentbasedappskeleton.app.componentA.ComponentA;
import net.sharksystem.app.componentbasedappskeleton.app.componentA.ComponentAImpl;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        ComponentA a = ComponentAImpl.getComponentA();
        int exampleValue = a.getExampleValue();

        Assert.assertEquals(0, exampleValue);
        Assert.assertEquals(1, a.getExampleValue());
        Assert.assertEquals(2, a.getExampleValue());
    }
}