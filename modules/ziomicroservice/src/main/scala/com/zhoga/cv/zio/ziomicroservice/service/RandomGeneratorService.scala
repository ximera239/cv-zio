package com.zhoga.cv.zio.ziomicroservice.service

import zio.{UIO, ZIO}

trait RandomGeneratorService:
  def generateRandomFactor(): UIO[Int]


object RandomGeneratorService:
  def generateRandomFactor(): ZIO[RandomGeneratorService, Nothing, Int] =
    ZIO.serviceWithZIO[RandomGeneratorService](_.generateRandomFactor())