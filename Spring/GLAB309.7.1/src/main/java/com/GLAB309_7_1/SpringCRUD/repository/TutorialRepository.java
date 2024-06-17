package com.GLAB309_7_1.SpringCRUD.repository;

import com.GLAB309_7_1.SpringCRUD.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*we used JpaRepository’s methods: save(), findOne(),
findById(), findAll(), count(), delete(), deleteById() without implementing
these methods.
We also defined custom finder methods named findByPublished(), which
returns all Tutorials with published having value as input published.
*/
public interface TutorialRepository extends JpaRepository<Tutorial, Long>
// Tutorial → Entity type and Long --> primary key
{
    // findByPublished is a custom method()
    List<Tutorial> findByPublished(boolean published);
}
