package de.htwberlin;

import de.htwberlin.persistence.Gender;
import de.htwberlin.persistence.PersonEntity;
import de.htwberlin.persistence.PetEntity;
import org.assertj.core.api.WithAssertions;
import de.htwberlin.service.PersonTransformer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class PersonTransformerTest implements WithAssertions {

    private final PersonTransformer underTest = new PersonTransformer();

    @Test
    @DisplayName("should transform PersonEntity to Person")
    void should_transform_person_entity_to_person() {
        // given
        var personEntity = Mockito.mock(PersonEntity.class);
        doReturn(111L).when(personEntity).getId();
        doReturn("John").when(personEntity).getFirstname();
        doReturn("Doe").when(personEntity).getLastname();
        doReturn(true).when(personEntity).isVaccinated();
        doReturn(Gender.MALE).when(personEntity).getGender();
        doReturn(List.of(new PetEntity())).when(personEntity).getPets();

        // when
        var result = underTest.transformEntity(personEntity);

        // then
        assertThat(result.getId()).isEqualTo(111);
        assertThat(result.getFirstname()).isEqualTo("John");
        assertThat(result.getLastname()).isEqualTo("Doe");
        assertThat(result.isVaccinated()).isEqualTo(true);
        assertThat(result.getGender()).isEqualTo("MALE");
        assertThat(result.getPets()).hasSize(1);
    }
}
