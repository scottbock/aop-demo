package com.bock.aopdemo.aspect;

import com.bock.aopdemo.model.Cat;
import com.bock.aopdemo.model.Dog;
import com.bock.aopdemo.model.Pet;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class PetAspect {


    /**
     * Log what pet made a noise and from where
     */
    @Pointcut("within(com.bock.aopdemo.service.*)")
    public void inAopDemoService(){}

    @Pointcut("execution(String makeNoise(..))")
    public void makeNoiseMethod() {}

    @After("inAopDemoService() && makeNoiseMethod() && args(pet)")
    public void afterNoiseMade(JoinPoint joinPoint, Pet pet){
        System.out.println(pet.getName());
        System.out.println("What a racket " + joinPoint);
    }



    /**
     * Change Tigger to say bounce bounce
     */
    @Pointcut("execution(com.bock.aopdemo.model.Cat getTigger(..))")
    public void getTigger() {}

    @AfterReturning(
            pointcut="inAopDemoService() && getTigger()",
            returning="tigger")
    public void pantpant(Cat tigger) {
        tigger.setNoise("Bounce Bounce");
    }



    /**
     * Cujo barks a lot
     */
    @Pointcut("execution(* addNoise(..))")
    public void addNoise() {}

    @Around("inAopDemoService() && addNoise() && args(dog)")
    public void meanDog(ProceedingJoinPoint pjp, Dog dog) throws Throwable {

        for(int i = 0; i < 100; i ++){
            pjp.proceed();
        }

    }



    /**
     * Garfield hates Mondays
     */
    @Pointcut("execution(com.bock.aopdemo.model.Cat getGarfield(..))")
    public void getGarfield() {}

    @AfterReturning(
            pointcut="inAopDemoService() && getGarfield()",
            returning="garfield")
    public void monday(Cat garfield) {
        garfield.setNoise("I hate Mondays");
    }



    /**
     * Garfield is Sarcastic to John
     */
    @Pointcut("within(com.bock.aopdemo.service.arbuckle.*)")
    public void inAopDemoServiceArbuckle(){}

    @AfterReturning(
            pointcut="inAopDemoServiceArbuckle() && getGarfield()",
            returning="garfield")
    public void sarcasm(Cat garfield) {
        garfield.setNoise("I love Mondays!!!");
    }


    /**
     * Change Odie to say pant pant everywhere
     */
    @Pointcut("within(com.bock.aopdemo.service..*)")
    public void inAopDemoServiceOrSubPackage(){}

    @Pointcut("execution(com.bock.aopdemo.model.Dog getOdie(..))")
    public void getOdie() {}

    @AfterReturning(
            pointcut="inAopDemoServiceOrSubPackage() && getOdie()",
            returning="odie")
    public void pantpant(Dog odie) {
        odie.setNoise("Pant Pant");
    }
}
