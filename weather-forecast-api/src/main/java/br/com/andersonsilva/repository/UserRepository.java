package br.com.andersonsilva.repository;

import br.com.andersonsilva.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u from User u where u.numberFone=:numberFone AND u.passWord=:passWord")
    public User findAllUser(@Param("numberFone") String numberFone,@Param("passWord") String passWord);
    @Query("SELECT u from User u where u.numberFone=:numberFone AND u.passWord=:passWord")
    public User findDelete(@Param("numberFone") String numberFone,@Param("passWord") String passWord);
    @Transactional
    @Modifying
    @Query("update User u set u.numberFone = ?3,u.email = ?4, u.nameUse =?5 ,u.passWord = ?6 where u.numberFone = ?1 AND u.passWord=?2  ")
    void findUpdate(@Param("numberFone") String numberFone, @Param("passWord") String passWord,
                    @Param("newNumberFone") String newNumberFone,
                    @Param("newEmail") String newEmail,
                    @Param("nameUse") String nameUse,
                    @Param("newPassWord") String newPassWord

    );
    @Query("SELECT u from User u where u.numberFone=:numberFone AND u.passWord=:passWord")
    public User findUser(@Param("numberFone") String numberFone,@Param("passWord") String passWord);

}
