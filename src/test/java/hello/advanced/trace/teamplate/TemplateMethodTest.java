package hello.advanced.trace.teamplate;

import hello.advanced.trace.teamplate.code.AbstractTemplate;
import hello.advanced.trace.teamplate.code.SubClassLogic1;
import hello.advanced.trace.teamplate.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0(){
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직 1 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직 2 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    @Test
    void templateMethodV1(){
        AbstractTemplate subClassLogic1 = new SubClassLogic1();
        subClassLogic1.execute();

        AbstractTemplate subClassLogic2 = new SubClassLogic2();
        subClassLogic2.execute();
    }

    @Test
    void templateMethodV2(){
        AbstractTemplate template1 = new AbstractTemplate(){
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        log.info("template1 class={}",template1.getClass());
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate(){
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        log.info("template2 class={}",template2.getClass());
        template2.execute();
    }
}
