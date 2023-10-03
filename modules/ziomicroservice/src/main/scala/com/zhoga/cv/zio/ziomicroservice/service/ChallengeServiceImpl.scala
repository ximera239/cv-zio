package com.zhoga.cv.zio.ziomicroservice.service

import com.zhoga.cv.zio.ziomicroservice.model.Challenge
import zio.{UIO, ZIO, ZLayer}

class ChallengeServiceImpl(randomGeneratorService: RandomGeneratorService)
  extends ChallengeService:
  override def createRandomMultiplication(): UIO[Challenge] = {
    for {
      valueA <- randomGeneratorService.generateRandomFactor()
      valueB <- randomGeneratorService.generateRandomFactor()
    } yield Challenge(valueA = valueA, valueB = valueB)
  }

object ChallengeServiceImpl:
  val layer: ZLayer[RandomGeneratorService, Nothing, ChallengeServiceImpl] = ZLayer(
    ZIO.service[RandomGeneratorService].map(generator => ChallengeServiceImpl(generator))
  )

