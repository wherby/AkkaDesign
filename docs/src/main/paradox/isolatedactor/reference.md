# Restarting for child actor

The section is from [Akka doc](https://doc.akka.io/docs/akka/current/typed/fault-tolerance.html#child-actors-are-stopped-when-parent-is-restarting)

Child actors are stopped when parent is restarting
Child actors are often started in a setup block that is run again when the parent actor is restarted. The child actors are stopped to avoid resource leaks of creating new child actors each time the parent is restarted.

```Scala
def child(size: Long): Behavior[String] =
  Behaviors.receiveMessage(msg => child(size + msg.length))

def parent: Behavior[String] = {
  Behaviors
    .supervise[String] {
      Behaviors.setup { ctx =>
        val child1 = ctx.spawn(child(0), "child1")
        val child2 = ctx.spawn(child(0), "child2")

        Behaviors.receiveMessage[String] { msg =>
          // message handling that might throw an exception
          val parts = msg.split(" ")
          child1 ! parts(0)
          child2 ! parts(1)
          Behaviors.same
        }
      }
    }
    .onFailure(SupervisorStrategy.restart)
}
```

It is possible to override this so that child actors are not influenced when the parent actor is restarted. The restarted parent instance will then have the same children as before the failure.

If child actors are created from setup like in the previous example and they should remain intact (not stopped) when parent is restarted the supervise should be placed inside the setup and using SupervisorStrategy.restart.withStopChildren(false) like this:

```Scala
def parent2: Behavior[String] = {
  Behaviors.setup { ctx =>
    val child1 = ctx.spawn(child(0), "child1")
    val child2 = ctx.spawn(child(0), "child2")

    // supervision strategy inside the setup to not recreate children on restart
    Behaviors
      .supervise {
        Behaviors.receiveMessage[String] { msg =>
          // message handling that might throw an exception
          val parts = msg.split(" ")
          child1 ! parts(0)
          child2 ! parts(1)
          Behaviors.same
        }
      }
      .onFailure(SupervisorStrategy.restart.withStopChildren(false))
  }
}
```

That means that the setup block will only be run when the parent actor is first started, and not when it is restarted.