package example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class PasswordValidatorTest {
    @DisplayName("비밀번호가 8자 이상 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatorTest() {
        assertThatCode(() -> PasswordValidator.validate("password"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"passwor", "passwordwordw"})
    void validatePasswordTest(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 8자 이상 12자 이하여야 한다.");
    }
}