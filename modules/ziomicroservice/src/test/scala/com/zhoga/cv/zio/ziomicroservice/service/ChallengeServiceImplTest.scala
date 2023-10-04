package com.zhoga.cv.zio.ziomicroservice.service

import com.zhoga.cv.zio.ziomicroservice.model.Challenge
import zio.ZIO
import zio.test.*
import zio.test.Assertion.equalTo

object ChallengeServiceImplTest extends ZIOSpecDefault:
  def spec = {
    suite("RandomGenerator service test") {
      test("RandomGenerator service should provide random numbers back") {
        for {
          _ <- TestRandom.setSeed(42L)
          service <- ZIO.service[RandomGeneratorService]
          challenge <- ChallengeServiceImpl(service).createRandomMultiplication()
        } yield assert(challenge)(equalTo(Challenge(9, 4)))
      }
    }.provideLayer(RandomGeneratorServiceImpl.layer)
  }
