package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StudyCafeSeatPassTest {

    @Test
    @DisplayName("lockerPass와 해당 seatPass의 passType과 duration이 동일하면 true를 반환한다.")
    void isSameDurationType() {
        //given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        //when
        boolean isSameDurationType = seatPass.isSameDurationType(lockerPass);

        //then
        assertThat(isSameDurationType).isTrue();
    }

    @Test
    @DisplayName("lockerPass와 해당 seatPass의 passType과 duration중 하나라도 다르면 false를 반환한다.")
    void isNotSameDurationType() {
        //given
        StudyCafeSeatPass seatPass1 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 12, 13000, 0);
        StudyCafeSeatPass seatPass2 = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1);
        StudyCafeSeatPass seatPass3 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 8, 11000, 0);

        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

        //when
        boolean isSameDurationType1 = seatPass1.isSameDurationType(lockerPass);
        boolean isSameDurationType2 = seatPass2.isSameDurationType(lockerPass);
        boolean isSameDurationType3 = seatPass3.isSameDurationType(lockerPass);

        //then
        assertThat(isSameDurationType1).isFalse();
        assertThat(isSameDurationType2).isFalse();
        assertThat(isSameDurationType3).isFalse();
    }

    @DisplayName("고정석 4주권을 선택하면 할인 가격은 25000원이다.")
    @Test
    void getDiscountPrice() {
        //given
        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 250000, 0.1);

        //when
        int discountPrice = studyCafeSeatPass.getDiscountPrice();

        //then
        assertThat(discountPrice).isEqualTo(25000);
    }

}