package jsonplaceholder.simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class UpdatePostSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Update Post")
      .exec(
        http("update_request")
          .patch("/posts/1")
          .body(StringBody("{title: 'Updated title'}"))
      )

  setUp(scn.inject(
    atOnceUsers(20))
    .protocols(httpProtocol))
}
