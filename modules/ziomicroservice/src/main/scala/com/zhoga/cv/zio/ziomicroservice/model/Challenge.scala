package com.zhoga.cv.zio.ziomicroservice.model

import zio.json.{DeriveJsonDecoder, DeriveJsonEncoder, JsonDecoder, JsonEncoder}

case class Challenge(valueA: Int, valueB: Int)

object Challenge:
  given JsonEncoder[Challenge] = DeriveJsonEncoder.gen[Challenge]
  given JsonDecoder[Challenge] = DeriveJsonDecoder.gen[Challenge]
