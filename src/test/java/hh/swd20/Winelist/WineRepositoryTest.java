package hh.swd20.Winelist;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Winelist.domain.Type;
import hh.swd20.Winelist.domain.Wine;
import hh.swd20.Winelist.domain.WineRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WineRepositoryTest {

    @Autowired
    private WineRepository repository;

    @Test
    public void findByNameShouldReturnWine() {
    	List<Wine> wines = repository.findByName("Dopff au Moulin");
        
        assertThat(wines).hasSize(1);
        assertThat(wines.get(0).getOrigin()).isEqualTo("France");
    }
    
    @Test
    public void createNewWine() {
    	Wine wine = new Wine("Wine", "France", 2018, "afsfs", new Type("Red"));
    	repository.save(wine);
    	assertThat(wine.getId()).isNotNull();
    }   

}
