package common.utils;

import com.google.inject.Injector;
import nodes.NodeModule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Xinyu Zhu on 2020/11/9, 22:27
 * common.utils in codingDimensionTemplate
 */
public class SingletonUtilsImplTest {
    Injector inject;

    @Before
    public void setUp() {
        inject = NodeModule.getGlobalInjector();
    }

    @Test
    public void test() {
        System.out.println(ExampleUtils.getAString());
        SingletonUtils singletonUtils = inject.getInstance(SingletonUtils.class);

        String example1 = singletonUtils.getAString();
        System.out.println(example1);

        inject = NodeModule.getGlobalInjector();
        singletonUtils = inject.getInstance(SingletonUtils.class);
        String example2 = singletonUtils.getAString();
        System.out.println(example2);

        assertEquals(example1, example2);

        inject = NodeModule.newInjector();
        singletonUtils = inject.getInstance(SingletonUtils.class);
        String example3 = singletonUtils.getAString();
        System.out.println(example3);

        // Not equal since we used a new Injector
        assertNotEquals(example1, example3);

    }

}