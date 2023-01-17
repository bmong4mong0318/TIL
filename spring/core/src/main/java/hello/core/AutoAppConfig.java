package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//`@ComponentScan`은 `@Component`가 붙은 모든 클래스를 스프링 빈으로 등록한다.
//이때 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.
//ex) MemberServiceImpl 클래스 -> memberServiceImpl
@ComponentScan(
    //탐색할 패키지의 시작 위치를 지정한다.
    //이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
    //만약 지정하지 않으면 `@ComponentScan`이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.
    basePackages = "hello.core",
    //제외 파일 지정
    excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
