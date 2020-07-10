package ja.kobespiral.toDo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long uid;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}