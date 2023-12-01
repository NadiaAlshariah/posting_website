package posting_website.Relationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import posting_website.Reaction.ReactionService;
import posting_website.User.AppUser;

import java.util.List;

@RestController
@RequestMapping(path = "/relationship")
public class RelationshipController {
    private final RelationshipService relationshipService;

    @Autowired
    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @GetMapping
    public List<Relationship> getRelationships(){
        return relationshipService.getRelationships();
    }

    @PostMapping
    public void addRelationship(@RequestBody Relationship relationship){
        relationshipService.addRelationship(relationship);
    }

    @DeleteMapping(path="{user}/{friend}")
    public void deleteRelationship(
            @PathVariable("user") AppUser user,
            @PathVariable("friend") AppUser friend
    ){
        relationshipService.deleteRelationship(user, friend);
    }

    @PutMapping(path = "{user}/{friend}")
    public void updateRelationship(
            @PathVariable("user") AppUser user,
            @PathVariable("friend") AppUser friend,
            @RequestParam(required = true) String status
    ){
        relationshipService.updateRelationship(user,friend,status);
    }



}
