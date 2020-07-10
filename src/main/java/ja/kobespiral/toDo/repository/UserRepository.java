package ja.kobespiral.toDo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ja.kobespiral.toDo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * 名前で検索
     * 
     * @param name 検索する名前・LIKEで検索"%板谷%"
     * @return
     */
    public Iterable<User> findUserByNameLike(String name);

    // uidで検索 一意なはず

    public User findUserByUid(String uid);

}