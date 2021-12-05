package jsonplaceholder.simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class CreatePostSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Create Post")
      .exec(
        http("create_post_request")
          .post("/posts")
          .body(StringBody(
            """{title: 'New post',
              |body: 'Post description...',
              |userId: 1}""".stripMargin))
      )

  setUp(scn.inject(
    rampUsersPerSec(5) to 10 during 10)
    .protocols(httpProtocol))
}
