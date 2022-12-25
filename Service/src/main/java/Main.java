import com.service.TestService;

import java.util.ServiceLoader;

/**
 * @Author zhangzhen
 * @create 2022/12/17 15:49
 */
public class Main {

    public static void main(String[] args) {

        ServiceLoader<TestService> serviceLoader = ServiceLoader.load(TestService.class);
        for (TestService testService : serviceLoader) {
            testService.insert();
            testService.select();
            testService.update();
            testService.delete();
        }

    }

}
