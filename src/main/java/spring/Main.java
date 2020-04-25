package spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.impl.audio.Alpine;
import spring.impl.car.Audi;
import spring.impl.car.Kia;
import spring.impl.car.Lexus;

public class Main {

    public static void main( String[] args )
    {
        ApplicationContext  ctx = new AnnotationConfigApplicationContext(Config.class);

        Audi audi = ctx.getBean(Audi.class);
        audi.move();
        audi.getNavigationSystem().createRoute();
        audi.getAudioSystem().playRadio();


        ctx.getBean(Kia.class).move();
        ctx.getBean(Audi.class).move();
        ctx.getBean(Audi.class).getAudioSystem().playCD();
        ctx.getBean(Audi.class).getNavigationSystem().createRoute();

        Lexus lexus = ctx.getBean(Lexus.class);
        lexus.move();
        lexus.getAudioSystem().playCD();
    }
}
