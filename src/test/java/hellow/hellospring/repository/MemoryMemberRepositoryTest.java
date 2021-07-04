package hellow.hellospring.repository;

import hellow.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	// 테스트가 끝날 때 마다 리포지토리를 지워주는 코드를 넣어줘야 함
	// AfterEach는 '각각의 테스트가 끝나고 AfterEach를 실행한다.' 라고 생각하면 됨
	// 테스트는 각각 독립적으로 실행되어야 함. 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아님
	@AfterEach
	public void afterEach(){
		repository.clearStore(); // Test가 실행되고 끝날 때마다 repository를 싹 지움
	}

	@Test
	public void save(){
		Member member = new Member();
		member.setName("spring");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();
		assertThat(member).isEqualTo(result);
		// member = result랑 같아!
	}

	@Test
	public void findByName(){
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		// 동일한 문장을 복사하는데 변수명만 변경하고싶다면, Shift + F6

		Member result = repository.findByName("spring1").get();

		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void finAll(){
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring1");
		repository.save(member2);

		List<Member> result = repository.findAll();

		assertThat(result.size()).isEqualTo(2); // 멤버가 두 개니까 기댓값은 2가 됨
	}

	public void clearStore(){

	}
}
