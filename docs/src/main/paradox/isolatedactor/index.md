# Isolate error

@@@ index

 * [About restart](./reference.md)

@@@

## Version 1

Store status in child actor, and parent actor may fail.

Actor define
: @@snip [ActorTwo](/src/main/scala/akkadesign/start/ActorThree.scala)

Child Actor define
: @@snip [ActorTwo](/src/main/scala/akkadesign/start/ActorTwo.scala)

Test
: @@snip [Testactor](/src/main/scala/akkadesign/test/TestActorThree.scala)

Testlog
: @@snip [TestLog](../log/result3.log)

Parent Actor will restart child actor by default.

## Version 2

Store status in another actor, no relationship with actor which may fail.

Actor define
: @@snip [ActorTwo](/src/main/scala/akkadesign/start/ActorFour.scala)

Another Actor define
: @@snip [ActorTwo](/src/main/scala/akkadesign/start/ActorTwo.scala)

Test
: @@snip [Testactor](/src/main/scala/akkadesign/test/TestActorFour.scala)

Testlog
: @@snip [TestLog](../log/result4.log)

