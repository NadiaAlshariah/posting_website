package posting_website.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posting_website.model.AppUser;
import posting_website.model.Relationship;
import posting_website.repository.RelationshipRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RelationshipService {
    private final RelationshipRepository relationshipRepository;

    @Autowired
    public RelationshipService(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    public List<Relationship> getRelationships(){return relationshipRepository.findAll();}

    public void addRelationship(Relationship relationship){
        Optional<Relationship> relationshipOptional = relationshipRepository.findByUser(relationship.getUser(), relationship.getFriend());
        if(relationshipOptional.isPresent()){
            throw new IllegalStateException("Already added");
        }
        relationshipRepository.save(relationship);
    }

    public void deleteRelationship(AppUser user, AppUser friend){
        Relationship relationship = relationshipRepository.findByUser(user, friend).orElseThrow(()-> new IllegalStateException("these are not friends"));
        relationshipRepository.delete(relationship);
    }

    @Transactional
    public void updateRelationship(AppUser user, AppUser friend, String status){
        Relationship relationship = relationshipRepository.findByUser(user, friend).orElseThrow(()-> new IllegalStateException("these are not friends"));
        if(!Objects.equals(status, relationship.getStatus())){
            relationship.setStatus(status);
        }
    }
}
