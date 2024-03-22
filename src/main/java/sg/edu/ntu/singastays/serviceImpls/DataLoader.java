package sg.edu.ntu.singastays.serviceImpls;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.edu.ntu.singastays.entities.Category;
import sg.edu.ntu.singastays.entities.Member;
import sg.edu.ntu.singastays.repositories.CategoryRepository;
import sg.edu.ntu.singastays.repositories.MemberRepository;

@Component
public class DataLoader {
    private MemberRepository memberRepository;
    private CategoryRepository categoryRepository;

    // @Autowired
    public DataLoader(MemberRepository memberRepository, CategoryRepository categoryRepository) {
        this.memberRepository = memberRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void loadData() {
        // clear the database first
        memberRepository.deleteAll();
        categoryRepository.deleteAll();

        // load data here
        // [Activity 2 - validation]
        memberRepository.save(new Member("John", "Chan", "67485867", "jc@gmail.com"));
        memberRepository.save(new Member("Alfred", "Tan", "67485823", "at@gmail.com"));
        memberRepository.save(new Member("Jimmy", "Lim", "67485453", "jl@gmail.com"));
        // memberRepository.save(new Member("Steve", "Rogers", "12345678", 1940));

        categoryRepository.save(Category.builder().name("Water Base Activities").build());
        categoryRepository.save(Category.builder().name("Night Life Activities").build());
        categoryRepository.save(Category.builder().name("Theme Park").build());
        categoryRepository.save(Category.builder().name("Nature Park").build());
    }
}
