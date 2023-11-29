package posting_website.Reaction;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posting_website.Post.Post;
import posting_website.User.AppUser;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReactionService {
    ReactionRepository reactionRepository;

    @Autowired
    public ReactionService(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    public List<Reaction> getReactions(){
        return reactionRepository.findAll();
    }

    public void addReaction(Reaction reaction){
        Optional<Reaction> reactionOptional = reactionRepository.findReactionById(reaction.getAppUser(), reaction.getPost());
        if(reactionOptional.isPresent()){
            throw new IllegalStateException("already reacted");
        }
        reactionRepository.save(reaction);
    }

    public void deleteReaction(AppUser appUser, Post post){
        Optional<Reaction> reactionOptional = reactionRepository.findReactionById(appUser, post);
        if(reactionOptional.isEmpty()){
            throw new IllegalStateException("already reacted");
        }
        reactionRepository.delete(reactionOptional.get());
    }

    @Transactional
    public void updateReaction(AppUser appUser, Post post, String type){
        Reaction reaction = reactionRepository.findReactionById(appUser, post).orElseThrow(() -> new IllegalStateException("user " + appUser.getId() + " did not react to this post " + post.getId() ));

        if (!Objects.equals(type, reaction.getType())){
            reaction.setType(type);
        }
    }
}
