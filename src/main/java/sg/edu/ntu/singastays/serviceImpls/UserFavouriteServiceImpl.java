package sg.edu.ntu.singastays.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import sg.edu.ntu.singastays.entities.Attraction;
import sg.edu.ntu.singastays.entities.Category;
import sg.edu.ntu.singastays.entities.Member;
import sg.edu.ntu.singastays.entities.UserFavourite;
import sg.edu.ntu.singastays.exceptions.AttractionNotFoundException;
import sg.edu.ntu.singastays.exceptions.CategoryNotFoundException;
import sg.edu.ntu.singastays.exceptions.MemberNotFoundException;
import sg.edu.ntu.singastays.repositories.AttractionRepository;
import sg.edu.ntu.singastays.repositories.CategoryRepository;
import sg.edu.ntu.singastays.repositories.MemberRepository;
import sg.edu.ntu.singastays.repositories.UserFavouriteRepository;
import sg.edu.ntu.singastays.services.UserFavouriteService;

@Service
public class UserFavouriteServiceImpl implements UserFavouriteService {

    // @Autowired
    private UserFavouriteRepository userFavouriteRepository;
    private MemberRepository memberRepository;
    private CategoryRepository categoryRepository;
    private AttractionRepository attractionRepository;

    public UserFavouriteServiceImpl(UserFavouriteRepository userFavouriteRepository, MemberRepository memberRepository,
            CategoryRepository categoryRepository, AttractionRepository attractionRepository) {
        this.userFavouriteRepository = userFavouriteRepository;
        this.memberRepository = memberRepository;
        this.categoryRepository = categoryRepository;
        this.attractionRepository = attractionRepository;
    }

    @Override
    public ArrayList<UserFavourite> getAllUserFavourites() {
        List<UserFavourite> allUserFavourites = userFavouriteRepository.findAll();
        return (ArrayList<UserFavourite>) allUserFavourites;
    }

    @Override
    public UserFavourite getUserFavouriteById(Long id) {
        return userFavouriteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserFavourite with id " + id + " not found"));
    }

    @Override
    public UserFavourite createUserFavourite(Long memberId, Long categoryId, Long attractionId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
        Category category = null;
        Attraction attraction = null;
        if (categoryId != null) {
            category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        }
        if (attractionId != null) {
            attraction = attractionRepository.findById(attractionId)
                    .orElseThrow(() -> new AttractionNotFoundException(attractionId));
        }
        UserFavourite userFavourite = new UserFavourite(member, category, attraction);
        return userFavouriteRepository.save(userFavourite);
    }

    // @Override
    // public UserFavourite updateUserFavourite(Long id, UserFavourite
    // userFavourite) {
    // UserFavourite existingUserFavourite = userFavouriteRepository.findById(id)
    // .orElseThrow(() -> new EntityNotFoundException("UserFavourite with id " + id
    // + " not found"));
    // existingUserFavourite.setUser(userFavourite.getUser());
    // existingUserFavourite.setAttraction(userFavourite.getAttraction());
    // // Set other fields as needed
    // return userFavouriteRepository.save(existingUserFavourite);
    // }

    @Override
    public void deleteUserFavourite(Long id) {
        if (!userFavouriteRepository.existsById(id)) {
            throw new EntityNotFoundException("UserFavourite with id " + id + " not found");
        }
        userFavouriteRepository.deleteById(id);
    }

    // @Override
    // public UserFavourite updateUserFavourite(Long id, UserFavourite
    // userFavourite) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'updateUserFavourite'");
    // }

}
