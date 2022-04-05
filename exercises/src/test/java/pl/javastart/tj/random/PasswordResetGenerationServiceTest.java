package pl.javastart.tj.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class PasswordResetGenerationServiceTest {

    @Mock RandomTextGenerator randomTextGenerator;

    private PasswordResetGenerationService passwordResetGenerationService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        passwordResetGenerationService = new PasswordResetGenerationService(randomTextGenerator);

        when(randomTextGenerator.getRandomText()).thenReturn("f32mr1rm892ng92r12");
    }

    @Test
    public void shouldReturnPasswordResetMessage(){

        //when
        String message = passwordResetGenerationService.preparePasswordResetMesage();

        //then
        assertThat(message).isEqualTo("Cześć, aby przejść do resetowania hasła naciśnij <a href=\"https://example.com/reset?key=f32mr1rm892ng92r12\">ten link</a>");
    }

    @Test
    public void shouldNotPasswordMessageBeNonNull(){
        String passwordResetMesage = passwordResetGenerationService.preparePasswordResetMesage();

        assertThat(passwordResetMesage).isNotNull();
    }

}