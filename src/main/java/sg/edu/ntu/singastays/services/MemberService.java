package sg.edu.ntu.singastays.services;

import java.util.ArrayList;

import sg.edu.ntu.singastays.entities.Member;
import sg.edu.ntu.singastays.entities.Interaction;

public interface MemberService {
    
    Member createMember(Member member);

    Member getMember(Long id);

    ArrayList<Member> getAllMembers();

    Member updateMember(Long id, Member member);

    void deleteMember(Long id);

    Interaction addInteractionToMember(Long id, Interaction interaction);

    ArrayList<Member> searchMembers(String firstName);
}
