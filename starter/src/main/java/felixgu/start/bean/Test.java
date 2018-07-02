package felixgu.start.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @Value("${test}")
    private String test;

    @Value("${cloud.config.test}")
    private String configtest;

    public String getConfigtest() {
        return configtest;
    }

    public String getTest() {
        return test;
    }
}
