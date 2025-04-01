package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class StudyCafePassOrderTest {

    @DisplayName("고정석 12주권에 사물함을 사용하면 할인 가격은 105000원이다.")
    @Test
    void getDiscountPrice() {
        //given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        //when
        int discountPrice = order.getDiscountPrice();

        //then
        assertThat(discountPrice).isEqualTo(105000);
    }

    @DisplayName("선택한 이용권의 할인률이 0.0이면 할인 가격은 0원이다.")
    @Test
    void getDiscountPriceWithNoDiscount() {
        //given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 8, 11000, 0);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        //when
        int discountPrice = order.getDiscountPrice();

        //then
        assertThat(discountPrice).isEqualTo(0);
    }

    @DisplayName("고정석 12주권에 사물함을 사용하면 전체 가격은 625000원이다.")
    @Test
    void getTotalPrice() {
        //given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        //when
        int totalPrice = order.getTotalPrice();

        //then
        assertThat(totalPrice).isEqualTo(625000);
    }

    @DisplayName("Order 생성 시 lockerPass가 없으면(사물함을 선택하지 않으면) 빈 Optional을 반환한다.")
    @Test
    void getLockerPass() {
        //given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        //when
        Optional<StudyCafeLockerPass> lockerPass = order.getLockerPass();

        //then
        assertThat(lockerPass.isEmpty()).isTrue();
    }
}