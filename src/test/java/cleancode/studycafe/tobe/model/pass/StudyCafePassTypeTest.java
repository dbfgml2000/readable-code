package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StudyCafePassTypeTest {

    @DisplayName("고정석은 사물함을 사용할 수 있다.")
    @Test
    void isLockerType() {
        //given
        StudyCafePassType passType = StudyCafePassType.FIXED;

        //when
        boolean isLockerType = passType.isLockerType();

        //then
        assertThat(isLockerType).isTrue();

    }

    @DisplayName("고정석이 아니면 사물함을 사용할 수 없다.")
    @Test
    void isNotLockerType() {
        //given
        StudyCafePassType passType1 = StudyCafePassType.HOURLY;
        StudyCafePassType passType2 = StudyCafePassType.WEEKLY;

        //when
        boolean isLockerType1 = passType1.isNotLockerType();
        boolean isLockerType2 = passType2.isNotLockerType();

        //then
        assertThat(isLockerType1).isTrue();
        assertThat(isLockerType2).isTrue();

    }
}