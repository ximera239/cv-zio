package com.zhoga.cv.zio.ziomicroservice.service

import com.zhoga.cv.zio.ziomicroservice.model.Challenge
import zio.{UIO, ZIO}

trait ChallengeService:
  def createRandomMultiplication(): UIO[Challenge]

object ChallengeService:
  def createRandomMultiplication(): ZIO[ChallengeService, Nothing, Challenge] =
    ZIO.serviceWithZIO[ChallengeService](_.createRandomMultiplication())
