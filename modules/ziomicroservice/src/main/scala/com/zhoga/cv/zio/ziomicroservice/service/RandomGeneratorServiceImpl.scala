package com.zhoga.cv.zio.ziomicroservice.service

import com.zhoga.cv.zio.ziomicroservice.service.RandomGeneratorServiceImpl.{MAXIMUM_FACTOR, MINIMUM_FACTOR}
import zio.{Random, UIO, ZLayer}

class RandomGeneratorServiceImpl() extends RandomGeneratorService:
  override def generateRandomFactor(): UIO[Int] = Random.nextIntBetween(MINIMUM_FACTOR, MAXIMUM_FACTOR)

object RandomGeneratorServiceImpl:
  val MAXIMUM_FACTOR = 10
  val MINIMUM_FACTOR = 1

  val layer: ZLayer[Any, Nothing, RandomGeneratorServiceImpl] = ZLayer.succeed(RandomGeneratorServiceImpl())