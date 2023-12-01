package posting_website.Relationship;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posting_website.User.AppUser;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RelationshipService {
    private final RelationsipRepository relationsipRepository;

    @Autowired
    public RelationshipService(RelationsipRepository relationsipRepository) {
        this.relationsipRepository = relationsipRepository;
    }

    public List<Relationship> getRelationships(){return relationsipRepository.findAll();}

    public void addRelationship(Relationship relationship){
        Optional<Relationship> relationshipOptional = relationsipRepository.findByUser(relationship.getUser(), relationship.getFriend());
        if(relationshipOptional.isPresent()){
            throw new IllegalStateException("Already added");
        }
        relationsipRepository.save(relationship);
    }

    public void deleteRelationship(AppUser user, AppUser friend){
        Relationship relationship = relationsipRepository.findByUser(user, friend).orElseThrow(()-> new IllegalStateException("these are not friends"));
        relationsipRepository.delete(relationship);
    }

    @Transactional
    public void updateRelationship(AppUser user, AppUser friend, String status){
        Relationship relationship = relationsipRepository.findByUser(user, friend).orElseThrow(()-> new IllegalStateException("these are not friends"));
        if(!Objects.equals(status, relationship.getStatus())){
            relationship.setStatus(status);
        }
    }
}
