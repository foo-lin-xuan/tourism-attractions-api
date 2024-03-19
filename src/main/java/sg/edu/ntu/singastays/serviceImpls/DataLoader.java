package sg.edu.ntu.singastays.serviceImpls;



import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.edu.ntu.singastays.entities.Member;
import sg.edu.ntu.singastays.repositories.MemberRepository;

@Component
public class DataLoader {
    private MemberRepository memberRepository;

    // @Autowired
    public DataLoader(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostConstruct
    public void loadData() {
        // clear the database first
        memberRepository.deleteAll();

        // load data here
        // [Activity 2 - validation]
        memberRepository.save(new Member("John", "Chan", "67485867", "jc@gmail.com"));
        memberRepository.save(new Member("Alfred","Tan", "67485823", "at@gmail.com"));
        memberRepository.save(new Member("Jimmy", "Lim", "67485453", "jl@gmail.com"));
        // memberRepository.save(new Member("Steve", "Rogers", "12345678", 1940));
    }
}
