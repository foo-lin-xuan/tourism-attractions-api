package sg.edu.ntu.singastays.serviceImpls;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.edu.ntu.singastays.entities.Category;
import sg.edu.ntu.singastays.entities.Member;
import sg.edu.ntu.singastays.repositories.CategoryRepository;
import sg.edu.ntu.singastays.repositories.MemberRepository;
import sg.edu.ntu.singastays.repositories.UserFavouriteRepository;
import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.repositories.AttractionRepository;
import sg.edu.ntu.singastays.entities.UserFavourite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class DataLoader {
    private MemberRepository memberRepository;
    private CategoryRepository categoryRepository;
    private AttractionRepository attractionRepository;
    private UserFavouriteRepository userFavouriteRepository;

    public DataLoader(MemberRepository memberRepository, CategoryRepository categoryRepository,
            AttractionRepository attractionRepository, UserFavouriteRepository userFavouriteRepository) {
        this.memberRepository = memberRepository;
        this.categoryRepository = categoryRepository;
        this.attractionRepository = attractionRepository;
        this.userFavouriteRepository = userFavouriteRepository;
    }

    @PostConstruct
    public void loadData() throws ParseException {
        // clear the database first
        memberRepository.deleteAll();
        categoryRepository.deleteAll();
        attractionRepository.deleteAll();
        userFavouriteRepository.deleteAll();

        // load data here
        // [Activity 2 - validation]
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // memberRepository.save(new Member("John", "Chan", "67485867", "jc@gmail.com", dateFormat.parse("2024-02-05")));
        // memberRepository.save(new Member("Alfred", "Tan", "67485823", "at@gmail.com", dateFormat.parse("2024-02-07")));
        // memberRepository.save(new Member("Jimmy", "Lim", "67485453", "jl@gmail.com", dateFormat.parse("2024-02-09")));
        Member member1 = new Member("John", "Chan", "67485867", "jc@gmail.com", dateFormat.parse("2024-02-05"));
        Member member2 = new Member("Alfred", "Tan", "67485823", "at@gmail.com", dateFormat.parse("2024-02-07"));
        Member member3 = new Member("Jimmy", "Lim", "67485453", "jl@gmail.com", dateFormat.parse("2024-02-09"));
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        // categoryRepository.save(new Category("Water Base Activities"));
        // categoryRepository.save(new Category("Night Life Activities"));
        // categoryRepository.save(new Category("Theme Park"));
        // categoryRepository.save(new Category("Nature Park"));
        Category category1 = new Category("Water Base Activities");
        Category category2 = new Category("Night Life Activities");
        Category category3 = new Category("Theme Park");
        Category category4 = new Category("Nature Park");
        categoryRepository.save(category1); 
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);

        // attractionRepository.save(new Attraction("Escape Theme Park"));
        // attractionRepository.save(new Attraction("Adventure Cove"));
        // attractionRepository.save(new Attraction("Hydro-Dash"));
        Attraction attraction1 = new Attraction("Escape Theme Park");
        Attraction attraction2 = new Attraction("Adventure Cove");
        Attraction attraction3 = new Attraction("Hydro-Dash");
        attractionRepository.save(attraction1);
        attractionRepository.save(attraction2);
        attractionRepository.save(attraction3);

        List<Member> members = memberRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        List<Attraction> attractions = attractionRepository.findAll();

        Member randomMember = members.get(1);
        Category randomCategory = categories.get(1);
        Attraction randomAttraction = attractions.get(1);
        UserFavourite userFavourite1 = new UserFavourite(randomMember, randomCategory, randomAttraction);

        Member randomMember2 = members.get(1);
        Category randomCategory2 = categories.get(1);
        Attraction randomAttraction2 = attractions.get(2);
        UserFavourite userFavourite2 = new UserFavourite(randomMember2, randomCategory2, randomAttraction2);
        //UserFavourite userFavourite2 = new UserFavourite(member2.getId(), category2.getId(), attraction2.getId());
        userFavouriteRepository.save(userFavourite1);
        userFavouriteRepository.save(userFavourite2);

    }
}
