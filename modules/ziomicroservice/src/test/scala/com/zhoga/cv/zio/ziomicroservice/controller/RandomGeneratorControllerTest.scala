package com.zhoga.cv.zio.ziomicroservice.controller

import com.zhoga.cv.zio.ziomicroservice.model.Challenge
import com.zhoga.cv.zio.ziomicroservice.service.{ChallengeServiceImpl, RandomGeneratorServiceImpl}
import zio.http.*
import zio.http.{Request, URL}
import zio.json.*
import zio.test.*
import zio.test.{TestRandom, ZIOSpecDefault}
import zio.test.Assertion.equalTo


object RandomGeneratorControllerTest extends ZIOSpecDefault:
  def spec = {
    suite("Test random generator controller") {
      test("controller should return correct response when requested for a new challenge") {
        TestRandom.setSeed(42L)
        val app = ChallengeController()
        val req = Request.get(URL(Root / "challenge" / "random"))
        assertZIO(app.runZIO(req).map(_.body))(equalTo(Response.json(Challenge(3, 8).toJson).body))
      }
    }.provide(
      RandomGeneratorServiceImpl.layer,
      ChallengeServiceImpl.layer,
    )
  }
