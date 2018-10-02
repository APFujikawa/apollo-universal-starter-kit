package models.counter

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import graphql.GraphQLContext
import javax.inject.Inject
import monix.execution.{Ack, Scheduler}
import monix.reactive.subjects.ConcurrentSubject
import sangria.macros.derive._
import sangria.schema.{Action, Argument, Field, IntType, ObjectType}

case class Counter(amount: Int)

object Counter {

  import sangria.streaming.monix._
  import monix.reactive.Observable

  @Inject implicit var actorSystem: ActorSystem = _
  @Inject implicit var scheduler: Scheduler = _
  @Inject implicit var materializer: ActorMaterializer = _

  object Types {
    implicit val Сounter: ObjectType[Unit, Counter] = deriveObjectType(ObjectTypeName("Counter"))
  }

  object GraphQL {

    val Queries: List[Field[GraphQLContext, Unit]] = List(
      Field(
        name = "serverCounter",
        fieldType = Types.Сounter,
        resolve = sc => sc.ctx.counterResolver.serverCounter
      )
    )

    val Mutations: List[Field[GraphQLContext, Unit]] = List(
      Field(
        name = "addServerCounter",
        fieldType = Types.Сounter,
        arguments = Argument(name = "amount", argumentType = IntType) :: Nil,
        resolve = sc => {
          val amount = sc.args.arg[Int]("amount")
          sc.ctx.counterResolver.addServerCounter(amount)
        }
      )
    )

    val Subscriptions: List[Field[GraphQLContext, Unit]] = List(
      Field.subs(
        name = "counterUpdated",
        fieldType = Types.Сounter,
        resolve = _ => source.map(Action(_))
      )
    )
    val source: ConcurrentSubject[Counter, Counter] = ConcurrentSubject.publish[Counter]
  }
}