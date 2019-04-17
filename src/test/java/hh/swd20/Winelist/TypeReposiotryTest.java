package hh.swd20.Winelist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Winelist.domain.Type;
import hh.swd20.Winelist.domain.TypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TypeReposiotryTest {

    @Autowired
    private TypeRepository repository;

    @Test
    public void findByNameShouldReturnGenre() {
        List<Type> types = repository.findByName("Dopff au Moulin");
      
        assertThat(types).hasSize(1);
        
    } 

}
