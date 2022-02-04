package com.ericliu.lint

import com.android.tools.lint.detector.api.*

class MyDetector : Detector(), SourceCodeScanner {
    override fun run(context: Context) {
        context.report(
            ISSUE, Location.create(context.file),
            "I complain a lot"
        )
    }

    companion object {
        /**
         * Issue describing the problem and pointing to the detector
         * implementation.
         */
        @JvmField
        val ISSUE: Issue = Issue.create(
            // ID: used in @SuppressLint warnings etc
            id = "SampleId",
            // Title -- shown in the IDE's preference dialog, as category headers in the
            // Analysis results window, etc
            briefDescription = "Lint Mentions",
            // Full explanation of the issue; you can use some markdown markup such as
            // `monospace`, *italic*, and **bold**.
            explanation = """
                    This check highlights string literals in code which mentions the word `lint`. \
                    Blah blah blah.

                    Another paragraph here.
                    """, // no need to .trimIndent(), lint does that automatically
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                MyDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

}