/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ericliu

import com.android.tools.lint.checks.infrastructure.TestFiles.java
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import com.ericliu.lint.SampleCodeDetector
import org.junit.Test

@Suppress("UnstableApiUsage")
class SampleCodeDetectorTest {
    @Test
    fun testBasic() {
        lint().files(
            java(
                """
                    package test.pkg;
                    public class TestClass1 {
                        // In a comment, mentioning "lint" has no effect
                        private static String s1 = "Ignore non-word usages: linting";
                        private static String s2 = "Let's say it: book";
                    }
                    """
            ).indented()
        )
            .issues(SampleCodeDetector.ISSUE)
            .run()
            .expect(
                """
                    src/test/pkg/TestClass1.java:5: Warning: This code mentions book: Congratulations [SampleId]
                        private static String s2 = "Let's say it: book";
                                                   ~~~~~~~~~~~~~~~~~~~~
                    0 errors, 1 warnings
                    """
            )
    }
}
