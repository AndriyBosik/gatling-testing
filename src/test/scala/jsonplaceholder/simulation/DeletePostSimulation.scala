package jsonplaceholder.simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class DeletePostSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Delete Post")
      .exec(
        http("delete_request")
          .delete("/posts/1")
      )

  setUp(scn.inject(
    atOnceUsers(20))
    .protocols(httpProtocol))
}
