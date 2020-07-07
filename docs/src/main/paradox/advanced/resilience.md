# Resilience 

## Actor may crash

Actor define
: @@snip [ActorTwo](/src/main/scala/akkadesign/advance/ActorFive.scala)

Child Actor define
: @@snip [ActorTwo](/src/main/scala/akkadesign/start/ActorTwo.scala)

Test
: @@snip [Testactor](/src/main/scala/akkadesign/test/TestActorFive.scala)

Testlog
: @@snip [TestLog](../log/result5.log)

Actor start failed, all messages are in dead letter mailbox

Actor define
: @@snip [ActorTwo](/src/main/scala/akkadesign/advance/ActorFive.scala)

Child Actor define
: @@snip [ActorTwo](/src/main/scala/akkadesign/start/ActorTwo.scala)

Test
: @@snip [Testactor](/src/main/scala/akkadesign/test/TestActorFive2.scala)

Testlog
: @@snip [TestLog](../log/result5.2.log)


For Actor start may failed, so getActorFive function will try to create ActorFive, 
there will have multiple timeout response for not create actor failed and finally success.

##  Actor with supervisorStrategy

Actor define
: @@snip [ActorSix](/src/main/scala/akkadesign/advance/ActorSix.scala)

Child Actor define
: @@snip [ActorFive](/src/main/scala/akkadesign/advance/ActorFive.scala)

Test
: @@snip [Testactor](/src/main/scala/akkadesign/test/TestActorSix.scala)

Testlog
: @@snip [TestLog](../log/result6.1.log)


What's happened?

ActorFive is a child Actor of ActorSix, for ActorSix start, try to start ActorFive, after 20 times failed for ActorFive
 start, all messages to ActorFive are redirect to dead letter for supervisorStrategy. 

And after that ActorSix receive Crash message to restart itself. Then after 20 times failed to start ActorFive. 
The messages to the actor are moved to dead letter mailbox for bad luck.