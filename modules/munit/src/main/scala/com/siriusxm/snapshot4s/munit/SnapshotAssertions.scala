/*
 * Copyright 2024 SiriusXM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package snapshot4s.munit

import _root_.munit.Location
import _root_.munit.diff.DiffOptions

import snapshot4s.{ResultLike, SnapshotAssertions as CoreSnapshotAssertions, SnapshotEq}

trait SnapshotAssertions extends CoreSnapshotAssertions[Unit] {

  implicit def snapshotEq[A]: SnapshotEq[A] = SnapshotEq.fromUniversalEquals

  implicit def munitResultLike[A](implicit
      loc: Location,
      diffOptions: DiffOptions
  ): ResultLike[A, Unit] =
    MunitResultLike.resultLike[A](loc, diffOptions)
}

object SnapshotAssertions extends SnapshotAssertions
