package sg.edu.ntu.singastays.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.edu.ntu.singastays.entities.Member;
import sg.edu.ntu.singastays.repositories.MemberRepository;
import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.repositories.AttractionRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DataLoader {
    private MemberRepository memberRepository;
    private AttractionRepository attractionRepository;

    public DataLoader() {
        // Default constructor
    }

    @Autowired
    public DataLoader(MemberRepository memberRepository, AttractionRepository attractionRepository) {
        this.memberRepository = memberRepository;
        this.attractionRepository = attractionRepository;
    }

    @PostConstruct
    public void loadData() throws ParseException {
        // clear the database first
        memberRepository.deleteAll();
        attractionRepository.deleteAll();

        // load data here
        // [Activity 2 - validation]
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        memberRepository.save(new Member("John", "Chan", "67485867", "jc@gmail.com", dateFormat.parse("2024-02-05")));
        memberRepository.save(new Member("Alfred","Tan", "67485823", "at@gmail.com", dateFormat.parse("2024-02-07")));
        memberRepository.save(new Member("Jimmy", "Lim", "67485453", "jl@gmail.com", dateFormat.parse("2024-02-09")));

        attractionRepository.save(new Attraction("Escape Theme Park", "Water Base Activities", dateFormat.parse("2024-02-05"), dateFormat.parse("2024-02-06")));
        attractionRepository.save(new Attraction("Adventure Cove", "Night Life Activities", dateFormat.parse("2024-02-07"), dateFormat.parse("2024-02-08")));
        attractionRepository.save(new Attraction("Hydro-Dash", "Theme Park", dateFormat.parse("2024-02-09"), dateFormat.parse("2024-02-10")));
    }
}
