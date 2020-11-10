package nodes;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import common.CommonModule;
import nodes.exampleNode.ExampleModule;

/**
 * Created by Xinyu Zhu on 2020/11/9, 21:11
 * nodes.exampleNode in codingDimensionTemplate
 */
public class NodeModule extends AbstractModule {
    private static NodeModule instance = null;
    private static Injector injector = null;

    private NodeModule() {
        super();
    }

    // Always return a new Injector from the same instance, use it if you need a new set of Singleton service
    @Deprecated
    public static Injector newInjector() {
        if (instance == null) {
            synchronized (NodeModule.class) {
                if (instance == null) {
                    instance = new NodeModule();
                }
            }
        }
        return Guice.createInjector(instance);
    }

    // Always return the same injector, this is what you should do in 99% situation
    public static Injector getGlobalInjector() {
        if (injector == null) {
            synchronized (NodeModule.class) {
                if (injector == null) {
                    injector = newInjector();
                }
            }
        }
        return injector;
    }

    @Override
    protected void configure() {
        super.configure();
        // Node layer is depending on Common layer, so always install Common Module
        install(new CommonModule());

        // Add a new module when you create new node here
        install(new ExampleModule());
    }
}
