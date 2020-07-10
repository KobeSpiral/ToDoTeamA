package ja.kobespiral.toDo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ToDo {
    // DB用ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //ユーザーID
    private String uid;

    // ToDo名
    private String title;

    // 詳細
    private String description;

    //終了していない
    private boolean isOpen;

    // 作成日時
    @CreationTimestamp
    private Date createdAt;

    // 締め切り
    private Date limitAt;

    //更新日時
    @UpdateTimestamp
    private Date updatedAt;

    //終了日時
    private Date doneAt;
}