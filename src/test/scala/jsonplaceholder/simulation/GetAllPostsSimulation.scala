package jsonplaceholder.simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class GetAllPostsSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Get All Posts")
      .exec(
        http("get_posts_request")
          .get("/posts")
      )

  setUp(scn.inject(
    atOnceUsers(10))
    .protocols(httpProtocol))
}
