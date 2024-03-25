package sg.edu.ntu.singastays.controllers;

import java.util.ArrayList;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.singastays.entities.Member;
import sg.edu.ntu.singastays.entities.Interaction;
import sg.edu.ntu.singastays.services.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    // @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/search")
    public ResponseEntity<ArrayList<Member>> searchMembers(@RequestParam String firstName) {
        ArrayList<Member> foundMembers = memberService.searchMembers(firstName);
        return new ResponseEntity<>(foundMembers, HttpStatus.OK);
    }

    // CREATE
    @PostMapping("")
    public ResponseEntity<Member> createMember(@Valid @RequestBody Member member) {
        
        // if(bindingResult.hasErrors()) {
        //     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        // }
        
        Member newMember = memberService.createMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    // READ (GET ALL)
    @GetMapping("")
    public ResponseEntity<ArrayList<Member>> getAllMembers() {
        ArrayList<Member> allMembers = memberService.getAllMembers();
        return new ResponseEntity<>(allMembers, HttpStatus.OK);
    }

    // READ (GET ONE)
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        Member foundMember = memberService.getMember(id);
        return new ResponseEntity<>(foundMember, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);        
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Nested route - add interaction to member
    // [Activity 2 - validation]
    @PostMapping("/{id}/interactions")
    public ResponseEntity<Interaction> addInteractionToMember(@PathVariable Long id, @Valid @RequestBody Interaction interaction) {
        Interaction newInteraction = memberService.addInteractionToMember(id, interaction);
        return new ResponseEntity<>(newInteraction, HttpStatus.CREATED);
    }
}
