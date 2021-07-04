package hellow.hellospring.service;

import hellow.hellospring.domain.Member;
import hellow.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore(); // Test가 실행되고 끝날 때마다 repository를 싹 지움
    }

    @Test
    void 회원가입() { // 테스트 코드는 사실 한글로 적어도 상관없음
        //given (상황이 주어졌을 때,)
        Member member = new Member();

        member.setName("hello"); //"spring"이더라도 가능

        //when (이것을 실행 했을 때,)
        Long saveId = memberService.join(member);

        //then (결과가 이게 나와야 한다.)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }


    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
        try {
            memberService.join(member2);

        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/

        //then

    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}