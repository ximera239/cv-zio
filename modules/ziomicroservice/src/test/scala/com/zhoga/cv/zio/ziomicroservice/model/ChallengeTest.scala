package com.zhoga.cv.zio.ziomicroservice.model

import zio.test.*
import zio.json.*

object ChallengeTest extends ZIOSpecDefault:
  def spec = {
    suite("Challenge encode/decoder") {
      test("from class to json") {
        assertTrue(Challenge(2, 3).toJson == """{"valueA":2,"valueB":3}""")
      }
      test("from json to class") {
        assertTrue("""{"valueA":2,"valueB":3}""".fromJson[Challenge].exists(_ == Challenge(2, 3)))
      }
    }

  }
