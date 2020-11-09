AOP

aspect = pointcut (where) + advice (what)

    @Before("execution(void doSomething())")
    public void enter(){
        logger.trace("Hello World");
    }

Here,
Before is the before advice

- point cut = where = void doSomething

- what = enter() method's logic

if aspect itself throws exception, exception will be propagated to the original caller

    execution(* * (..)) 
- means method of any return type, of any package (all methods), any parameter type

    joinPoint = gives information about class, method etc

    @Before("execution(void doSomething())")
    public void enter(JoinPoint joinPoint){
        logger.trace("entering"+joinPoint.getStaticPart().getSignature().toString());
    }

After advice will run even if the method throws exception

    @AfterThrowing(pointcut="execution(void doSomething())", throwing="ex")
    public void logException(RuntimeException e){
        //TODO
    }

afterThrowing cannot stop the exception being thrown to the original caller
After return - only successful return (cant change result, cannot throw exceptions)

Around

only to avoid the original method being called - (without throwing exception with beforeAdvice) = Around

- only advice that can catch exceptions
- only advice that can modify return type
- uses proceedingJoinPoint
examples :
    execution(* com.bkash..*Service.*(..))
    execution(* *.*(..))
    execution(* *..*.*(..))