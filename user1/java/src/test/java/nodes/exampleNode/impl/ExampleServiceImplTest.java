package nodes.exampleNode.impl;

import com.google.inject.Injector;
import common.framework.NodeService;
import common.framework.ServiceParam;
import nodes.NodeModule;
import nodes.exampleNode.ExampleService;
import nodes.exampleNode.models.ExampleServiceParam;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static nodes.exampleNode.contants.Constant.EXAMPLE_MESSAGE;

/**
 * Created by Xinyu Zhu on 2020/11/5, 19:37
 * nodes.exampleNode.impl in codingDimensionTemplate
 */
public class ExampleServiceImplTest {
    Injector inject;

    @Before
    public void setUp() {
        inject = NodeModule.getGlobalInjector();
    }

    @Test
    public void test() {
        ExampleService exampleService = inject.getInstance(ExampleService.class);
        String exampleString = exampleService.getExampleString();
        Assert.assertTrue(exampleString.contains(EXAMPLE_MESSAGE));

        NodeService nodeService = exampleService;
        ServiceParam exampleServiceParam = new ExampleServiceParam(String.valueOf(System.currentTimeMillis()));
        nodeService.runService(exampleServiceParam);
    }
}