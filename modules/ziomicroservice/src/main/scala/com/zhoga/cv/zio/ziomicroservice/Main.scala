package com.zhoga.cv.zio.ziomicroservice

import com.zhoga.cv.zio.ziomicroservice.controller.ChallengeController
import com.zhoga.cv.zio.ziomicroservice.service.{ChallengeServiceImpl, RandomGeneratorServiceImpl}
import zio.http.Server
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object Main extends ZIOAppDefault:
  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] =
    val httpApps = ChallengeController()
    Server
      .serve(httpApps.withDefaultErrorResponse)
      .provide(
        Server.defaultWithPort(8080),
        RandomGeneratorServiceImpl.layer,
        ChallengeServiceImpl.layer,
      )

