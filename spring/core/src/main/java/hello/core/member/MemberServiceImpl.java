package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl 은 MemberRepository(추상화)에도 의존하고 MemoryMemberRepository(구체화)에도 의존한다.
    // -> 구체화 부분을 변경하려 할 때 문제가 된다. (DIP 위반)

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    // 생성자 주입
    // 생성자를 통해 `MemoryMemberRepository`를 주입하게 되면 이제 `MemberServiceImpl`에는 `MemoryMemberRepository`에 대한 코드가 없다.
    // `MemberRepository`라는 인터페이스만 존재하게 된다. -> 추상화에만 의존하게 되었다. -> DIP를 지킨다!
    // `MemberServiceImpl` 입장에서 생성자를 통해 어떤 구현 객체가 들어올지(주입될지)알 수 없다.
    // `MemberServiceImpl`의 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부('AppConfig')에서 결정된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
