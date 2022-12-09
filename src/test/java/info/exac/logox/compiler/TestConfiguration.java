package info.exac.logox.compiler;

import org.springframework.context.annotation.Bean;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {

    @Bean
    public Compiler createCompiler() {
        return new Compiler();
    }

}
