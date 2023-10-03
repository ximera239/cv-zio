package com.zhoga.cv.zio.ziomicroservice.controller

/*_*/import com.zhoga.cv.zio.ziomicroservice.service.ChallengeService/*_*/
import zio.http.*
import zio.json.*

object ChallengeController:
  def apply(): Http[ChallengeService, Throwable, Request, Response] =
    Http.collectZIO[Request] { case Method.GET -> Root / "challenge" / "random" =>
      ChallengeService
        .createRandomMultiplication()
        .map(response => Response.json(response.toJson))
    }
