package sg.edu.ntu.singastays.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.singastays.entities.Member;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {
    // Custom query to find all members with a certain first name
    List<Member> findByFirstName(String firstName);
}
