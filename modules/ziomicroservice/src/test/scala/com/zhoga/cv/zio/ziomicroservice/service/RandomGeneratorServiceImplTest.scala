package com.zhoga.cv.zio.ziomicroservice.service

import zio.test.*
import zio.test.Assertion.equalTo


object RandomGeneratorServiceImplTest extends ZIOSpecDefault:
  def spec = {
    suite("random generator service test") {
      test("RandomGenerator service should provide random number back") {
        for {
          _ <- TestRandom.setSeed(42L)
          randomFactor <- RandomGeneratorServiceImpl().generateRandomFactor()
        } yield assert(randomFactor)(equalTo(9))
      }
    }
  }
