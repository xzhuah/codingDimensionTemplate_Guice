package nodes.exampleNode;

import com.google.inject.AbstractModule;
import nodes.exampleNode.impl.ExampleServiceImpl;
import nodes.exampleNode.impl.HelperServiceImpl;

/**
 * Created by Xinyu Zhu on 2020/11/9, 21:10
 * nodes.exampleNode in codingDimensionTemplate
 */
public class ExampleModule extends AbstractModule {
    @Override
    protected void configure() {
        super.configure();

        // bind your service interface (only those you want to use for injection) and their implementation here
        bind(ExampleService.class).to(ExampleServiceImpl.class);
        bind(HelperService.class).to(HelperServiceImpl.class);

    }
}
