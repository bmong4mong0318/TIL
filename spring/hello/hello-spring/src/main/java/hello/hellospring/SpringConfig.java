package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 자바 코드를 통해 직접 스프링 빈을 등록하기
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // 직접 코드를 짜서 설정 관계를 만들 때는 후에 변경이 용이하다.
//        return new DBMemberRepository();
        return new MemoryMemberRepository();
    }

}
