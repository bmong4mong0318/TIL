package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// `@Component` 어노테이션이 있으면 스프링 빈으로 자동 등록 된다.
// `@Controller` 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문이다.
// HelloSpringApplication 이 실행되는 하위폴더에서만 컴포넌트 스캔이 이루어진다.

// 스프링이 처음 시작 될 때 스프링 커네이너가 하나 생기는데 그곳에 Controller 객체를 하나 만들어두고 관리한다.
// -> 스프링 빈이 관리된다고 한다.
// 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다. (유일하게 하나만 등록해서 공유한다.)
// 따라서 같은 스프링 빈이면 모두 같은 인스턴스이다.
@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자에 @Autowired 가 있으면 스프링 컨테이너에 있는 memberService 를 연결 시켜준다. (Dependency Injection)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
