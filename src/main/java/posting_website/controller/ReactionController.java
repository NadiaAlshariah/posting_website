package posting_website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import posting_website.service.ReactionService;
import posting_website.model.Post;
import posting_website.model.AppUser;
import posting_website.model.Reaction;

import java.util.List;

@RestController
@RequestMapping(path = "Reaction")
public class ReactionController {

    private final ReactionService reactionService;

    @Autowired
    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }
    @GetMapping
    public List<Reaction> getReactions(){
        return reactionService.getReactions();
    }

    @PostMapping
    public void addReaction(@RequestBody Reaction reaction){
        reactionService.addReaction(reaction);
    }

    @DeleteMapping(path="{user}/{post}")
    public void deleteReaction(
            @PathVariable("user") AppUser user,
            @PathVariable("post") Post post
    ){
        reactionService.deleteReaction(user, post);
    }

    @PutMapping(path="{user}/{post}")
    public void updateReaction(
            @PathVariable("user") AppUser user,
            @PathVariable("post") Post post,
            @RequestParam(required = true) String type
    ){
        reactionService.updateReaction(user, post, type);
    }
}
