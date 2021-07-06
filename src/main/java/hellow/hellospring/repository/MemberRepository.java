package hellow.hellospring.repository;

import hellow.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
	//Optional? -> Null이 반환되지 않게 한 번 더 감싸주는 방식
}
