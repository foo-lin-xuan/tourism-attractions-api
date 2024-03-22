package sg.edu.ntu.singastays.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.ntu.singastays.entities.Member;
import sg.edu.ntu.singastays.entities.Interaction;
import sg.edu.ntu.singastays.exceptions.MemberNotFoundException;
import sg.edu.ntu.singastays.repositories.MemberRepository;
import sg.edu.ntu.singastays.repositories.InteractionRepository;
import sg.edu.ntu.singastays.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    
    private MemberRepository memberRepository;
    private InteractionRepository interactionRepository;

    // @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, InteractionRepository interactionRepository) {
        this.memberRepository = memberRepository;
        this.interactionRepository = interactionRepository;
    }

    @Override
    public ArrayList<Member> searchMembers(String firstName) {
        List<Member> foundMembers = memberRepository.findByFirstName(firstName);
        return (ArrayList<Member>) foundMembers;
    }

    @Override
    public Member createMember(Member member) {
        Member newMember = memberRepository.save(member);
        return newMember;
    }

    @Override
    public Member getMember(Long id) {
        // Optional<Member> optionalMember = memberRepository.findById(id);
        // if(optionalMember.isPresent()) {
        //     Member foundMember = optionalMember.get();
        //     return foundMember;
        // }
        // throw new MemberNotFoundException(id);
        return memberRepository.findById(id).orElseThrow(()-> new MemberNotFoundException(id));
    }

    @Override
    public ArrayList<Member> getAllMembers() {
        List<Member> allMembers = memberRepository.findAll();
        return (ArrayList<Member>) allMembers;
    }

    @Override
    public Member updateMember(Long id, Member member) {
        // retrieve the member from the database
        // [Activity 1 - Refactor code]
        Member memberToUpdate = memberRepository.findById(id).orElseThrow(()-> new MemberNotFoundException(id));
        // update the member retrieved from the database
        memberToUpdate.setFirstName(member.getFirstName());
        memberToUpdate.setLastName(member.getLastName());
        memberToUpdate.setEmail(member.getEmail());
        memberToUpdate.setContactNo(member.getContactNo());
        memberToUpdate.setCreatedDate(member.getCreatedDate());
        // memberToUpdate.setJobTitle(member.getJobTitle());
        // memberToUpdate.setYearOfBirth(member.getYearOfBirth());
        // save the updated member back to the database
        return memberRepository.save(memberToUpdate);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Interaction addInteractionToMember(Long id, Interaction interaction) {
        // retrieve the member from the database
        // [Activity 1 - Refactor code]
        Member selectedMember = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));

        // add the member to the interaction
        interaction.setMember(selectedMember);
        // save the interaction to the database
        return interactionRepository.save(interaction);
    }

    

}
