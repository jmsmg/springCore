package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

  public static void main(String[] args) {

//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();
//    OrderService orderService = appConfig.orderService();

    ApplicationContext applicationContextContext = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService memberService = applicationContextContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContextContext.getBean("orderService", OrderService.class);


    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

//    System.out.println(member.getId());
    Order order = orderService.createOrder(1L, "itemA", 10000);

    System.out.println(order);
  }
}
