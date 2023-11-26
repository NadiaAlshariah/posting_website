package posting_website;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Relationships {

    @Id
    private Long user_id;
    @Id
    private Long post_id;

    private String status;
}
