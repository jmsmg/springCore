package hello.core.discount;

import static org.junit.jupiter.api.Assertions.*;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

  RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP는 10% 할인이 적용되어야 한다")
  void vip_o() {
    //given
    Member member = new Member(1L, "mebmerVIP", Grade.VIP);
    //when
    int discount = rateDiscountPolicy.discount(member, 10000);
    //then
    Assertions.assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("VIP는 10% 할인이 적용되지 않아야 한다")
  void vip_x() {
    //given
    Member member = new Member(2L, "mebmerBASIC", Grade.BASIC);

    //when
    int discount = rateDiscountPolicy.discount(member, 10000);

    //then
    Assertions.assertThat(discount).isEqualTo(0);
  }
}