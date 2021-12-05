package jsonplaceholder.simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class GetPostWithRampUsersSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Get Post")
      .exec(
        http("get_post_request")
          .get("/posts/1")
      )

  setUp(scn.inject(
    rampUsers(10) during(5))
    .protocols(httpProtocol))
}
