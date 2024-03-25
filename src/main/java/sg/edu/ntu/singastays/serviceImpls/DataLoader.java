package sg.edu.ntu.singastays.serviceImpls;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.edu.ntu.singastays.entities.Category;
import sg.edu.ntu.singastays.entities.Member;
import sg.edu.ntu.singastays.repositories.CategoryRepository;
import sg.edu.ntu.singastays.repositories.MemberRepository;
import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.repositories.AttractionRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DataLoader {
    private MemberRepository memberRepository;
    private CategoryRepository categoryRepository;
    private AttractionRepository attractionRepository;

    public DataLoader(MemberRepository memberRepository, CategoryRepository categoryRepository,
            AttractionRepository attractionRepository) {
        this.memberRepository = memberRepository;
        this.categoryRepository = categoryRepository;
        this.attractionRepository = attractionRepository;
    }

    @PostConstruct
    public void loadData() throws ParseException {
        // clear the database first
        memberRepository.deleteAll();
        categoryRepository.deleteAll();
        attractionRepository.deleteAll();

        // load data here
        // [Activity 2 - validation]
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        memberRepository.save(new Member("John", "Chan", "67485867", "jc@gmail.com", dateFormat.parse("2024-02-05")));
        memberRepository.save(new Member("Alfred", "Tan", "67485823", "at@gmail.com", dateFormat.parse("2024-02-07")));
        memberRepository.save(new Member("Jimmy", "Lim", "67485453", "jl@gmail.com", dateFormat.parse("2024-02-09")));

        categoryRepository.save(new Category("Water Base Activities"));
        categoryRepository.save(new Category("Night Life Activities"));
        categoryRepository.save(new Category("Theme Park"));
        categoryRepository.save(new Category("Nature Park"));

        attractionRepository.save(new Attraction("Escape Theme Park"));
        attractionRepository.save(new Attraction("Adventure Cove"));
        attractionRepository.save(new Attraction("Hydro-Dash"));

    }
}
