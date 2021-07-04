package hellow.hellospring.service;

import hellow.hellospring.domain.Member;
import hellow.hellospring.repository.MemberRepository;
import hellow.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { //테스트 실행시에 ctrl + shift + T 하면 테스트 실행

	private final MemberRepository memberRepository = new MemoryMemberRepository();

	/**
	 * 회원 가입
	 */
	public Long join(Member member){
		validateDuplicateMember(member); 		// 중복 회원 검증
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
				.ifPresent(m -> {
					throw new IllegalStateException("이미 존재하는 회원입니다.");
				});
	}

	/**
	 * 전체 회원 조회
	 */
	public List<Member> findMember(){
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
}
