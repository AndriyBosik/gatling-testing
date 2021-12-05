package jsonplaceholder.simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class GetPostCommentsSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Get Post Comments")
      .exec(
        http("get_post_comments")
          .get("/posts/1/comments")
      )

  setUp(scn.inject(
    constantUsersPerSec(10).during(5))
    .protocols(httpProtocol))
}
