package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl 은 MemberRepository(추상화)에도 의존하고 MemoryMemberRepository(구체화)에도 의존한다.
    // -> 구체화 부분을 변경하려 할 때 문제가 된다. (DIP 위반)
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
