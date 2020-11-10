package nodes.exampleNode.impl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import common.framework.NodeService;
import common.framework.ServiceParam;
import common.utils.SingletonUtils;
import nodes.NodeModule;
import nodes.exampleNode.ExampleService;
import nodes.exampleNode.HelperService;
import nodes.exampleNode.models.ExampleServiceParam;

import static nodes.exampleNode.contants.Constant.EXAMPLE_MESSAGE;

/**
 * Created by Xinyu Zhu on 2020/11/2, 23:00
 * nodes.exampleNode.impl in codingDimension
 */
public class ExampleServiceImpl implements ExampleService {

    private final HelperService helperService;

    @Inject
    public ExampleServiceImpl(HelperService helperService) {
        this.helperService = helperService;
    }

    public void runService(ServiceParam serviceParam) {
        ExampleServiceParam exampleServiceParam = (ExampleServiceParam) serviceParam;
        System.out.println(exampleServiceParam.getMessage() + ":" + getExampleString());
    }

    public String getExampleString() {
        return EXAMPLE_MESSAGE + ":" + helperService.getCurrentTimeInString();
    }

    // You can put the main function here or to the ExampleModule or anywhere you like
    public static void main(String[] args) {
        // Used by user
        // Always use NodeModule's global injector unless you are sure that your code do not inject any service outside the local node
        Injector injector = NodeModule.getGlobalInjector();
        ExampleService exampleService = injector.getInstance(ExampleService.class);
        System.out.println(exampleService.getExampleString());

        // Used by System

        injector = NodeModule.getGlobalInjector(); //  use NodeModule.newInjector() if you need a new injector (new set of Singleton service)
        ExampleService exampleService2 =  injector.getInstance(ExampleService.class);
        ServiceParam exampleServiceParam = new ExampleServiceParam("1000");
        // You can see each time guice return a difference instance unless it is Singleton
        exampleService2.runService(exampleServiceParam);


        // Access to common layer in the node
        SingletonUtils singletonUtils = injector.getInstance(SingletonUtils.class);
        System.out.println( singletonUtils.getAString());


    }
}
